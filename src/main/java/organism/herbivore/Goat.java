package organism.herbivore;

import organism.AnimalType;
import servise.Statistic;

public class Goat extends Herbivore{
    public Goat(int x, int y) {
        super(x, y, AnimalType.GOAT);
        Statistic.getBorn().incrementAndGet();
        Statistic.getTotal().incrementAndGet();
    }
}
