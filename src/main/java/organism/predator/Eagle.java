package organism.predator;

import organism.AnimalType;
import servise.Statistic;

public class Eagle extends Predator{
    public Eagle(int x, int y) {
        super(x, y, AnimalType.EAGLE);
        Statistic.getBorn().incrementAndGet();
        Statistic.getTotal().incrementAndGet();
    }
}
