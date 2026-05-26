package organism;

import organism.herbivore.*;
import organism.predator.*;

public class Animal_Factory {
    // фабричный метод создания объектов типов животных
    public Animal create(Animal_Type animalType) {
        return switch (animalType) {
            case BEAR -> new Bear(animalType);
            case BOA_SNAKE -> new Boa_Snake(animalType);
            case EAGLE -> new Eagle(animalType);
            case FOX -> new Fox(animalType);
            case WOLF -> new Wolf(animalType);
            case BUFFALO -> new Buffalo(animalType);
            case DEER -> new Deer(animalType);
            case DUCK -> new Duck(animalType);
            case GOAT -> new Goat(animalType);
            case HOG -> new Hog(animalType);
            case HORSE -> new Horse(animalType);
            case MOUSE -> new Mouse(animalType);
            case RABBIT -> new Rabbit(animalType);
            case SHEEP -> new Sheep(animalType);
            case CATERPILLAR -> new Сaterpillar(animalType);
        };

    }
}
