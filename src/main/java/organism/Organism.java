package organism;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract public class Organism {

    private double currentWeight; // текущий вес

    public Organism(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    // метод рождения
    public void reproduction(Organism organism){

    }
    // метод смерти
    public void death() {

    }
}
