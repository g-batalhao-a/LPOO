import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import java.util.ArrayList;
import java.util.Random;

public class Tracker extends Element {
    Tracker(int x , int y){
        super(x,y);
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#808000"));
        graphics.putString(new TerminalPosition(super.getX(), super.getY()), "T");
    }
    public Position move(Position heropos){
        Position p = new Position(super.getX(),super.getY());
        if(heropos.getX()==p.getX()){
            if(heropos.getY()>p.getY())
                p.setY(p.getY()+1);
            else
                p.setY(p.getY()-1);
        }
        else if(heropos.getY()==super.getY()){
            if(heropos.getX()>p.getX())
                p.setX(p.getX()+1);
            else
                p.setX(p.getX()-1);
        }
        else if(Math.abs(heropos.getY()-p.getY())>Math.abs(heropos.getX()-p.getX())) {
            if (heropos.getY() > p.getY())
                p.setY(p.getY() + 1);
            else
                p.setY(p.getY() - 1);
        }
        else{
            if(heropos.getX()>p.getX())
                p.setX(p.getX()+1);
            else
                p.setX(p.getX()-1);
        }

        return p;
    }
}
