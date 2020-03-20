public class Application {
    public static void main(String args[]){
        AreaAggregator aa = new AreaAggregator();

        aa.addShape(new Circle(1));
        aa.addShape(new Square(1));
        aa.addShape(new Square(2));
        aa.sum();
        System.out.println(aa.output());

        aa.addShape(new Elipse(1,2));
        aa.sum();
        System.out.println(aa.outputXML());
    }
}
