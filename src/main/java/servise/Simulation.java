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
    private long currentTick=1; // номер текущего тика


    public Simulation(Parameters parameters, Island island) {
        this.parameters = parameters;
        this.island = island;
        task();
    }

    //метод получения списка задач
    public void task() {
        int range = parameters.getLengthSize()/ parameters.getNumberOfThreads();
        int startRow = 0;
        for (int i = 0; i < parameters.getNumberOfThreads(); i++) {
            int endRow = startRow + range - 1;

            if (i == parameters.getNumberOfThreads() - 1 && parameters.getLengthSize() % parameters.getNumberOfThreads() != 0){
                endRow = parameters.getLengthSize() - 1;
            }
            taskList.add(new LocationTask(island, startRow,endRow, currentTick));
            startRow = endRow + 1;
        }
    }

    // метод запуска симуляции
    public void start(){
        WorldPopulator.populate(island);
        while (!stop()){
            task();
        }
    }
    // условие остановки симуляции
    public boolean stop(){
//        if (){
//            parameters.isStopCondition() = false;
//        }
        return parameters.isStopCondition();
    }
}
