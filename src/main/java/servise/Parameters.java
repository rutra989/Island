package servise;

import lombok.Getter;
import lombok.Setter;
import organism.Animal_Type;

import java.util.Map;
@Getter
@Setter
public class Parameters {
    private int heightSize; // ширина массива
    private int lengthSize; //длина массива
    private int tickDuration; // длительность такта симуляции
    private boolean stopCondition; // условие остановки симуляции
    private Map<Animal_Type, Integer> initialCount; // начальное кол-во животных;
    private Map<Animal_Type,Integer> numberCubs; // количество детенышей
}
