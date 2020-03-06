package game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import elements.Hero;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;
    private Hero hero;
    private int score;
    public Game(){
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw(){
        screen.clear();
        arena.draw(screen.newTextGraphics());
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        score =0;
        arena = new Arena(80,24, 4,3,5,1);
        hero = new Hero(10,10);
        while (true){
            draw();
            try {
                com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
                processKey(key);
                if(KeyType.EOF == key.getKeyType())
                    break;
                if(arena.verifyMonsterCollisions())
                {
                    break;
                }
                if(arena.nextLevel()){
                    score+=arena.getNumcoins();
                    arena=new Arena(80,24,arena.getNummons()+1,arena.getNumtrack()+1,arena.getNumcoins()+1,arena.getLevel()+1);
                    hero=new Hero(10,10);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        GameOver();
        /*
        KeyStroke finkey = null;
        while (true){
            try {
                finkey = screen.readInput();
                processKey(finkey);
                if(KeyType.EOF == finkey.getKeyType()){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }





    private void GameOver(){
        screen.newTextGraphics().setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        screen.newTextGraphics().fillRectangle(new TerminalPosition(0, 0), new TerminalSize(80, 24), ' ');
        screen.newTextGraphics().setForegroundColor(TextColor.Factory.fromString("#FF3300"));
        screen.newTextGraphics().putString(new TerminalPosition(40, 12), "PERDEU VIADO: "+score+" PONTOS (Enter to close)");
        KeyStroke finkey = null;
        while (true){
            try {
                finkey = screen.readInput();
                processKey(finkey);
                if(KeyType.EOF == finkey.getKeyType()){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void processKey(KeyStroke key){
        if ((key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') || key.getKeyType()==KeyType.Enter){
            try {
                screen.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        arena.processKey(key);

    }

}
