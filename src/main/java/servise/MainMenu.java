package servise;

import lombok.Getter;
import lombok.Setter;
import organism.AnimalType;

import java.util.Scanner;

@Getter
@Setter
public class MainMenu {
    Parameters parameters = Parameters.getInstance();
    Scanner scanner = new Scanner(System.in);

    // Метод установки размеров острова
    public void setIslandSize() {
        System.out.println("Укажите длину острова");
        parameters.setLengthSize(scanner.nextInt());
        System.out.println("Укажите ширину острова");
        parameters.setHeightSize(scanner.nextInt());
    }

    public void setTickDuration() {
        System.out.println("Укажите длительность такта симмуляции");
        parameters.setTickDuration(scanner.nextInt());
    }

    // метод установки количества животных на старте симуляции
    public void setAnimalCount() {
        System.out.println("Укажите количество животных на старте");
        for (AnimalType animal : AnimalType.values()) {
            System.out.println(animal);
            int animalNumber = scanner.nextInt();
            parameters.getCountAnimals().put(animal, animalNumber);
        }
    }

    // метод установки кол-ва детенышей
    public void setCubsCount() {
        System.out.println("Укажите допустимое количество детенышей");
        for (AnimalType animal : AnimalType.values()) {
            System.out.println(animal);
            int cubsNumber = scanner.nextInt();
            parameters.getNumberCubs().put(animal, cubsNumber);
        }

    }

    // метод печати пользовательского меню
    public void printUserMenu() {
        System.out.println("1. Задать размер острова.");
        System.out.println("2. Задать количкство животных.");
        System.out.println("3. Задать длительность тика.");
        System.out.println("4. Запустить симуляцию.");

    }

    // запуск симуляции.
    public void simulationFactory() {
        Simulation simulation = new Simulation(parameters);
        simulation.start();
    }
}
