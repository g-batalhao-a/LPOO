public class AreaStringOutputter {
    private AreaAggregator aa;
    public AreaStringOutputter(AreaAggregator aa){
        this.aa=aa;
    }

    public String output() {
        return "Sum of areas: " + aa.sum();
    }
}
