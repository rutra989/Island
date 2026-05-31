package island;

import lombok.Getter;
import lombok.Setter;
import organism.Animal;
import organism.Plants;

import java.util.concurrent.CopyOnWriteArrayList;

@Setter
@Getter
public class Location {

    private int x;
    private int y;
    CopyOnWriteArrayList<Animal> animals = new CopyOnWriteArrayList<>();
    CopyOnWriteArrayList<Plants> plants = new CopyOnWriteArrayList<>();

    //конструктор осоздания объекта по координатам
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // добавление животного
    public synchronized boolean addAnimal(Animal animal) {
        int count = 0;
        for (Animal animal1 : animals) {
            if (animal1.getAnimalType() == animal.getAnimalType()) {
                count++;
            }
        }
        if (count < animal.getAnimalType().getMaxCount()) {
            animals.add(animal);
            return true;
        }
        return false;
    }
    //удаление животного
    public synchronized void removeAnimal(Animal animal) {
        animals.remove(animal);

    }
    // добавление растений
    public boolean addPlants(Plants plant) {
        if (plants.size() < plant.getMaxCount()) {
            plants.add(plant);
            return true;
        }
        return false;
    }
    // удаление растений
    public void removePlants(Plants plant) {
        plants.remove(plant);
    }
}
