package game;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Arena {
    static int count =0;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    private List<Tracker> trackers;
    private int width;
    private int height;
    private int nummons;
    private int numtrack;
    private int numcoins;
    private int level;
    private Hero hero;
    public Arena(int width, int height, int nummons, int numtrack, int numcoins, int level){
        hero= new Hero(10,10);
        this.width=width;
        this.height=height;
        this.walls = createWalls();
        this.nummons=nummons;
        this.numtrack=numtrack;
        this.numcoins=numcoins;
        this.level=level;
        this.coins=createCoins();
        this.monsters=createMonsters();
        this.trackers=createTrackers();
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level=level;
    }
    public int getNumcoins(){
        return numcoins;
    }
    public void setNumcoins(int num_coins){
        this.numcoins=num_coins;
    }
    public int getNummons(){
        return nummons;
    }
    public void setNummons(int num_mons){
        this.nummons=num_mons;
    }
    public int getNumtrack(){
        return numtrack;
    }
    public void setNumtrack(int num_track){
        this.numtrack=num_track;
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
        for (int i = 0; i < numcoins; i++){
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
        for (int i = 0; i < nummons; i++){
            mons_pos = new Position( random.nextInt(width - 2) + 1,random.nextInt(height - 2) + 1);
            if(!mons_pos.equals(hero.getPosition()))
                monsters.add(new Monster(mons_pos.getX(),mons_pos.getY()));
            else
                i--;
        }

        return monsters;
    }

    private List<Tracker> createTrackers() {
        Random random = new Random();
        ArrayList<Tracker> trackers = new ArrayList<>();
        Position mons_pos;
        for (int i = 0; i < numtrack; i++){
            mons_pos = new Position( random.nextInt(width - 2) + 1,random.nextInt(height - 2) + 1);
            if(!mons_pos.equals(hero.getPosition()))
                trackers.add(new Tracker(mons_pos.getX(),mons_pos.getY()));
            else
                i--;
        }

        return trackers;
    }

    public void moveMonsters(){
        count++;
        Position newpos;
        for(Monster monster : monsters){
            newpos = monster.move();
            if(canHeroMove(newpos))
                monster.setPosition(newpos);
        }
        if(count%2==0){
            for(Tracker tracker: trackers){
                newpos = tracker.move(hero.getPosition());
                if(canHeroMove(newpos))
                    tracker.setPosition(newpos);
            }
        }

    }


    public boolean verifyMonsterCollisions(){
        for(Monster monster: monsters){
            if(monster.getPosition().equals(hero.getPosition())){
                hero.setEnergy(hero.getEnergy()-1);
                if(hero.getEnergy()==0){
                    System.out.println("You Lose!");
                    return true;
                }

            }

        }
        for(Tracker tracker: trackers){
            if(tracker.getPosition().equals(hero.getPosition())){
                hero.setEnergy(hero.getEnergy()-1);
                if(hero.getEnergy()==0){
                    System.out.println("You Lose!");
                    return true;
                }

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
        for(Tracker tracker: trackers){
            tracker.draw(graphics);
        }

        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF3333"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(2,0),"Level: "+level);

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

    public boolean nextLevel(){
        if(coins.isEmpty()) {
            return true;
        }
        else
            return false;
    }
}
