package servise;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Statistic {
    private static AtomicInteger eaten = new AtomicInteger(0); // счетчик съеденого
    private static AtomicInteger died = new AtomicInteger(0); // счетчик умерло
    private static AtomicInteger born = new AtomicInteger(0); // счетчик рождено
    private static AtomicInteger total = new AtomicInteger(0); // счетчик рождено

    private Statistic() {
    }

    public static void print(Statistic statistic) {

    }
}
