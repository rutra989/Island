package servise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainMenu {
    Parameters parameters = new Parameters();


    // установка параметров.
    public void initParameters(){

    }
    // запуск симуляции.
    public void simulationFactory(){
        Simulation simulation = new Simulation(parameters);
        simulation.start();
    }
}
