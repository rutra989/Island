package organism.predator;

import island.Location;
import organism.Animal;
import organism.Organism;
import organism.AnimalType;

import java.util.concurrent.ThreadLocalRandom;

public class Predator extends Animal {


    public Predator(int x, int y, AnimalType animalType) {
        super(x, y, animalType);
    }

    @Override
    public boolean eat(Organism organism) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int chance = random.nextInt(100);
        int probability = AnimalType.probabilityOfEating.get(this.getAnimalType()).get(organism.getAnimalType());
        if (probability >= chance){
            setCurrentWeight(getCurrentWeight() + organism.getCurrentWeight());
            organism.setCurrentWeight(0);
            normalizeWeight();
            return true;
        }
        return false;
    }

    @Override
    public void move(Location location) {

    }
}
