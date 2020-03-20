public class Application {
    public static void main(String args[]){
        AreaAggregator aa = new AreaAggregator();
        AreaStringOutputter stringOutputter = new AreaStringOutputter(aa);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aa);

        aa.addShape(new Circle(1));
        aa.addShape(new Square(1));
        aa.addShape(new Square(2));
        aa.sum();
        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.outputXML());

        aa.addShape(new Elipse(1,2));
        aa.sum();
        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.outputXML());
    }
}
