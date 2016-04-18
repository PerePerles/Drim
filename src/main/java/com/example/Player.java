package com.example;

/**
 * Created by Pedro on 13/04/2016.
 */
public class Player {
    private String name;

    private String position;

    private Integer defense;
    private Integer attack;

    public Player() {
        name = "Pedro Perles";
        defense = RandGenerator.getGaussian(30.00, 10.00);
        attack = RandGenerator.getGaussian(30.00, 10.00);
    }

    public Player(String pos) {
        position = pos;
        name = new RandGenerator().getPlayerName();

        switch (pos) {
            case "PORTERO":
                defense = RandGenerator.getGaussian(50.00, 5.00);
                attack = RandGenerator.getGaussian(10.00, 5.00);
                break;
            case "DEFENSA":
                defense = RandGenerator.getGaussian(50.00, 5.00);
                attack = RandGenerator.getGaussian(20.00, 5.00);
                break;
            case "MEDIO":
                defense = RandGenerator.getGaussian(35.00, 5.00);
                attack = RandGenerator.getGaussian(35.00, 5.00);
                break;
            case "DELANTERO":
                defense = RandGenerator.getGaussian(20.00, 5.00);
                attack = RandGenerator.getGaussian(50.00, 5.00);
                break;
            default:
                defense = RandGenerator.getGaussian(30.00, 10.00);
                attack = RandGenerator.getGaussian(30.00, 10.00);
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        return "<tr><td>" + position + "</td><td>" + name + "</td><td>Defensa " + defense + "</td><td>Ataque " + attack + "</td></tr>";
    }
}
