public class StringReplacer implements StringTransformer {
    private char to_replace, replacer;
    public StringReplacer(char to_replace, char replacer){
        this.to_replace=to_replace;
        this.replacer=replacer;
    }
    @Override
    public void execute(StringDrink drink) {
        drink.setText(drink.getText().replace(to_replace,replacer));
    }
}
