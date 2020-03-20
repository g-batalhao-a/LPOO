public class Square implements AreaShape {
    private int side;
    public Square(int side){
        this.side=side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return Math.pow(this.side,2);
    }

    @Override
    public void draw() {
        System.out.println("Square");
    }
}
