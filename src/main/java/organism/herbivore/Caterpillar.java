package organism.herbivore;

import organism.AnimalType;
import servise.Statistic;

public class Caterpillar extends Herbivore{
    //создание объекта через родительский конструктор
    public Caterpillar(int x, int y) {
        super(x, y, AnimalType.CATERPILLAR);
        Statistic.getBorn().incrementAndGet();
        Statistic.getTotal().incrementAndGet();
    }
}
