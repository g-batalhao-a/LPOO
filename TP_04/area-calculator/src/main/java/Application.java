public class Application {
    public static void main(String args[]){
        AreaAggregator aa = new AreaAggregator();
        AreaStringOutputter stringOutputter = new AreaStringOutputter(aa);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aa);

        aa.addArea(new Circle(1));
        aa.addArea(new Square(1));
        aa.addArea(new Square(2));
        aa.sum();
        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.outputXML());

        aa.addArea(new Elipse(1,2));
        aa.sum();
        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.outputXML());

        aa.addArea(new Triangle(1,2));
        aa.sum();
        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.outputXML());

        aa.addArea(new House());
        aa.sum();
        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.outputXML());
    }
}
