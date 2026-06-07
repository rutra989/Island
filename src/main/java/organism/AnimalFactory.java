package organism;

import organism.herbivore.*;
import organism.predator.*;

public class AnimalFactory {
    private AnimalFactory() {
    }

    // фабричный метод создания объектов типов животных
    public static Animal create(int x, int y, AnimalType animalType) {
        return switch (animalType) {
            case BEAR -> new Bear(x, y);
            case BOA_SNAKE -> new BoaSnake(x, y);
            case EAGLE -> new Eagle(x, y);
            case FOX -> new Fox(x, y);
            case WOLF -> new Wolf(x, y);
            case BUFFALO -> new Buffalo(x, y);
            case DEER -> new Deer(x, y);
            case DUCK -> new Duck(x, y);
            case GOAT -> new Goat(x, y);
            case HOG -> new Hog(x, y);
            case HORSE -> new Horse(x, y);
            case MOUSE -> new Mouse(x, y);
            case RABBIT -> new Rabbit(x, y);
            case SHEEP -> new Sheep(x, y);
            case CATERPILLAR -> new Caterpillar(x, y);
        };

    }
}
