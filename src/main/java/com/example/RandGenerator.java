package com.example;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Pedro on 18/04/2016.
 */
public final class RandGenerator {
    static Random randomGenerator = new Random();
    private ArrayList<String> playerFirstNames = new ArrayList<>();
    private ArrayList<String> playerSecondNames = new ArrayList<>();
    
    private ArrayList<String> teamFirstNames = new ArrayList<>();
    private ArrayList<String> teamSecondNames = new ArrayList<>();

    public RandGenerator() {
        playerFirstNames.add("Bea");
        playerFirstNames.add("Pedro");
        playerFirstNames.add("Ines");
        playerFirstNames.add("Alex");
        playerFirstNames.add("Carlos");
        playerFirstNames.add("Edu");
        playerFirstNames.add("Vanessa");
        playerFirstNames.add("Maria");
        playerFirstNames.add("Elena");
        playerFirstNames.add("Ignacio");
        playerFirstNames.add("Borja");
        playerFirstNames.add("Angel");
        playerFirstNames.add("Segio");
        playerFirstNames.add("Eufemiano");

        playerSecondNames.add("De Vera");
        playerSecondNames.add("Perles");
        playerSecondNames.add("Messi");
        playerSecondNames.add("Aznar");
        playerSecondNames.add("Rajoy");
        playerSecondNames.add("Iglesias");
        playerSecondNames.add("Gutierrez");
        playerSecondNames.add("Shakespeare");
        playerSecondNames.add("Swarzenagger");
        playerSecondNames.add("Simpson");
        playerSecondNames.add("Nahasapemapetilon");
        playerSecondNames.add("Bulbasur");
        
        teamFirstNames.add("Bayern");
        teamFirstNames.add("Real");
        teamFirstNames.add("Sporting");
        teamFirstNames.add("Atletic");
        teamFirstNames.add("Los Angeles");
        teamFirstNames.add("New York");
        teamFirstNames.add("Borussia");
        teamFirstNames.add("Minnesota");
        teamFirstNames.add("Hercules");

        teamSecondNames.add("Benissa");
        teamSecondNames.add("Adeje");
        teamSecondNames.add("Maguncia");
        teamSecondNames.add("Marbella");
        teamSecondNames.add("Albacete");
        teamSecondNames.add("Linares");
        teamSecondNames.add("Timberwolves");
        teamSecondNames.add("Lakers");
        teamSecondNames.add("Bulls");
    }

    public static int getGaussian(double aMean, double aVariance){
        return (int)(aMean + randomGenerator.nextGaussian() * aVariance);
    }

    public static int getRandomIndex(int size) {
        return randomGenerator.nextInt(size);
    }

    public String getPlayerName() {
        return playerFirstNames.get(getRandomIndex(playerFirstNames.size())) + " "
                + playerSecondNames.get(getRandomIndex(playerSecondNames.size()));
    }

    public String getTeamName() {
        return teamFirstNames.get(getRandomIndex(teamFirstNames.size())) + " "
                + teamSecondNames.get(getRandomIndex(teamSecondNames.size()));
    }
}
