package src;
import java.sql.Date;

public class FullTimeStudent extends Student{

    public FullTimeStudent(int id,String fn,String ln,Date doj){
        super(id,fn,ln,doj);
    }

    public String getType(){
        return "FullTime";
    }
}
