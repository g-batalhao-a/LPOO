import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Hero extends Element{
    Hero(int x, int y){
        super(x,y);
    }
    public Position moveUp(){
        return super.getPosition().moveUp();
    }
    public Position moveDown(){
        return super.getPosition().moveDown();
    }
    public Position moveLeft(){
        return super.getPosition().moveLeft();
    }
    public Position moveRight(){
        return super.getPosition().moveRight();
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getX(), super.getY()), "X");
    }

}
