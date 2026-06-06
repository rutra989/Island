package servise;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Statistic {
    @Getter
    private final static AtomicInteger eaten = new AtomicInteger(0); // счетчик съеденого
    @Getter
    private final static AtomicInteger died = new AtomicInteger(0); // счетчик умерло
    @Getter
    private final static AtomicInteger born = new AtomicInteger(0); // счетчик рождено
    @Getter
    private final static AtomicInteger total = new AtomicInteger(0); // счетчик всего
    @Getter
    private final static AtomicLong currentTick = new AtomicLong(0);
    private Statistic() {
    }
    //метод сброса счетчиков
    public static void reset(){
        eaten.set(0);
        died.set(0);
        born.set(0);
    }
    // метод печати отчетастатистики
    public static void print() {
        System.out.printf("Тик: %d | Родилось: %d | Умерло: %d | Съедено: %d | Всего: %d%n",
                currentTick.get(), born.get(), died.get(), eaten.get(), total.get());
    }
}
