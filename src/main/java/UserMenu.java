import servise.MainMenu;
import servise.Parameters;
import servise.Simulation;

import java.util.Scanner;

public class UserMenu {


    public static void main(String[] args) {
        boolean running = false;
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu();
        //запуск пользовательского меню
        while (!running) {
            mainMenu.printUserMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> mainMenu.setIslandSize();
                case 2 -> mainMenu.setAnimalCount();
                case 3 -> mainMenu.setTickDuration();
                case 4 -> {
                    running = true;
                    mainMenu.simulationFactory();
                }
                default -> System.out.println("Введите корректное значение");
            }
        }
    }
}
