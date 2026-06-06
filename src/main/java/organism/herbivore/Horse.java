package organism.herbivore;

import organism.AnimalType;
import servise.Statistic;

public class Horse extends Herbivore{
    public Horse(int x, int y) {
        super(x, y, AnimalType.HORSE);
        Statistic.getBorn().incrementAndGet();
        Statistic.getTotal().incrementAndGet();
    }
}
