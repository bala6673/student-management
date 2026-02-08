package src;
import java.sql.*;

public class StudentDAO {

    Connection con;

    public StudentDAO() throws Exception{
        con=DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/studentdb","root","root");
    }

    public void addStudent(Student s) throws Exception{
        PreparedStatement ps=con.prepareStatement(
        "insert into students values(?,?,?,?,?)");

        ps.setInt(1,s.getId());
        ps.setString(2,s.getFirstName());
        ps.setString(3,s.getLastName());
        ps.setDate(4,s.getDoj());
        ps.setString(5,s.getType());
        ps.executeUpdate();
    }

    public void removeStudent(int id) throws Exception{
        PreparedStatement ps=con.prepareStatement(
        "delete from students where id=?");
        ps.setInt(1,id);
        ps.executeUpdate();
    }
    public void viewAll() throws Exception{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * from students");
        while(rs.next()){
            System.out.println(rs.getString("id")+" "+rs.getString("firstname"));
        }
    }
    public void view(int id) throws Exception{
        PreparedStatement st =  con.prepareStatement("select firstname from students where id=?");
        st.setInt(1,id);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            System.out.println(rs.getString("id")+" "+rs.getString("firstname"));
        }
    }
    public void sort( String orderby) throws Exception{
        String query = "select * from students order by " + orderby;
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("id")+" "+rs.getString("firstname"));
        }


    }
   


}
