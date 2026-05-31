import servise.MainMenu;
import servise.Parameters;
import servise.Simulation;

import java.util.Scanner;

public class UserMenu {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu();
        mainMenu.simulationFactory();
        mainMenu.initParameters(scanner);
    }
}
