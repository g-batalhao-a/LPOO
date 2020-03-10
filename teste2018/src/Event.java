import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Event {
    private String title;
    private String date;
    private String description;
    private List<Person> audience;
    public Event(String title, String date, String description){
        this.title=title;
        this.date=date;
        this.description=description;
        this.audience= new ArrayList<Person>();
    }
    public Event(String title){
        this(title,"","");
        this.audience= new ArrayList<Person>();
    }
    public Event(String title, String date){
        this(title,date,"");
        this.audience= new ArrayList<Person>();
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
    public Event(Event e){
        this.title=e.getTitle();
        this.date=e.getDate();
        this.description=e.getDescription();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "" +
                title + " is a " +
                description + " and will be held at "
                + date+".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) &&
                Objects.equals(date, event.date) &&
                Objects.equals(description, event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, description);
    }

    public void addPerson(Person p){
        if(audience.isEmpty()){
            audience.add(p);
        }
        else{
            for(Person person: audience){
                if(p.equals(person)){
                    return;
                }
            }
            audience.add(p);

        }
    }

    public int getAudienceCount() {
        return audience.size();
    }

    public List<Person> getAudience() {
        return audience;
    }
}

