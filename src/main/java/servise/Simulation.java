package servise;

import island.Island;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Simulation {
    private Parametrs parametrs;
    private Island island;
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

    public Simulation(Parametrs parametrs) {
        this.parametrs = parametrs;
        this.island = new Island(parametrs);
    }

    public void start(){

    }

    public void stop(){

    }
}
