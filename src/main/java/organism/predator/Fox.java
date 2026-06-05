package organism.predator;

import organism.AnimalType;
import servise.Statistic;

public class Fox extends Predator{
    public Fox(int x, int y) {
        super(x, y, AnimalType.FOX);
        Statistic.getBorn().incrementAndGet();
        Statistic.getTotal().incrementAndGet();
    }
}
