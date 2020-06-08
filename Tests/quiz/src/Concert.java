import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    private String city;
    private String country;
    private String date;
    private List<Act> acts;

    public Concert(String city, String country, String date){
        this.city=city;
        this.country=country;
        this.date=date;
        this.acts=new ArrayList<>();
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public List<Act> getActs() {
        return acts;
    }
    public void addAct(Act act){
        this.acts.add(act);
    }

    public boolean isValid(Ticket ticket){
        return ticket.getConcert()==this;
    }

    public boolean participates(Artist artist){
        for(Act a: acts){
            if(a instanceof Artist) if(a.equals(artist)) return true;
            if(a instanceof Band) if(((Band) a).containsArtist(artist)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(city, concert.city) &&
                Objects.equals(country, concert.country) &&
                Objects.equals(date, concert.date) &&
                Objects.equals(acts, concert.acts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date, acts);
    }
}
