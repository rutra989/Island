package island;

import lombok.Getter;
import organism.Animal;
import servise.Parameters;

import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Island {
    private Location[][] locations;

    // создание объекта остров с инициализацией размера массива
    public Island(Parameters parameters) {
        this.locations = new Location[parameters.getHeightSize()][parameters.getLengthSize()];
        init();
    }

    // метод заполняет массив локациями, без заселения))
    public void init() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location(i, j);
            }
        }
    }

    //метод по проверки границ
    public boolean inInside(int x, int y) {
        if (x > locations.length - 1 || y > locations[0].length - 1 || x < 0 || y < 0) {
            return false;
        }
        return true;
    }

    //метод передвижения(не верная логика выбора локации, исправить.)
    public synchronized void relocate(Animal animal, int x, int y) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int speed = random.nextInt(1,animal.getAnimalType().getMaxSpeed() + 1);
        do {
            x = random.nextInt(animal.getX() - speed, (animal.getX() + speed) + 1);
            y = random.nextInt(animal.getY() - speed, (animal.getY() + speed) + 1);
        } while (!inInside(x, y));

        if (locations[x][y].addAnimal(animal)) {
            locations[animal.getX()][animal.getY()].removeAnimal(animal);
            animal.move(locations[x][y]);
        }
    }
}

