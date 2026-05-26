package servise;

import island.Island;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Simulation {
    private Parameters parameters;
    private Island island;
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

    public Simulation(Parameters parameters) {
        this.parameters = parameters;
        this.island = new Island(parameters);
    }

    public void start(){

    }

    public void stop(){

    }
}
