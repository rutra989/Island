package servise;

import island.Island;
import island.LocationTask;
import island.WorldPopulator;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Getter
@Setter
public class Simulation {
    private Parameters parameters;
    private Island island;
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
    private List<LocationTask> taskList = new ArrayList<>();
    private long currentTick=0;

    public Simulation(Parameters parameters, Island island) {
        this.parameters = parameters;
        this.island = island;
        task();
    }

    //метод получения списка задач
    public void task(){

    }
    // метод запуска симуляции
    public void start(){
    }
    // условие остановки симуляции
    public void stop(){

    }
}
