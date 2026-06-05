package island;

import lombok.Getter;
import lombok.Setter;
import organism.Animal;
import organism.Organism;
import organism.Plants;
import servise.Statistic;

import java.util.concurrent.Callable;

@Getter
@Setter
public class LocationTask implements Callable<Void> {
    private Island island;
    private final int startRow;
    private final int endRow;

    public LocationTask(Island island, int startRow, int endRow) {
        this.island = island;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public Void call() throws Exception {
        runTick();
        return null;
    }

    // метод симуляции еды
    private void runEat(Location location) {
        // подбираем животное потребителя
        for (Animal predator : location.getAnimals()) {
            if (predator.isDead()) {
                continue;
            }
            if (!predator.isHungry()) { // проверка на голод
                continue;
            }
            boolean ate = false; // флаг для проверки поел или нет
            // ищем жертву - это может быть и растение
            for (Organism prey : predator.getFoodList(location)) {
                if (predator.eat(prey)) {
                    ate = true;
                    break;
                }
            }
            // если не поел, испытывает голод
            if (!ate) {
                predator.tickHunger();
            }
        }
    }

    // метод симуляции рождения
    private void runReproduce(Location location) {
        for (Animal animal : location.getAnimals()) {
            // проверяем есть ли место и не участвовало ли животное в размножении
            if (Statistic.getCurrentTick().get() == animal.getLastReproduceTick() || !location.hasSpace(animal.getAnimalType())) {
                continue;
            }
            for (Animal partner : location.getAnimals()) {
                // проверка на самого себя
                if (animal == partner) {
                    continue;
                }
                //если партнеры совпадают по типу - размножение
                if (animal.getAnimalType() == partner.getAnimalType()) {
                    Animal newborn = animal.reproduction();
                    newborn.setLastReproduceTick(Statistic.getCurrentTick().get());
                    location.addAnimal(newborn);
                    animal.setLastReproduceTick(Statistic.getCurrentTick().get());
                    partner.setLastReproduceTick(Statistic.getCurrentTick().get());
                    break;
                }
            }
        }
    }

    //метод симуляции движения
    private void runMove(Location location) {
    for (Animal animal : location.getAnimals()){
        // проверили, что животное не перемещалось в рамках тика
        if (Statistic.getCurrentTick().get() == animal.getLastProcessedTick()){
            continue;
        }
        //переместили
        island.relocate(animal);
        animal.setLastProcessedTick(Statistic.getCurrentTick().get());
    }
    }

    //метод симуляции смерти
    private void runDead(Location location) {
        for (Animal animal : location.getAnimals()) {
            if (animal.isDead()) {
                location.removeAnimal(animal);
            }
        }
        for (Plants plants : location.getPlants()) {
            if (plants.isDead()) {
                location.removePlants(plants);
            }
        }
    }

    //метод запуска жизни в клетке
    private void lifeCycle(Location location) {
        runEat(location);
        runDead(location);
        runReproduce(location);
        runMove(location);
    }

    //метод симуляции тика
    private void runTick() {
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < island.getLocations()[i].length; j++) {
            lifeCycle(island.getLocations()[i][j]);
            }
        }

    }
}
