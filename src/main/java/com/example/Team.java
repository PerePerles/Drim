package com.example;

import java.util.ArrayList;

/**
 * Created by Pedro on 13/04/2016.
 */
public class Team {
    private Player portero;
    private ArrayList<Player> defensas = new ArrayList<>();
    private ArrayList<Player> medios = new ArrayList<>();
    private ArrayList<Player> delanteros = new ArrayList<>();

    private String name;

    public Team(String formation) {
        name = new RandGenerator().getTeamName();

        String[] positions = formation.split("-");

        portero = new Player("PORTERO");

        for(int i = 0; i < Integer.parseInt(positions[0]); i++) {
            defensas.add(new Player("DEFENSA"));
        }
        for(int i = 0; i < Integer.parseInt(positions[1]); i++) {
            medios.add(new Player("MEDIO"));
        }
        for(int i = 0; i < Integer.parseInt(positions[2]); i++) {
            delanteros.add(new Player("DELANTERO"));
        }
    }

    public Player getPortero() {
        return portero;
    }

    public void setPortero(Player portero) {
        this.portero = portero;
    }

    public ArrayList<Player> getDefensas() {
        return defensas;
    }

    public Player getDefensa() {
        return defensas.get(RandGenerator.getRandomIndex(defensas.size()));
    }

    public void setDefensas(ArrayList<Player> defensas) {
        this.defensas = defensas;
    }

    public ArrayList<Player> getMedios() {
        return medios;
    }

    public Player getMedio() {
        return medios.get(RandGenerator.getRandomIndex(medios.size()));
    }

    public void setMedios(ArrayList<Player> medios) {
        this.medios = medios;
    }

    public ArrayList<Player> getDelanteros() {
        return delanteros;
    }

    public Player getDelantero() {
        return delanteros.get(RandGenerator.getRandomIndex(delanteros.size()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setDelanteros(ArrayList<Player> delanteros) {
        this.delanteros = delanteros;
    }

    @Override
    public String toString() {
        String toString = "<table border='1' style='margin: 2%;width:46%; float: left'>";

        toString += "<tr><td colspan='4' style='text-align: center;'><b>" + name + "<b></td></tr>";
        toString += portero.toString();

        toString += "<tr><td colspan='4'></td></tr>";

        for (Player defensa : defensas) {
            toString += defensa.toString();
        }

        toString += "<tr><td colspan='4'></td></tr>";

        for (Player medio : medios) {
            toString += medio.toString();
        }

        toString += "<tr><td colspan='4'></td></tr>";

        for (Player delantero : delanteros) {
            toString += delantero.toString();
        }

        toString += "</table>";

        return toString;
    }
}
