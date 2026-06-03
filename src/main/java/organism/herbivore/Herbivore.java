package organism.herbivore;

import island.Location;
import organism.Animal;
import organism.Organism;
import organism.AnimalType;
import organism.Plants;

import java.util.concurrent.CopyOnWriteArrayList;

public class Herbivore extends Animal {


    protected Herbivore(int x, int y, AnimalType animalType) {
        super(x, y, animalType);
    }

    @Override
    public boolean eat(Organism organism) {
        //проверка на случай если вес животного меньше веса растения
        if (getAnimalType().getMaxFood() < Plants.getMaxWeight()) {
            setCurrentWeight(getCurrentWeight() + getAnimalType().getMaxFood());
            return true;
        }
        setCurrentWeight(getCurrentWeight() + Plants.getMaxWeight());
        organism.setCurrentWeight(0);
        normalizeWeight();
        return true;
    }

    @Override
    public CopyOnWriteArrayList<? extends Organism> getFoodList(Location location) {
        return location.getPlants();
    }

}
