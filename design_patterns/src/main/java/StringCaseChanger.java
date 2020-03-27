public class StringCaseChanger implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        StringBuffer str = new StringBuffer(drink.getText());
        for(int i=0;i<str.length();i++){
            if(Character.isLowerCase(str.charAt(i))){
                str.setCharAt(i,Character.toUpperCase(str.charAt(i)));
            }
            else{
                str.setCharAt(i,Character.toLowerCase(str.charAt(i)));
            }

        }
        drink.setText(str.toString());

    }
}
