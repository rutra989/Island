package island;

import servise.Parametrs;

public class Island {
    private Location [][] locations;

    public Island(Parametrs parametrs) {
        this.locations = new Location[parametrs.heightSize][parametrs.lengthSize];
    }

    public void init(){
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j]= new Location(i, j);
            }
        }
    }
}
