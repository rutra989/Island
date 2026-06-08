package servise;

import lombok.Getter;
import lombok.Setter;
import organism.AnimalType;

import java.util.InputMismatchException;
import java.util.Scanner;

@Getter
@Setter
public class MainMenu {
    private Parameters parameters = Parameters.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private boolean islandSet = false; // флаг для контроля установки размеров острова
    private boolean animalsSet = false;
    private boolean cubSet = false;
    private boolean tickSet = false;


    // Метод установки размеров острова
    public void setIslandSize() {
        //длина
        System.out.println("Укажите длину острова (минимальный размер 10)");
        try {
            int length;
            do {
                length = scanner.nextInt();
                if (length < 10) {
                    System.out.println("Некорректное значение. Минимальный размер 10.");
                }
            } while (length < 10);
            parameters.setLengthSize(length);
            // ширина
            System.out.println("Укажите ширину острова (минимальный размер 10)");
            int height;
            do {
                height = scanner.nextInt();
                if (height < 10) {
                    System.out.println("Некорректное значение. Минимальный размер 10.");
                }
            } while (height < 10);
            parameters.setHeightSize(height);
            System.out.printf("Установленны следующие занчения: длина %d, ширина %d%n", length, height);
            //
            islandSet=true;
        } catch (InputMismatchException e){
            System.out.println("Не корректный ввод размеров острова. Повторите ввод.");
            scanner.nextLine();
        }

    }

    public void setTickDuration() {
        System.out.println("Укажите длительность такта симмуляции в секундах (минимальное значение 2 секунды)");
        try {
            int tick;
            do {
                tick = scanner.nextInt();
                if (tick < 2) {
                    System.out.println("Некорректное значение. Минимальная длительность 2 секунды.");
                }
            } while (tick < 2);
            parameters.setTickDuration(tick);
            System.out.printf("Установленна длительность такта %d сек %n", tick);
            //
            tickSet = true;
        } catch (InputMismatchException e){
            System.out.println("Некорректный ввод длительности такта. Повторите ввод.");
            scanner.nextLine();
        }
    }

    // метод установки количества животных на старте симуляции
    public void setAnimalCount() {
        System.out.println("Укажите количество животных на старте.");
        System.out.println("Рекомендуется минимум 5 особей каждого вида для корректной работы симуляции.");
        try {
            for (AnimalType animal : AnimalType.values()) {
                int animalNumber;
                do {
                    System.out.println(animal);
                    animalNumber = scanner.nextInt();
                    if (animalNumber < 0) {
                        System.out.println("Значение не может быть отрицательным, повторите ввод.");
                    }
                } while (animalNumber < 0);

                parameters.getCountAnimals().put(animal, animalNumber);
            }
            animalsSet = true;
        } catch (InputMismatchException e) {
            System.out.println("Введено не коректное значение. Повторите ввод.");
            scanner.nextLine();
        }
    }

    // метод установки кол-ва детенышей
    public void setCubsCount() {
        System.out.println("Укажите допустимое количество детенышей");
        try {
            for (AnimalType animal : AnimalType.values()) {
                System.out.println(animal);
                int cubsNumber;
                do {
                    cubsNumber = scanner.nextInt();
                    if (cubsNumber < 0) {
                        System.out.println("Значение не может быть отрицательным");
                    }
                } while (cubsNumber < 0);
                parameters.getNumberCubs().put(animal, cubsNumber);
            }
            cubSet = true;
        } catch (InputMismatchException e){
            System.out.println("Введено не корректное значение. Повторите ввод");
            scanner.nextLine();
        }
    }

    // метод печати пользовательского меню
    public void printUserMenu() {
        System.out.println("1. Задать размер острова.");
        System.out.println("2. Задать количество животных.");
        System.out.println("3. Задать ограничения по рождению детенышей.");
        System.out.println("4. Задать длительность тика.");
        System.out.println("5. Запустить симуляцию.");
        System.out.println("6. Запустить симуляцию со значениями по умолчанию.");

    }

    // запуск симуляции.
    public void simulationFactory() {
        Simulation simulation = new Simulation(parameters);
        simulation.start();
    }

    // метод проверки флагов
    public boolean isAllSet() {
        boolean result = true;
        if (!islandSet) {
            System.out.println("Не задан размер острова. Выберите пункт 1.");
            result = false;
        }
        if (!animalsSet) {
            System.out.println("Не задано количество животных. Выберите пункт 2.");
            result = false;
        }
        if (!cubSet) {
            System.out.println("Не заданы ограничения детенышей. Выберите пункт 3.");
            result = false;
        }
        if (!tickSet) {
            System.out.println("Не задана длительность тика. Выберите пункт 4.");
            result = false;
        }
        return result;
    }
}
