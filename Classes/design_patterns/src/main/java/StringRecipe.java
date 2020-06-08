import java.util.List;

public class StringRecipe {
    private List<StringTransformer> trans;
    public StringRecipe(List<StringTransformer> trans){
        this.trans=trans;
    }
    public void mix(StringDrink drink){
        for(StringTransformer transf: trans){
            transf.execute(drink);
        }
    }
}
