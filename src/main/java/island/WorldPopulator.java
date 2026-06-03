package island;

import organism.AnimalFactory;
import organism.AnimalType;
import organism.Plants;
import servise.Parameters;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class WorldPopulator {
    private WorldPopulator(){

    }
    // метод создания популяции животных
    private static void populateAnimals(Island island) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (Map.Entry<AnimalType, Integer> list : Parameters.getInstance().getCountAnimals().entrySet()) {
            Integer count = list.getValue(); // счетчик кол-ва животных
            int maxAttempts = list.getValue() * 2; // счетчик подстраховка от бесконечного цикла
            while (count > 0 && maxAttempts > 0) {
                int x = random.nextInt(island.getLocations().length); // выбираем рандомно координаты локации
                int y = random.nextInt(island.getLocations()[0].length);
                // создаем объект по указанным координатам в случае успешного добавления минусуем счетчик
                if (island.getLocations()[x][y].hasSpace(list.getKey())) {
                    island.getLocations()[x][y].addAnimal(AnimalFactory.create(x, y, list.getKey()));
                    count--;
                }
                // минусуем подстраховку в любом случае
                maxAttempts--;
            }
        }
    }

    // метод создания популяции растений
    private static void populatePlants(Island island) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i<island.getLocations().length; i++) {
            for (int j = 0; j < island.getLocations()[i].length; j++) {
                int count = random.nextInt(Plants.getMaxCount()); // счетчик кол-ва растений
                while (count > 0) {
                    // создаем объект по указанным координатам
                    island.getLocations()[i][j].addPlants(new Plants());
                    count--;
                }
            }
        }
    }

    public static void populate(Island island){
        populateAnimals(island);
        populatePlants(island);
    }
}

