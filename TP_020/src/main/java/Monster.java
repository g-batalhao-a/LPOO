import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster extends Element {
    Monster(int x , int y){
        super(x,y);
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFDAB9"));
        graphics.putString(new TerminalPosition(super.getX(), super.getY()), "M");
    }
    public Position move(){
        Random random = new Random();
        ArrayList<Position> adjacent = new ArrayList<>();
        adjacent.add(new Position(super.getX()-1,super.getY()-1));
        adjacent.add(new Position(super.getX(),super.getY()-1));
        adjacent.add(new Position(super.getX()+1,super.getY()-1));
        adjacent.add(new Position(super.getX()-1,super.getY()));
        adjacent.add(new Position(super.getX()+1,super.getY()));
        adjacent.add(new Position(super.getX()-1,super.getY()+1));
        adjacent.add(new Position(super.getX(),super.getY()+1));
        adjacent.add(new Position(super.getX()+1,super.getY()+1));

        return adjacent.get(random.nextInt(8));
    }
}
