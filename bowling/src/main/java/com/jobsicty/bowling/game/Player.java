package com.jobsicty.bowling.game;
import java.util.List;

public class Player implements IPlayer {
    private String name;
    private List<IFrame> frames;

    public List<IFrame> getFrames() {
        return frames;
    }

    public void setFrames(List<IFrame> frames) {
        this.frames = frames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName());
        sb.append("\n");
        sb.append("Pinfalls \t");
        for (IFrame f : this.getFrames())
        {
            sb.append(f.toString());
            sb.append("\t");
        }
        return sb.toString();
    }
}
