package island;

import lombok.Getter;
import lombok.Setter;
import organism.Animal;
import organism.Organism;
import organism.Plants;
import organism.predator.Predator;
import servise.Statistic;

import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Setter
public class LocationTask implements Callable<Statistic> {
    private Island island;
    private final int startRow;
    private final int endRow;

    public LocationTask(Island island, int startRow, int endRow) {
        this.island = island;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public Statistic call() throws Exception {


        return null;
    }

    // метод симуляции еды
    private void runEat(Location location) {
        for (Animal predator : location.getAnimals()) {
            if (predator.isDead()) {
                continue;
            }
            if (!predator.isHungry()) { // проверка на голод
                continue;
            }
            boolean ate = false; // флаг для проверки поел или нет
            for (Organism prey : predator.getFoodList(location)) {
                if (predator.eat(prey)) {
                    ate = true;
                    break;
                }
            }
            if (!ate) {
                predator.tickHunger();
            }
        }
    }

    // метод симуляции рождения
    private void runReproduce(Location location, int currentTick) {
        for (Animal animal : location.getAnimals()) {
            if (currentTick == animal.getLastReproduceTick()) {
                continue;
            }
            for (Animal partner : location.getAnimals()) {
                if (animal == partner) {
                    continue;
                }
                if (animal.getAnimalType() == partner.getAnimalType()) {
                    Animal newborn = animal.reproduction();
                    newborn.setLastReproduceTick(currentTick);
                    location.addAnimal(newborn);
                    animal.setLastReproduceTick(currentTick);
                    partner.setLastReproduceTick(currentTick);
                    break;
                }
            }
        }
    }

    //метод симуляции движения
    private void runMove(Location location, int currentTick) {

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
    private void lifeCycle(Location location, int currentTick) {
        runEat(location);
        runDead(location);
        runReproduce(location, currentTick);
        runMove(location, currentTick);
    }

    //метод симуляции тика
    private void runTick(Island island) {
        for (int i = 0; i < island.getLocations().length; i++) {
            for (int j = 0; j < island.getLocations()[i].length; j++) {

            }
        }

    }
}
