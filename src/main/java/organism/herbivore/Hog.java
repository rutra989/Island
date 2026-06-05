package organism.herbivore;

import organism.AnimalType;
import servise.Statistic;

public class Hog extends Herbivore {
    public Hog(int x, int y) {
        super(x, y, AnimalType.HOG);
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
