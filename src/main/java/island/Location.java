package island;

import lombok.Getter;
import lombok.Setter;
import organism.Animal;
import organism.AnimalType;
import organism.Plants;

import java.util.concurrent.CopyOnWriteArrayList;

@Setter
@Getter
public class Location {

    private int x;
    private int y;
    private CopyOnWriteArrayList<Animal> animals = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Plants> plants = new CopyOnWriteArrayList<>();

    //конструктор осоздания объекта по координатам
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // добавление животного
    public synchronized void addAnimal(Animal animal) {
            animals.add(animal);
    }

    // проверка места в клетке ждя животных
    public boolean hasSpace(AnimalType animalType){
        int count = 0;
        for (Animal animal : animals){
            if (animal.getAnimalType() == animalType){
                count++;
            }
            if (count == animalType.getMaxCount()){
                return false;
            }
        }
        return true;
    }

    //вычисляем количестово свободного места в клетке  для растений
    public int freeSpacePlants(){
        int count = 0;
        for (Plants plant : plants){
            count++;
        }
        return Plants.getMaxCount() - count;
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
