package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileIO {

//    public static void writeIn(Archer archer){
//
//    }

    static File file = new File("game.txt");

    public static void write(Object object){
        try (OutputStream outputStream = new FileOutputStream(file,true)) {
            if(object instanceof Swordsman){
                byte[] bytesSwordsman = object.toString().getBytes();
                outputStream.write(bytesSwordsman);
                if(((Swordsman) object).getLife_count() == 0){
                    System.out.println("archer won");
                    outputStream.write("archer won\n".getBytes());
                    return;
                }

            }
            if(object instanceof Archer){
                byte[] bytesArcher = object.toString().getBytes();
                outputStream.write(bytesArcher);
                if(((Archer) object).getLife_count() == 0){
                    System.out.println("swordsman won");
                    outputStream.write("swordsman won\n".getBytes());
                    return;
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Object> createObject(){
        List<Object> players = new ArrayList<>();
        try{
            try {

                //live_count of last swordsman
                String swordsman_Life = Files.lines(Path.of(String.valueOf(file)))
                        .skip(Files.lines(Path.of(String.valueOf(file))).count() - 2)
                        .filter(each -> each.contains("Swordsman"))
                        .map(line -> line.split(":"))
                        .map(each -> each[1].split(",")[0])
                        .collect(Collectors.joining(""));
                //System.out.println(swordsman_Life);

                String archer_Life = Files.lines(Path.of(String.valueOf(file)))
                        .skip(Files.lines(Path.of(String.valueOf(file))).count() - 2)
                        .filter(each -> each.contains("Archer"))
                        .map(line -> line.split(":"))
                        .map(each -> each[1].split(",")[0])
                        .collect(Collectors.joining(""));
                //System.out.println(archer_Life);

                Swordsman swordsman = new Swordsman();
                swordsman.setLife_count(Double.parseDouble(swordsman_Life));
                players.add(swordsman);
                Archer archer = new Archer();
                archer.setLife_count(Double.parseDouble(archer_Life));
                players.add(archer);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return players;
    }
}