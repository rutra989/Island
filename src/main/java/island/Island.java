package island;

import servise.Parametrs;

public class Island {
    private Location [][] locations;
        // создание объекта остров с инициализацией размера массива
    public Island(Parametrs parametrs) {
        this.locations = new Location[parametrs.getHeightSize()][parametrs.getLengthSize()];
    }
    // метод заполняет массив локациями - пока без заселения))
    public void init(){
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j]= new Location(i, j);
            }
        }
    }
}
