public class Triangle implements Shape {
    private int height, base;
    public Triangle(int height, int base){
        this.height=height;
        this.base=base;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    @Override
    public double getArea() {
        return (this.height*this.base)/2;
    }
}
