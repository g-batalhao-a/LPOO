package elements;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.Position;

public class Hero extends Element{
    private int energy=3;
    public Hero(int x, int y){
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
        switch (energy){
            case 3:
                graphics.setForegroundColor(TextColor.Factory.fromString("#99FF33"));
                break;
            case 2:
                graphics.setForegroundColor(TextColor.Factory.fromString("#FF9900"));
                break;
            case 1:
                graphics.setForegroundColor(TextColor.Factory.fromString("#FF3300"));
                break;
        }

        graphics.enableModifiers(SGR.CIRCLED);
        graphics.putString(new TerminalPosition(super.getX(), super.getY()), "X");
    }
    public int getEnergy() {
        return energy;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }

}
