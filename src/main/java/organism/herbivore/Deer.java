package organism.herbivore;

import organism.AnimalType;
import servise.Statistic;

public class Deer extends Herbivore{
    public Deer(int x, int y) {
        super(x, y, AnimalType.DEER);
        Statistic.getBorn().incrementAndGet();
        Statistic.getTotal().incrementAndGet();
    }
}
