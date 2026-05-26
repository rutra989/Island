package island;

import servise.Statistic;

import java.util.concurrent.Callable;

public class LocationTask implements Callable<Statistic> {

    private Location location;

    public LocationTask(Location location) {
    this.location = location;
    }

    @Override
    public Statistic call() throws Exception {


        return null;
    }
}
