package organism.predator;

import island.Location;
import organism.Animal;
import organism.Organism;
import organism.Animal_Type;

import java.util.concurrent.ThreadLocalRandom;

public class Predator extends Animal {


    protected Predator(int x, int y, Animal_Type animalType) {
        super(x, y, animalType);
    }

    @Override
    public boolean eat(Organism organism) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return false;
    }

    @Override
    public void move(Location location) {

    }
}
