public class User extends Person{
    private String username;
    public User(String name, int age){
        super(name,age);
        this.username=name+age;
    }
    public User(String name){
        super(name);
        this.username=name;
    }

    public String getUsername() {
        return username;
    }
}
