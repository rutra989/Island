package servise;

import lombok.Getter;
import lombok.Setter;
import organism.AnimalType;

import java.util.HashMap;
import java.util.Map;
@Getter
@Setter
public class Parameters {
    private int lengthSize; //длина массива
    private int heightSize; // ширина массива
    private int tickDuration; // длительность такта симуляции
    private int numberOfThreads = 5; // количество потоков

    private boolean stopCondition = true; // условие остановки симуляции
    private Map<AnimalType, Integer> countAnimals = new HashMap<>(); // начальное кол-во животных;
    private Map<AnimalType,Integer> numberCubs = new HashMap<>(); // количество детенышей
    private int maxTicks; // максимальное количество тиков
    private static volatile Parameters instance;

    private Parameters() {
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
