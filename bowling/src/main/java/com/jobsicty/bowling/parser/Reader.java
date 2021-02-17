package com.jobsicty.bowling.parser;

import java.util.stream.Stream;

import com.jobsicty.bowling.game.Frame;
import com.jobsicty.bowling.game.Game;
import com.jobsicty.bowling.game.IFrame;
import com.jobsicty.bowling.game.IGame;
import com.jobsicty.bowling.game.IPlayer;
import com.jobsicty.bowling.game.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reader implements IReader {

    @Override
    public IGame parse(String path) {
        List<SimpleImmutableEntry<String, String>> listPlays = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {

            listPlays = stream
                    .map(this::splitLine)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, List<String>> players = listPlays.stream()
            .collect(Collectors.groupingBy(ln -> ln.getKey()))
            .entrySet()
            .stream()
            .collect(Collectors.toMap(
                e -> e.getKey(),
                e -> e.getValue().stream().map(x -> x.getValue()).collect(Collectors.toList())
            ));

        List<IPlayer> playersO = players.entrySet().stream().map(m -> this.getPlayer(m.getKey(), m.getValue())).collect(Collectors.toList());

        IGame game = new Game();
        game.setPlayers(playersO);
        
        return game;
    }

    private SimpleImmutableEntry<String, String> splitLine(String line) {
        String[] splited = line.split("\t");
        return new SimpleImmutableEntry<>(splited[0], splited[1]);
    }

    private List<IFrame> getFrames(List<String> plays) {
        List<String> lastPlays = plays.subList(plays.size() - 3, plays.size());
        List<String> otherPlays = plays.subList(0, plays.size() - 3);
        List<IFrame> frames = new ArrayList<IFrame>();
        for(int i=0; i < otherPlays.size(); i++){
            if(otherPlays.get(i).equals("10")){
                IFrame frame = new Frame();
                frame.setFirst(otherPlays.get(i));
                frame.calculate();
                frames.add(frame);
            } else {
                IFrame frame = new Frame();
                frame.setFirst(otherPlays.get(i));
                frame.setSecond(otherPlays.get(i + 1));
                frame.calculate();
                frames.add(frame);
                i++;
            }
        }
        
        IFrame frame = new Frame();
        frame.setFirst(lastPlays.get(0));
        frame.setSecond(lastPlays.get(1));
        frame.setThird(lastPlays.get(2));
        frame.setIsLast(true);
        frame.calculate();

        frames.add(frame);

        return frames;
    }

    private IPlayer getPlayer(String name, List<String> plays) {
        IPlayer player = new Player();
        player.setName(name);
        player.setFrames( this.getFrames(plays));
        return player;
    }
}
