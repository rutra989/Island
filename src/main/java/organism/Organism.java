package organism;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract public class Organism {
    private Animal_Type animalType;
    private double currentWeight; // текущий вес

    public Organism(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public Organism(Animal_Type animalType) {
        this.animalType = animalType;
        this.currentWeight = animalType.getMaxWeight();
    }




    // метод проверки смерти
    public boolean isDead(){
        return getCurrentWeight()<=0;
    }
}
