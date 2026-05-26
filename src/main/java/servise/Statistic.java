package servise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Statistic {

    private int moven; // счетчик передвижения
    private int eaten; // счетчик съеденого
    private int died; // счетчик смерти
    private int born; // счетчик рождения

 public static void print(Statistic statistic){

 }
}
