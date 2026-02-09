package src;

import java.util.*;
import java.sql.Date;
import java.sql.ResultSet;

public class Main {
    static final String URL = "jdbc:mysql://localhost:3307/studentdb";
    static final String USER = "root";
    static final String PASS = "root";

    static LinkedHashSet<Student> list = new LinkedHashSet<>();

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n1 Add PartTime");
            System.out.println("2 Add FullTime");
            System.out.println("3 Remove");
            System.out.println("4 View");
            System.out.println("5 View All");
            System.out.println("6 Sort DOJ");
            System.out.println("7 Sort ID");
            System.out.println("8 Sort FirstName");
            System.out.println("9 Exit");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                case 2:
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

                    list.add(s);
                    dao.addStudent(s);
                    break;

                case 3:
                    System.out.println("Enter id");
                    int rid = sc.nextInt();
                    list.removeIf(st -> st.getId() == rid);
                    dao.removeStudent(rid);
                    break;

                case 4:
                    System.out.println("Enter id");
                    int vid = sc.nextInt();
                    dao.view(vid);
                    // System.out.println(dao.view(vid));
                    break;

                case 5:
                    dao.viewAll();
                    break;

                case 6:
                    dao.sort("doj");
                    break;

                case 7:
                    dao.sort("id");
                    break;

                case 8:
                    dao.sort("firstname");
                    break;

                case 9:
                    System.exit(0);
            }
        }
    }
}
