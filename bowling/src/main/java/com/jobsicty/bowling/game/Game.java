package com.jobsicty.bowling.game;

import java.util.List;

public class Game implements IGame {
    private List<IPlayer> players;

    public List<IPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<IPlayer> players) {
        this.players = players;
    }
}
