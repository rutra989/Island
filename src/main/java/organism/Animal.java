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

    public Animal(int x, int y, AnimalType animalType) {
        super(animalType);
        this.x = x;
        this.y = y;
    }


    // метод приема пищи
    public abstract boolean eat(Organism organism);
    //метод движения
    public void move(Location location){
        this.x = location.getX();
        this.y = location.getY();
    }
    //метод голода
    public  void tickHunger(){
    setCurrentWeight(getCurrentWeight() - getAnimalType().getMaxWeight() * 0.25);
    }
    // метод рождения
    public Animal reproduction(){
    return AnimalFactory.create(x,y,getAnimalType());
    }
    //метод привидения текущего веса к максимальному в случаи переедания
    public void normalizeWeight(){
        if (getCurrentWeight() > getAnimalType().getMaxWeight()){
            setCurrentWeight(getAnimalType().getMaxWeight());
        }
    }


}
