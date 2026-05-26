package organism;

import lombok.Getter;

@Getter
public enum Animal_Type {

    //Хар-ки животных
    BEAR(500, 5, 2, 80),
    BOA_SNAKE(15, 30, 1, 3),
    EAGLE(6, 20, 3, 1),
    FOX(8, 30, 2, 2),
    WOLF(50, 30, 3, 8),
    BUFFALO(700, 10, 3, 100),
    DEER(300, 20, 4, 50),
    DUCK(1, 200, 4, 0.15),
    GOAT(60, 140, 3, 15),
    HOG(400, 50, 2, 50),
    HORSE(400, 20, 4, 60),
    MOUSE(0.05, 500, 1, 0.01),
    RABBIT(2, 150, 2, 0.45),
    SHEEP(70, 140, 3, 15),
    CATERPILLAR(0.01, 1000, 0, 0);


    private final double maxWeight; //вес одного животного
    private final int maxCount; //макс. кол-во животных одного видв на клетке
    private final int maxSpeed; //скорость перемещения, не более чем клеток за ход
    private final double maxFood; //сколько пищи для полного насыщения


    Animal_Type(double maxWeight, int maxCount, int maxSpeed, double maxFood) {
        this.maxWeight = maxWeight;
        this.maxCount = maxCount;
        this.maxSpeed = maxSpeed;
        this.maxFood = maxFood;
    }

    }
