package com.jobsicty.bowling.parser;

import com.jobsicty.bowling.game.IGame;

public interface IReader {
    public IGame parse(String path);
}
