package player;

public class Player {
    public String name;
    int age;
    String address;
    long phoneno;
    String emailid;
    public char symbol;
    public void setDetails(String name,int age,String address,long phoneno,String emailid,char symbol){
        this.name=name;
        this.age=age;
        this.address=address;
        this.phoneno=phoneno;
        this.emailid=emailid;
        this.symbol=symbol;
    }
    public char getSymbol(){
        return symbol;
    }
    public String getPlayer(){
        return name;
    }
    public void getDetails(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(address);
        System.out.println(phoneno);
        System.out.println(emailid);
        System.out.println(symbol);
    }


}
