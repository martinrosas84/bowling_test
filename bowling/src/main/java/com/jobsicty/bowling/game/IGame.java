package com.jobsicty.bowling.game;

import java.util.List;

public interface IGame {
    public List<IPlayer> getPlayers();
    public void setPlayers(List<IPlayer> players);
}
