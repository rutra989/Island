package organism.herbivore;

import organism.AnimalType;
import servise.Statistic;

public class Rabbit extends Herbivore{
    public Rabbit(int x, int y) {
        super(x, y, AnimalType.RABBIT);
        Statistic.getBorn().incrementAndGet();
        Statistic.getTotal().incrementAndGet();
    }
}
