import java.util.List;

public class StringTransformerGroup implements StringTransformer{
    private List<StringTransformer> trans;
    public StringTransformerGroup(List<StringTransformer> trans){
        this.trans=trans;
    }
    @Override
    public void execute(StringDrink drink){
        for(StringTransformer transf: trans){
            transf.execute(drink);
        }
    }
}
