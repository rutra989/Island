package island;

import lombok.Getter;
import lombok.Setter;
import organism.Animal;
import organism.AnimalType;
import organism.Organism;
import organism.Plants;
import servise.Parameters;
import servise.Statistic;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

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
    public Void call(){
        try {
            runTick();
        }catch (Exception e){
            System.out.println("Ошибка в LocationTask: " + e.getMessage());
            e.printStackTrace();
        }
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
                predator.tickHunger();
                continue;
            }
            // ищем жертву - это может быть и растение
            for (Organism prey : predator.getFoodList(location)) {
               if( predator.eat(prey)) {
                   break;
               }
            }
                predator.tickHunger();
        }
    }

    // метод симуляции рождения
    private void runReproduce(Location location) {
        for (Animal animal : location.getAnimals()) {
            AnimalType type = animal.getAnimalType(); // получаем тип животного
            int born =  location.getBornThisTick().getOrDefault(type, 0); // получаем количество рожденных животных
            int limit = Parameters.getInstance().getNumberCubs().get(type); //получаем установленный лимит на новорожденных
            // проверяем есть ли место
            if (Statistic.getCurrentTick().get() == animal.getLastReproduceTick().get()) {
                continue;
            }
            //участвовало ли животное в размножении
            if (!location.hasSpace(type)){
                continue;
            }
            //не превышен ли лимит на новорожденных
            if (born >= limit){
                continue;
            }
            //  подбираем партнера
            for (Animal partner : location.getAnimals()) {
                // проверка на самого себя
                if (animal == partner) {
                    continue;
                }
                //если партнеры совпадают по типу - размножение
                if (type == partner.getAnimalType()) {
                    // инкриментируем новорожденного в bornThisTick
                    location.getBornThisTick().put(type, location.getBornThisTick().getOrDefault(type, 0) + 1);
                    // процесс рождения
                    Animal newborn = animal.reproduction();
                    newborn.getLastReproduceTick().set(Statistic.getCurrentTick().get());
                    location.addAnimal(newborn);
                    animal.getLastReproduceTick().set(Statistic.getCurrentTick().get());
                    partner.getLastReproduceTick().set(Statistic.getCurrentTick().get());
                    break;
                }
            }
        }
    }

    //метод симуляции движения
    private void runMove(Location location) {
        for (Animal animal : location.getAnimals()) {
            if (animal.getAnimalType().getMaxSpeed() == 0){
                continue;
            }
            // проверили, что животное не перемещалось в рамках тика
            if (Statistic.getCurrentTick().get() == animal.getLastProcessedTick().get()) {
                continue;
            }
            //переместили
            island.relocate(animal);
            animal.getLastProcessedTick().set(Statistic.getCurrentTick().get());
        }
    }

    //метод симуляции смерти
    private void runDead(Location location) {
        for (Animal animal : location.getAnimals()) {
            if (animal.isDead()) {
                Statistic.getDied().incrementAndGet();
                Statistic.getTotal().decrementAndGet();
                location.removeAnimal(animal);
            }
        }
        for (Plants plants : location.getPlants()) {
            if (plants.isDead()) {
                location.removePlants(plants);
            }
        }
    }

    //метод возобнавления растений
    private void runGrowPlants() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < island.getLocations().length; i++) {
            for (int j = 0; j < island.getLocations()[i].length; j++) {
                // ененрируем случайное число от количества свободного места
                int count = random.nextInt(island.getLocations()[i][j].freeSpacePlants() + 1);
                // создает растения в количестве сгенерировано числа
                while (count != 0) {
                    // создаем объект по указанным координатам
                    island.getLocations()[i][j].addPlants(new Plants());
                    count--;
                }
            }
        }
    }

    //метод запуска жизни в клетке
    private void lifeCycle(Location location) {
        location.resetBornThisTick();
        runEat(location);
        runDead(location);
        runReproduce(location);
        runMove(location);
        runGrowPlants();
    }

    //метод симуляции тика
    private void runTick() {
        for (int i = startRow; i <= endRow; i++) {
            for (int j = 0; j < island.getLocations()[i].length; j++) {
                lifeCycle(island.getLocations()[i][j]);
            }
        }

    }
}
