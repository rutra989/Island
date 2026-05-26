package island;

import servise.Parameters;

public class Island {
    private Location [][] locations;
        // создание объекта остров с инициализацией размера массива
    public Island(Parameters parameters) {
        this.locations = new Location[parameters.getHeightSize()][parameters.getLengthSize()];
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
