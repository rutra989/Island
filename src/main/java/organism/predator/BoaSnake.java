package organism.predator;

import organism.AnimalType;
import servise.Statistic;

public class BoaSnake extends Predator{
    public BoaSnake(int x, int y) {
        super(x, y, AnimalType.BOA_SNAKE);
        Statistic.getBorn().incrementAndGet();
        Statistic.getTotal().incrementAndGet();
    }
}
