package organism.herbivore;

import organism.AnimalType;
import servise.Statistic;

public class Sheep extends Herbivore{
    public Sheep(int x, int y) {
        super(x, y, AnimalType.SHEEP);
        Statistic.getBorn().incrementAndGet();
        Statistic.getTotal().incrementAndGet();
    }
}
