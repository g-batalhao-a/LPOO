public class Rectangle implements Shape {
    private int width, height;
    public Rectangle(int width, int height){
        this.width=width;
        this.height=height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return this.width*this.height;
    }
}
