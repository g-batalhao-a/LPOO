public class AreaXMLOutputter {
    private AreaAggregator aa;
    public AreaXMLOutputter(AreaAggregator aa){
        this.aa=aa;
    }
    public String outputXML(){
        return "<area>"+aa.sum()+"</area>";
    }
}
