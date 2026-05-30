package organism;

import organism.herbivore.*;
import organism.predator.*;

public class Animal_Factory {
    // фабричный метод создания объектов типов животных
    public static Animal create(int x, int y, Animal_Type animalType) {
        return switch (animalType) {
            case BEAR -> new Bear(x, y, animalType);
            case BOA_SNAKE -> new Boa_Snake(x, y, animalType);
            case EAGLE -> new Eagle(x, y, animalType);
            case FOX -> new Fox(x, y, animalType);
            case WOLF -> new Wolf(x, y, animalType);
            case BUFFALO -> new Buffalo(x, y, animalType);
            case DEER -> new Deer(x, y, animalType);
            case DUCK -> new Duck(x, y, animalType);
            case GOAT -> new Goat(x, y, animalType);
            case HOG -> new Hog(x, y, animalType);
            case HORSE -> new Horse(x, y, animalType);
            case MOUSE -> new Mouse(x, y, animalType);
            case RABBIT -> new Rabbit(x, y, animalType);
            case SHEEP -> new Sheep(x, y, animalType);
            case CATERPILLAR -> new Сaterpillar(x, y, animalType);
        };

    }
}
