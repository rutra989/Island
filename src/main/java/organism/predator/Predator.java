package organism.predator;

import island.Location;
import organism.Animal;
import organism.Organism;
import organism.Animal_Type;

public class Predator extends Animal {


    public Predator(int x, int y, Animal_Type animalType) {
        super(x, y, animalType);
    }

    @Override
    public boolean eat(Organism organism) {
        return false;
    }

    @Override
    public void move(Location location) {

    }
}
