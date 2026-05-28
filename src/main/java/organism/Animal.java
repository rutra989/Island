package organism;

import island.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal extends Organism{
    private int x; //местоположение животных
    private int y;
    private double currentWeight; //текущий вес
    private int currentSpeed; // текущая скорость
    private Animal_Type animalType;

    public Animal(int x, int y, Animal_Type animalType) {
        this.x = x;
        this.y = y;
        this.currentWeight = animalType.getMaxWeight();
        this.animalType = animalType;
    }

    // метод приема пищи
    public abstract boolean eat(Organism organism);

    public abstract void move(Location location);
    
    public  void tickHunger(){
    currentWeight = currentWeight - currentWeight/4;
    }

    public boolean isDeath(){
        return currentWeight<=0;
    }

}
