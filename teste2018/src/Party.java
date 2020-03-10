public class Party extends Event{
    public Party(String title, String date, String description){
        super(title,date,description);
    }

    public void addEvent(Event e) {
        for(Person person:e.getAudience()){
            super.addPerson(person);
        }
    }
}
