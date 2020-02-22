import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;

public class Game {
    private Screen screen;
    private Hero hero;
    Game(){
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
            Position position = new Position(10,10);
            hero = new Hero(position);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw(){
        screen.clear();
        hero.draw(screen);
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        while (true){
            draw();
            try {
                com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
                processKey(key);
                if(KeyType.EOF == key.getKeyType())
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
    private void processKey(KeyStroke key){
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
            try {
                screen.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        switch (key.getKeyType()){
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
        }

    }
    private void moveHero(Position position){
        hero.setPosition(position);
    }
}
