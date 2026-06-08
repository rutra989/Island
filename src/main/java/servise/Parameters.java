
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
    private int numberOfThreads = 5; // количество потоков

    private boolean stopCondition = true; // условие остановки симуляции
    private Map<AnimalType, Integer> countAnimals = new HashMap<>(); // начальное кол-во животных;
    private Map<AnimalType,Integer> numberCubs = new HashMap<>(); // количество детенышей
    private int maxTicks = 15; // максимальное количество тиков
    private static volatile Parameters instance;

    private Parameters() {
        // Закинем стартовое количество животных
        countAnimals.put(AnimalType.BEAR, 5);
        countAnimals.put(AnimalType.BOA_SNAKE, 5);
        countAnimals.put(AnimalType.EAGLE, 5);
        countAnimals.put(AnimalType.FOX, 5);
        countAnimals.put(AnimalType.WOLF,5);
        countAnimals.put(AnimalType.BUFFALO,5);
        countAnimals.put(AnimalType.CATERPILLAR,5);
        countAnimals.put(AnimalType.DEER,5);
        countAnimals.put(AnimalType.DUCK,5);
        countAnimals.put(AnimalType.GOAT,5);
        countAnimals.put(AnimalType.HOG,5);
        countAnimals.put(AnimalType.HORSE,5);
        countAnimals.put(AnimalType.MOUSE,5);
        countAnimals.put(AnimalType.RABBIT,5);
        countAnimals.put(AnimalType.SHEEP,5);
        // ограничим количество новорожденных в клетке
        numberCubs.put(AnimalType.BEAR, 2);
        numberCubs.put(AnimalType.BOA_SNAKE, 2);
        numberCubs.put(AnimalType.EAGLE, 2);
        numberCubs.put(AnimalType.FOX, 2);
        numberCubs.put(AnimalType.WOLF, 2);
        numberCubs.put(AnimalType.BUFFALO, 2);
        numberCubs.put(AnimalType.CATERPILLAR, 2);
        numberCubs.put(AnimalType.DEER, 2);
        numberCubs.put(AnimalType.DUCK, 2);
        numberCubs.put(AnimalType.GOAT, 2);
        numberCubs.put(AnimalType.HOG, 2);
        numberCubs.put(AnimalType.HORSE, 2);
        numberCubs.put(AnimalType.MOUSE, 2);
        numberCubs.put(AnimalType.RABBIT, 2);
        numberCubs.put(AnimalType.SHEEP, 2);
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