package organism;

public class Animal extends Organism{

    private double currentFood; // съедено еды
    private int currentSpeed; // текущая скорость
    //конструктор для создания объектов животных
    public Animal(Animal_Type animalType) {
        Animal animal = new Animal(animalType);

    }

    // метод приема пищи
    public void eat(Organism organism){

    }


}
