package organism.predator;

import island.Location;
import organism.Animal;
import organism.Organism;
import organism.AnimalType;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Predator extends Animal {


    public Predator(int x, int y, AnimalType animalType) {
        super(x, y, animalType);
    }

    @Override
    public boolean eat(Organism organism) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int chance = random.nextInt(100);
        Integer probability = AnimalType.probabilityOfEating.get(this.getAnimalType()).get(organism.getAnimalType());
        if (probability == null){
            return false;
        }
        if (probability >= chance) {
            setCurrentWeight(getCurrentWeight() + organism.getCurrentWeight());
            organism.setCurrentWeight(0);
            normalizeWeight();
            return true;
        }
        return false;
    }

    @Override
    public CopyOnWriteArrayList<? extends Organism> getFoodList(Location location) {
        return location.getAnimals();
    }


}
