package com.example;

/**
 * Created by Pedro on 18/04/2016.
 */
public class Match {
    Team localTeam;
    Team visitorTeam;

    int plays;

    int localGoals = 0;
    int visitorGoals = 0;

    String summary = "";
    String goalsSummary = "";

    Player attacker;
    Player defender;

    public Match() {
        localTeam = new Team("4-4-2");
        visitorTeam = new Team("4-4-2");
        plays = 20;
    }

    public Match(int matchPlays) {
        localTeam = new Team("4-4-2");
        visitorTeam = new Team("4-4-2");
        plays = matchPlays;
    }

    public Match(int matchPlays, String localFormation, String visitorFormation) {
        localTeam = new Team(localFormation);
        visitorTeam = new Team(visitorFormation);
        plays = matchPlays;
    }

    public String play() {
        summary += "<br><br><br><br>";

        for (int play = 1; play <= plays; play += 2) {

            //Ataque equipo local
            if(generatePlay(play, localTeam, visitorTeam)) {
                localGoals++;
                generateGoal(localTeam);
            }

            //Ataque equipo visitante
            if(generatePlay(play + 1, visitorTeam, localTeam)) {
                visitorGoals++;
                generateGoal(visitorTeam);
            }
        }

        generateFinal();

        return localTeam.toString() + visitorTeam.toString() + summary + goalsSummary;
    }

    private void generateMinute(int play, Team attackerTeam) {
        summary += "<br><br>Minuto " + (int)(play * 93 / plays) + ".<br>Ataca <b>" + attackerTeam.getName() + "</b><br>";
    }

    private boolean generatePlay(int play, Team attackerTeam, Team defenderTeam) {
        generateMinute(play, attackerTeam);

        if (generateMidMidPlay(attackerTeam, defenderTeam)) {
            if (generateForwardBackPlay(attackerTeam, defenderTeam)) {
                if (generateForwardGoalPlay(attackerTeam, defenderTeam)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean generateMidMidPlay(Team attackerTeam, Team defenderTeam) {
        attacker = attackerTeam.getMedio();
        defender = defenderTeam.getMedio();

        int attackerThrow = RandGenerator.getGaussian(attacker.getAttack(), 2.0f);
        int defenderThrow = RandGenerator.getGaussian(defender.getDefense(), 2.0f);

        if (attackerThrow <= defenderThrow) {
            summary += "El medio atacante <b>" + attacker.getName() + "</b> ha realizado un ataque de <b>" + attackerThrow
                    + "</b> pero el medio rival <b>" + defender.getName() + "</b> ha realizado una intercepcion de <b>" + defenderThrow +
                    "</b> y ha recuperado la pelota para su equipo. ";

            return false;
        } else {
            summary += "El medio atacante <b>" + attacker.getName() + "</b> ha realizado un ataque de <b>" + attackerThrow
                    + "</b> y ha superado el medio rival <b>" + defender.getName() + "</b> que ha realizado una mala intercepcion de <b>"
                    + defenderThrow + "</b>. El balon llega al la delantera. ";

            return true;
        }
    }

    private boolean generateForwardBackPlay(Team attackerTeam, Team defenderTeam) {
        attacker = attackerTeam.getDelantero();
        defender = defenderTeam.getDefensa();

        int attackerThrow = RandGenerator.getGaussian(attacker.getAttack(), 2.0f);
        int defenderThrow = RandGenerator.getGaussian(defender.getDefense(), 2.0f);

        if (attackerThrow <= defenderThrow) {
            summary += "El delantero atacante <b>" + attacker.getName() + "</b> ha realizado un regate de <b>" + attackerThrow
                    + "</b> pero el defensa rival <b>" + defender.getName() + "</b> ha realizdo un corte de <b>" + defenderThrow +
                    "</b> y despeja la pelota hacia su medio campo. ";

            return false;
        } else {
            summary += "El delantero atacante <b>" + attacker.getName() + "</b> ha realizado un desmarque de <b>" + attackerThrow
                    + "</b> adelantandose al defensa <b>" + defender.getName() + "</b> y su intento de recuperar la pelota <b>" + defenderThrow +
                    "</b> y se dispone a encarar al portero. ";

            return true;
        }
    }

    private boolean generateForwardGoalPlay(Team attackerTeam, Team defenderTeam) {
        defender = defenderTeam.getPortero();

        int attackerThrow = RandGenerator.getGaussian(attacker.getAttack(), 2.0f);
        int defenderThrow = RandGenerator.getGaussian(defender.getDefense(), 2.0f);

        if (attackerThrow <= defenderThrow) {
            summary += "El delantero atacante <b>" + attacker.getName() + "</b> realiza un disparo de <b>" + attackerThrow
                    + "</b> pero el portero <b>" + defender.getName() + "</b> esta atento con una parada de <b>" + defenderThrow +
                    "</b> y detiene la pelota.";

            return false;
        } else {
            summary += "El delantero atacante <b>" + attacker.getName() + "</b> ha realizado un esplendido disparo de <b>" + attackerThrow
                    + "</b> y supera al portero <b>" + defender.getName() + "</b> con su intento de parada de <b>" + defenderThrow +
                    "</b> anotando un gol para su equipo.";

            return true;
        }
    }

    private void generateGoal(Team attackerTeam) {
        summary += "<br><br>¡¡¡¡¡¡¡¡GOOOOOOOOOOL!!!!!!!! Goooooool de <b>"
                + attacker.getName() + "</b> para <b>" + attackerTeam.getName() + "</b>. <b>" +
                localGoals + " - " + visitorGoals + "</b> en el marcador";

        goalsSummary += "<br><b>" + localGoals + " - " + visitorGoals + "</b> " + attacker.getName();
    }

    private void generateFinal() {
        summary += "<br><br>Finaaaaaal de partiiidoooo. <b>" + localGoals + " - " + visitorGoals + "</b><br>";
    }
}

