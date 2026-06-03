package servise;

import lombok.Getter;
import lombok.Setter;
import organism.AnimalType;

import java.util.Scanner;

@Getter
@Setter
public class MainMenu {
    Parameters parameters = Parameters.getInstance();

    // установка параметров. (добавить валидацию, поменять логику метода)
    public void initParameters(Scanner scanner) {
        System.out.println("Введите длину острова, диапазон от 1 до 200");
        parameters.setLengthSize(scanner.nextInt());
        System.out.println("Введите ширину острова, диапазон от 1 до 200");
        parameters.setHeightSize(scanner.nextInt());
        System.out.println("Введите длительность такта симмуляции");
        parameters.setTickDuration(scanner.nextInt());
        System.out.println("Введите количество животных на старте");
        for (AnimalType animal : AnimalType.values()){
            System.out.println(animal);
            int animalNumber = scanner.nextInt();
            parameters.getCountAnimals().put(animal, animalNumber);
        }
        System.out.println("Введите допустимое количество детенышей");
        for (AnimalType animal : AnimalType.values()){
            System.out.println(animal);
            int cubsNumber = scanner.nextInt();
            parameters.getNumberCubs().put(animal, cubsNumber);
        }
    }

    // запуск симуляции.
    public void simulationFactory() {
//        Simulation simulation = new Simulation(parameters);
//        simulation.start();
    }
}
