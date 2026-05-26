package island;

import lombok.Getter;
import lombok.Setter;
import organism.Animal;
import organism.Organism;
import organism.Plants;

import java.util.concurrent.CopyOnWriteArrayList;
@Setter
@Getter
public class Location {

    private int x;
    private int y;
    CopyOnWriteArrayList<Animal> listAnimals = new CopyOnWriteArrayList<>();
    CopyOnWriteArrayList<Plants> listPlants = new CopyOnWriteArrayList<>();
    //конструктор осоздания объекта по координатам
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //метод заполнения листов объектами организмов
    public void appendObjects(Organism organism){
    if (organism instanceof Animal){
        listAnimals.add((Animal) organism);
    } else {
        listPlants.add((Plants) organism);
    }
    }

}
