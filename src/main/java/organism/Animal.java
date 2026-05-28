package organism;

import island.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal extends Organism{

//    private double currentWeight; //текущий вес
    private int currentSpeed; // текущая скорость
    private int x; //местоположение животных
    private int y;
    private Animal_Type animalType;

    public Animal(int x, int y, Animal_Type animalType) {
        super(animalType.getMaxWeight());
        this.x = x;
        this.y= y;
    }

    // метод приема пищи
    public abstract boolean eat(Organism organism);

    public abstract void move(Location location);
    
    public  void tickHunger(){
    setCurrentWeight(getCurrentWeight() - animalType.getMaxWeight() * 0.25);
    }

    public boolean isDeath(){
        return getCurrentWeight()<=0;
    }

}
