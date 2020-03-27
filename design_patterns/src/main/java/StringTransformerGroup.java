import java.util.List;

public class StringTransformerGroup {
    private List<StringTransformer> trans;
    public StringTransformerGroup(List<StringTransformer> trans){
        this.trans=trans;
    }
    public void execute(StringDrink drink){
        for(StringTransformer transf: trans){
            transf.execute(drink);
        }
    }
}
