package organism.herbivore;

import organism.AnimalType;
import organism.Organism;
import organism.Plants;
import servise.Statistic;

import java.util.concurrent.ThreadLocalRandom;

public class Duck extends Herbivore{
    public Duck(int x, int y) {
        super(x, y, AnimalType.DUCK);
        Statistic.getBorn().incrementAndGet();
        Statistic.getTotal().incrementAndGet();
    }

//    @Override
//    public boolean eat(Organism organism) {
//        ThreadLocalRandom random = ThreadLocalRandom.current();
//        int chance = random.nextInt(100);
//        Integer probability = AnimalType.probabilityOfEating.get(this.getAnimalType()).get(organism.getAnimalType());
//        if (probability == null){
//            setCurrentWeight(getCurrentWeight() + Plants.getMaxWeight());
//            organism.setCurrentWeight(0);
//            normalizeWeight();
//            return true;
//        }
//        if (probability >= chance) {
//            setCurrentWeight(getCurrentWeight() + organism.getCurrentWeight());
//            organism.setCurrentWeight(0);
//            normalizeWeight();
//            return true;
//        }
//        return false;
//    }
}
