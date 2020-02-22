import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    Game(){
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
        screen.setCharacter(10, 10, new TextCharacter('X'));
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        draw();
    }
}
