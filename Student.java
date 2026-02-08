package src;
import java.sql.Date;

public abstract class Student {

    private int id;
    private String firstName;
    private String lastName;
    private Date doj;

    public Student(int id,String fn,String ln,Date doj){
        this.id=id;
        this.firstName=fn;
        this.lastName=ln;
        this.doj=doj;
    }

    public int getId(){ return id; }
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public Date getDoj(){ return doj; }

    public abstract String getType();

    public String toString(){
        return id+" "+firstName+" "+lastName+" "+doj+" "+getType();
    }
}
