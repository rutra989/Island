package organism.herbivore;

import island.Location;
import organism.Animal;
import organism.Organism;
import organism.Animal_Type;
import organism.Plants;

import java.util.concurrent.ThreadLocalRandom;

public class Herbivore extends Animal {


    protected Herbivore(int x, int y, Animal_Type animalType) {
        super(x, y, animalType);
    }

    @Override
    public boolean eat(Organism organism) {
        Plants plant = (Plants) organism;
        if (getAnimalType().getMaxFood() < plant.getMaxWeight()) {
            setCurrentWeight(getCurrentWeight() + getAnimalType().getMaxFood());
            return true;
        }
        setCurrentWeight(getCurrentWeight() + plant.getMaxWeight());
        normalizeWeight();
        return true;
    }

    @Override
    public void move(Location location) {

    }
}
