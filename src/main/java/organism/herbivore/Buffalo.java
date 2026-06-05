package organism.herbivore;

import organism.AnimalType;
import servise.Statistic;

public class Buffalo extends Herbivore{
    public Buffalo(int x, int y) {
        super(x, y, AnimalType.BUFFALO);
        Statistic.getBorn().incrementAndGet();
        Statistic.getTotal().incrementAndGet();
    }
}
