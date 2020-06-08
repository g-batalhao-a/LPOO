public class Line implements Shape {
    private int length;
    public Line(int length){
        this.length=length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void draw() {
        System.out.println("Line");
    }
}
