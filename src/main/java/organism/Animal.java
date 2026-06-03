package organism;

import island.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Setter
public abstract class Animal extends Organism{

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
    // метод возвращает список потенциальной еды
    public abstract CopyOnWriteArrayList<? extends Organism> getFoodList(Location location);

    //метод испытания голода
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

    // метод проверки на голод
    public boolean isHungry(){
        if (getCurrentWeight() < (getAnimalType().getMaxWeight() * 0.7)){
            return true;
        }
        return false;
    }
}
