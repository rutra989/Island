package island;

import lombok.Getter;
import organism.Animal;
import servise.Direction;
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

    //метод для проверки границ
    public boolean inInside(int x, int y) {
        if (x > locations.length - 1 || y > locations[0].length - 1 || x < 0 || y < 0) {
            return false;
        }
        return true;
    }

    //метод передвижения
    public synchronized void relocate(Animal animal) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int newX;
        int newY;
        //генерируем скорость перемещения
        int speed = random.nextInt(1, animal.getAnimalType().getMaxSpeed() + 1);

        do {
            //генерируем направление и задаем новые координаты и проверяем выход за границы
            Direction direction = Direction.values()[random.nextInt(Direction.values().length)];
            newX = animal.getX() + direction.getDx() * speed;
            newY = animal.getY() + direction.getDy() * speed;
        } while (!inInside(newX, newY));

        if (locations[newX][newY].hasSpace(animal.getAnimalType())) {
            locations[newX][newY].addAnimal(animal);
            locations[animal.getX()][animal.getY()].removeAnimal(animal);
            animal.move(locations[newX][newY]);
        }
    }
}

