import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element {
    Coin(int x , int y){
        super(x,y);
    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF3333"));
        graphics.putString(new TerminalPosition(super.getX(), super.getY()), "O");
    }

}
