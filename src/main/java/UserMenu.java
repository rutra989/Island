import servise.MainMenu;

import java.util.Scanner;

public class UserMenu {


    public static void main(String[] args) {
        boolean running = false;
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu();
        //запуск пользовательского меню
        while (!running) {
            try {
                mainMenu.printUserMenu();
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> mainMenu.setIslandSize();
                    case 2 -> mainMenu.setAnimalCount();
                    case 3 -> mainMenu.setCubsCount();
                    case 4 -> mainMenu.setTickDuration();
                    case 5 -> {
                        if (mainMenu.isAllSet()){
                            mainMenu.simulationFactory();
                            running = true;
                        }
                    }
                    case 6 -> {
                        running = true;
                        mainMenu.simulationFactory();
                    }
                    default -> System.out.println("Введите корректный пункт меню.");
                }
            } catch (RuntimeException e) {
                System.out.println("Введен не корректный символ, повторите ввод.");
            }
            scanner.nextLine(); // очищаем буфер
        }
    }
}
