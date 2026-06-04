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
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class Simulation {
    private Parameters parameters;
    private Island island;
    private ScheduledExecutorService scheduler;
    private List<LocationTask> taskList = new ArrayList<>();
    private AtomicLong currentTick = new AtomicLong(0); // номер текущего тика

    public Simulation(Parameters parameters, Island island) {
        this.parameters = parameters;
        this.island = island;
        this.scheduler = Executors.newScheduledThreadPool(getParameters().getNumberOfThreads());
    }

    //метод получения списка задач
    public void task() {
        int range = parameters.getLengthSize() / parameters.getNumberOfThreads(); // определяем диапазон работы потоков
        int startRow = 0;
        // создаем список задач распределяя ответственность потоков по диапазону. каждый действует в своем диапазоне острова
        for (int i = 0; i < parameters.getNumberOfThreads(); i++) {
            int endRow = startRow + range - 1;
            if (i == parameters.getNumberOfThreads() - 1 && parameters.getLengthSize() % parameters.getNumberOfThreads() != 0) {
                endRow = parameters.getLengthSize() - 1;
            }
            taskList.add(new LocationTask(island, startRow, endRow));
            startRow = endRow + 1;
        }
    }

    // метод запуска симуляции
    public void start() throws InterruptedException {
        WorldPopulator.populate(island);
        task();
        while (!stop()) {
            currentTick.incrementAndGet();
            for (LocationTask task : taskList) {
                task.setCurrentTick(currentTick.get());
            }
            scheduler.invokeAll(taskList);
        }
    }

    // условие остановки симуляции
    public boolean stop() {
//        if (){
//            parameters.isStopCondition() = false;
//        }
        return parameters.isStopCondition();
    }
}
