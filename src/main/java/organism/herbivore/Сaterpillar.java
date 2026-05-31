package organism.herbivore;

import organism.AnimalType;

public class Сaterpillar extends Herbivore{
    //создание объекта через родительский конструктор
    public Сaterpillar(int x, int y) {
        super(x, y, AnimalType.CATERPILLAR);
    }
}
