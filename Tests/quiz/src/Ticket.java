public class Ticket {
    private int number;
    private Concert concert;
    public Ticket(int number, Concert concert) {
        if(number<=0) throw new InvalidTicket();
        else{
            this.number=number;
            this.concert=concert;
        }


    }

    public Concert getConcert() {
        return concert;
    }

    public int getNumber() {
        return number;
    }


}
