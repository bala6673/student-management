package src;
import java.sql.Date;

public class PartTimeStudent extends Student{

    public PartTimeStudent(int id,String fn,String ln,Date doj){
        super(id,fn,ln,doj);
    }

    public String getType(){
        return "PartTime";
    }
}
