package com.jobsicty.bowling.game;

public interface IFrame {

    public void calculate();

    public String getFirst();

    public void setFirst(String first);

    public String getSecond();

    public void setSecond(String second);

    public String getThird();

    public void setThird(String third);

    public Boolean getIsLast();

    public void setIsLast(Boolean isLast);

    public Boolean isSpare();

    public Boolean isStrike();

    
}
