public class Position {
    private int x;
    private int y;
    Position(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public Position moveUp(){
        return new Position(getX(),getY()-1);
    }
    public Position moveDown(){
        return new Position(getX(),getY()+1);
    }
    public Position moveLeft(){
        return new Position(getX()-1,getY());
    }
    public Position moveRight(){
        return new Position(getX()+1,getY());
    }
    public boolean equals(Position o) {
        return getX() == o.getX() && getY() == o.getY();
    }
}
