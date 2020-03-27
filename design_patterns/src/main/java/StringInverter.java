public class StringInverter implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        StringBuffer str = new StringBuffer(drink.getText());
        str.reverse();
        drink.setText(str.toString());
    }
}
