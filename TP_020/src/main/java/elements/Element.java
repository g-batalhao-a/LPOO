package elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import game.Position;

public abstract class Element {
    private Position position;
    public Element(int x, int y){
        position = new Position(x,y);
    }

    public abstract void draw(TextGraphics graphics);

    public int getY() {
        return position.getY();
    }
    public int getX() {
        return position.getX();
    }
    public void setY(int y) {
        position.setY(y);
    }
    public void setX(int x) {
        position.setX(x);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
