package com.jobsicty.bowling;

import com.jobsicty.bowling.game.IGame;
import com.jobsicty.bowling.game.Scorer;
import com.jobsicty.bowling.parser.IReader;
import com.jobsicty.bowling.parser.Reader;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        IReader reader = new Reader();
        IGame game = reader.parse("file.txt");
        game.getPlayers().forEach(System.out::println);
        Scorer score =  new Scorer();
        score.setFrames(game.getPlayers().get(1).getFrames());
        score.calculate();
        System.out.println(score);
    }
}
