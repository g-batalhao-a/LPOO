public class HumanClient implements Client {
    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {

    }

    @Override
    public void happyHourStarted(Bar bar) {
        bar.isHappyHour();
    }

    @Override
    public void happyHourEnded(Bar bar) {
        bar.endHappyHour();
    }
}
