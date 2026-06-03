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

    public LocationTask( Island island, int startRow, int endRow) {
        this.island = island;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public Statistic call() throws Exception {


        return null;
    }

    // метод симуляции еды
    private void runEat(Location location){
        for (Animal predator : location.getAnimals()) {
            boolean ate = false; // флаг для проверки поел или нет
            if (!predator.isHungry()) { // проверка на голод
                continue;
            }
            for (Organism prey : predator.getFoodList(location)){
                if (predator.eat(prey)){
                    ate=true;
                    break;
                }
            }
            if (!ate){
                predator.tickHunger();
            }
        }
    }

    // метод симуляции рождения
    private void runReproduce(){

    }

    //метод симуляции движения
    private void runMove(){

    }

    //метод симуляции смерти
    private void runDead(){

    }
    //метод запуска жизни в клетке
    private void lifeCycle(Location location){
    runEat(location);
    runDead();
    runReproduce();
    runMove();
    }

    //метод симуляции тика
    private void runTick(Island island){
        for (int i = 0; i < island.getLocations().length; i++) {
            for (int j = 0; j < island.getLocations()[i].length; j++){

            }
        }

    }
}
