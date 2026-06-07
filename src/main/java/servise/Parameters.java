
package servise;

import lombok.Getter;
import lombok.Setter;
import organism.AnimalType;

import java.util.HashMap;
import java.util.Map;
@Getter
@Setter
public class Parameters {
    private int lengthSize = 10; //длина массива
    private int heightSize = 10; // ширина массива
    private int tickDuration = 3; // длительность такта симуляции
    private int numberOfThreads = 1; // количество потоков

    private boolean stopCondition = true; // условие остановки симуляции
    private Map<AnimalType, Integer> countAnimals = new HashMap<>(); // начальное кол-во животных;
    private Map<AnimalType,Integer> numberCubs = new HashMap<>(); // количество детенышей
    private int maxTicks = 15; // максимальное количество тиков
    private static volatile Parameters instance;

    private Parameters() {
        // Закинем стартовое количество животных
        countAnimals.put(AnimalType.BEAR, 10);
        countAnimals.put(AnimalType.BOA_SNAKE, 10);
        countAnimals.put(AnimalType.EAGLE, 10);
        countAnimals.put(AnimalType.FOX, 10);
        countAnimals.put(AnimalType.WOLF,10);
        countAnimals.put(AnimalType.BUFFALO,10);
        countAnimals.put(AnimalType.CATERPILLAR,10);
        countAnimals.put(AnimalType.DEER,10);
        countAnimals.put(AnimalType.DUCK,10);
        countAnimals.put(AnimalType.GOAT,10);
        countAnimals.put(AnimalType.HOG,10);
        countAnimals.put(AnimalType.HORSE,10);
        countAnimals.put(AnimalType.MOUSE,10);
        countAnimals.put(AnimalType.RABBIT,10);
        countAnimals.put(AnimalType.SHEEP,10);
        // ограничим количество новорожденных в клетке
        numberCubs.put(AnimalType.BEAR, 10);
        numberCubs.put(AnimalType.BOA_SNAKE, 10);
        numberCubs.put(AnimalType.EAGLE, 10);
        numberCubs.put(AnimalType.FOX, 10);
        numberCubs.put(AnimalType.WOLF, 10);
        numberCubs.put(AnimalType.BUFFALO, 10);
        numberCubs.put(AnimalType.CATERPILLAR, 10);
        numberCubs.put(AnimalType.DEER, 10);
        numberCubs.put(AnimalType.DUCK, 15);
        numberCubs.put(AnimalType.GOAT, 15);
        numberCubs.put(AnimalType.HOG, 15);
        numberCubs.put(AnimalType.HORSE, 10);
        numberCubs.put(AnimalType.MOUSE, 20);
        numberCubs.put(AnimalType.RABBIT, 15);
        numberCubs.put(AnimalType.SHEEP, 15);
    }
    //    создаем объект Parameters в единственном экземпляре паттерн Синглтон
    public static Parameters getInstance() {
        if (instance == null) {
            synchronized (Parameters.class) {
                if (instance == null) {
                    instance = new Parameters();
                }
            }
        }
        return instance;
    }
}