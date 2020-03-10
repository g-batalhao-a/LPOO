public class Attendee extends User{
    private boolean paid;
    public Attendee(String name, int age){
        super(name,age);
        this.paid=false;
    }
    public  Attendee(String name){
        super(name);
        this.paid=false;
    }

    public boolean hasPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Attendee " + getName()+(paid?" has":" hasn't")+
                " paid its registration.";
    }

}
