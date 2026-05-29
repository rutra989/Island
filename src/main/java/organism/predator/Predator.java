package organism.predator;

import island.Location;
import organism.Animal;
import organism.Organism;
import organism.Animal_Type;

import java.util.concurrent.ThreadLocalRandom;

public class Predator extends Animal {


    public Predator(int x, int y, Animal_Type animalType) {
        super(x, y, animalType);
    }

    @Override
    public boolean eat(Organism organism) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int chance = random.nextInt(100);
        int probability = Animal_Type.probabilityOfEating.get(this.getAnimalType()).get(organism.getAnimalType());
        if (probability >= chance){
            setCurrentWeight(getCurrentWeight() + organism.getAnimalType().getMaxWeight());
            return true;
        }
        return false;
    }

    @Override
    public void move(Location location) {

    }
}
