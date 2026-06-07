package organism.herbivore;

import organism.AnimalType;
import organism.Organism;
import organism.Plants;
import servise.Statistic;

import java.util.concurrent.ThreadLocalRandom;

public class Mouse extends Herbivore{
    public Mouse(int x, int y) {
        super(x, y, AnimalType.MOUSE);
        Statistic.getBorn().incrementAndGet();
        Statistic.getTotal().incrementAndGet();
    }

    @Override
    public boolean eat(Organism organism) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int chance = random.nextInt(100);
        if (organism.getAnimalType() == null) {
            setCurrentWeight(getCurrentWeight() + Plants.getMaxWeight());
            organism.setCurrentWeight(0);
            normalizeWeight();
            return true;
        }
        Integer probability = AnimalType.probabilityOfEating.get(this.getAnimalType()).get(organism.getAnimalType());
        System.out.println(probability);

        if (probability >= chance) {
            setCurrentWeight(getCurrentWeight() + organism.getCurrentWeight());
            organism.setCurrentWeight(0);
            normalizeWeight();
            Statistic.getEaten().incrementAndGet();
            return true;

        }
        return false;
    }
}

