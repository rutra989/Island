package servise;

import island.Island;
import island.LocationTask;
import island.WorldPopulator;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class Simulation {
    private Parameters parameters;
    private Island island;
    private ScheduledExecutorService scheduler;
    private ExecutorService threadPool;
    private List<LocationTask> taskList = new ArrayList<>();

    public Simulation(Parameters parameters) {
        this.parameters = parameters;
        this.island = new Island(parameters);
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.threadPool = Executors.newFixedThreadPool(getParameters().getNumberOfThreads());
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
    public void start(){
        WorldPopulator.populate(island);
        task();
        scheduler.scheduleAtFixedRate(() -> {
            Statistic.getCurrentTick().incrementAndGet();
            Statistic.reset();
            try {
                threadPool.invokeAll(taskList);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Аварийное завершение симуляции.");
            }
            Statistic.print();
            if (stop()){
                scheduler.shutdown();
            }
        }, 0 , parameters.getTickDuration(), TimeUnit.SECONDS);
    }

    // условие остановки симуляции
    public boolean stop() {
        return Statistic.getCurrentTick().get() >= parameters.getMaxTicks() || Statistic.getTotal().get() == 0;
    }
}
