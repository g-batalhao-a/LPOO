import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Arena {
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    private int width;
    private int height;
    private Hero hero;
    Arena(int width, int height){
        hero= new Hero(10,10);
        this.width=width;
        this.height=height;
        this.walls = createWalls();
        this.coins=createCoins();
        this.monsters=createMonsters();
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        Position coin_pos;
        for (int i = 0; i < 5; i++){
            coin_pos = new Position( random.nextInt(width - 2) + 1,random.nextInt(height - 2) + 1);
            if(!coin_pos.equals(hero.getPosition()))
                coins.add(new Coin(coin_pos.getX(),coin_pos.getY()));
            else
                i--;
        }

        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        Position mons_pos;
        for (int i = 0; i < 2; i++){
            mons_pos = new Position( random.nextInt(width - 2) + 1,random.nextInt(height - 2) + 1);
            if(!mons_pos.equals(hero.getPosition()))
                monsters.add(new Monster(mons_pos.getX(),mons_pos.getY()));
            else
                i--;
        }

        return monsters;
    }

    public void moveMonsters(){
        Position prev;
        for(Monster monster : monsters){
            prev = monster.getPosition();
            monster.setPosition(monster.move());
            if(!canMonsterMove(monster))
                monster.setPosition(prev);
        }
    }

    public boolean canMonsterMove(Monster monster){
        for(Wall wall : walls){
            if(wall.getPosition().equals(monster.getPosition()))
                return false;
        }
        return true;
    }

    public boolean verifyMonsterCollisions(){
        for(Monster monster: monsters){
            if(monster.getPosition().equals(hero.getPosition())){
                System.out.println("You Lose!");
                return true;
            }

        }
        return false;
    }


    public void processKey(KeyStroke key){
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
        retrieveCoins();
        moveMonsters();
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
        for(Coin coin: coins){
            coin.draw(graphics);
        }
        for(Monster monster: monsters){
            monster.draw(graphics);
        }

    }
    public void moveHero(Position position){
        if(canHeroMove(position))
            hero.setPosition(position);


    }
    private boolean canHeroMove(Position position){
        for(Wall wall : walls){
            if(wall.getPosition().equals(position))
                return false;
        }
        return true;
    }
    public void retrieveCoins(){
        List<Coin> new_coins = new ArrayList<>();
        for(Coin coin : coins)
            if(!coin.getPosition().equals(hero.getPosition())){
                new_coins.add(coin);

        }
        coins=new_coins;
    }
}
