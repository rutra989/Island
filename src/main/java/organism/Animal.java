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

    public Animal(int x, int y, Animal_Type animalType) {
        super(animalType);
        this.x = x;
        this.y = y;
    }


    // метод приема пищи
    public abstract boolean eat(Organism organism);

    public abstract void move(Location location);
    
    public  void tickHunger(){
    setCurrentWeight(getCurrentWeight() - getAnimalType().getMaxWeight() * 0.25);
    }

    //метод проверки текущего веса к максимальному
    public void normalizeWeight(){
        if (getCurrentWeight() > getAnimalType().getMaxWeight()){
            setCurrentWeight(getAnimalType().getMaxWeight());
        }
    }


}
