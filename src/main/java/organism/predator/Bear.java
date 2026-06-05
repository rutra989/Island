package organism.predator;

import organism.AnimalType;
import servise.Statistic;

public class Bear extends Predator{

    public Bear(int x, int y) {
        super(x, y, AnimalType.BEAR);
        Statistic.getBorn().incrementAndGet();
        Statistic.getTotal().incrementAndGet();
    }
}
