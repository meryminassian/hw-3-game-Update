package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Archer archer = new Archer();
        Swordsman swordsman = new Swordsman();


        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.nextLine()).equals("-1")){

            if(archer.getLife_count() <=0 || swordsman.getLife_count() <= 0 ){
                System.out.println("END OF THE GAME");
                break;
            }
            else{
                archer.attack(swordsman);
                FileIO.write(swordsman);
                swordsman.attack(archer);
                FileIO.write(archer);


                if(input.equals("stop")){
                    if(archer.getLife_count() <=0 || swordsman.getLife_count() <= 0 ){
                        System.out.println("END OF THE GAME");
                        break;
                    }
                    List<Object> playersList = FileIO.createObject();
                    playersList.forEach(each -> System.out.println(each));
                    swordsman = (Swordsman) playersList.get(0);
                    archer = (Archer) playersList.get(1);
                }

            }

        }

    }
}
