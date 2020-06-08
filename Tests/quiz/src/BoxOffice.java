import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoxOffice {
    static private Map<Concert,Integer> concertMap=new HashMap<>();
    public static List<Ticket> buy(Concert concert, int number){
        int start=0;
        if(!concertMap.containsKey(concert)) concertMap.put(concert,number);
        else start=concertMap.get(concert);
        List<Ticket> tickets = new ArrayList<>();
        for(int i=start;i<number+start;i++ ){
            tickets.add(new Ticket(i+1,concert));
        }
        return tickets;
    }
}
