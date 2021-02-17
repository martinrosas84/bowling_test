package com.jobsicty.bowling.game;

import java.util.List;

public interface IPlayer {
    public List<IFrame> getFrames();

    public void setFrames(List<IFrame> frames);

    public String getName();

    public void setName(String name);
}
