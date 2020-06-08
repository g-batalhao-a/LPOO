import java.util.ArrayList;
import java.util.List;

public class Band extends Act{
    private List<Artist> artists;
    public Band(String name, String country) {
        super(name, country);
        this.artists=new ArrayList<>();
    }

    public List<Artist> getArtists() {
        return artists;
    }
    public void addArtist(Artist artist){
        this.artists.add(artist);
    }

    public boolean containsArtist(Artist artist){
        return artists.contains(artist);
    }
}
