package src;

import java.sql.*;

public class StudentDAO {

    Connection con;

    public StudentDAO() throws Exception {
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/studentdb", "root", "root");
    }

    public void addStudent(int ch) throws Exception {
        System.out.println("Enter id fname lname doj(yyyy-mm-dd)");
        int id = sc.nextInt();
        String fn = sc.next();
        String ln = sc.next();
        Date doj = Date.valueOf(sc.next());

        Student s;

        if (ch == 1)
            s = new PartTimeStudent(id, fn, ln, doj);
        else
            s = new FullTimeStudent(id, fn, ln, doj);
        PreparedStatement ps = con.prepareStatement(
                "insert into students values(?,?,?,?,?)");

        ps.setInt(1, s.getId());
        ps.setString(2, s.getFirstName());
        ps.setString(3, s.getLastName());
        ps.setDate(4, s.getDoj());
        ps.setString(5, s.getType());
        ps.executeUpdate();
    }

    public void removeStudent() throws Exception {

        System.out.println("Enter id");
        int rid = sc.nextInt();
        PreparedStatement ps = con.prepareStatement(
                "delete from students where id=?");
        ps.setInt(1, rid);
        ps.executeUpdate();
    }

    public void viewAll() throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * from students");
        while (rs.next()) {
            System.out.println(rs.getString("id") + " " + rs.getString("firstname"));
        }
    }

    public void view() throws Exception {
        System.out.println("Enter id");
        int vid = sc.nextInt();
        PreparedStatement st = con.prepareStatement("select firstname from students where id=?");
        st.setInt(1, vid);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            System.out.println(rs.getString("id") + " " + rs.getString("firstname"));
        }
    }

    public void sort(String orderby) throws Exception {
        String query = "select * from students order by " + orderby;
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("id") + " " + rs.getString("firstname"));
        }

    }

}
