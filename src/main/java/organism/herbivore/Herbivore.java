package organism.herbivore;

import island.Location;
import organism.Animal;
import organism.Organism;
import organism.AnimalType;
import organism.Plants;

public class Herbivore extends Animal {


    protected Herbivore(int x, int y, AnimalType animalType) {
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
