package table.studentDAO;

import table.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public StudentDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ana", "myjava123");
        } catch (Exception ms) {
            System.out.println("could not connect to db" + ms.getMessage());
        }
    }

    public void insert(Student st) {
        try {
            preparedStatement = connection.prepareStatement("insert into student(id,name,lastname,unitname,unitgrade) values(?,?,?,?,?)");
            preparedStatement.setLong(1, st.getId());
            preparedStatement.setString(2, st.getName());
            preparedStatement.setString(3, st.getFamily());
            preparedStatement.setString(4, st.getUnitname());
            preparedStatement.setString(5, st.getUnitgrade());
            preparedStatement.executeUpdate();
        } catch (Exception ms) {
            System.out.println("khata dar insert student: " + ms.getMessage());
        }
    }
    public ArrayList<Student> getAllStudent() throws Exception{
        preparedStatement=connection.prepareStatement("select * from student");
        ResultSet rs=preparedStatement.executeQuery();
        ArrayList<Student> list=new ArrayList<>();
        while (rs.next()) {
            Student st=new Student();
            st.setId(rs.getInt("id"));
            st.setName(rs.getString("name"));
            st.setFamily(rs.getString("lastname"));
            st.setUnitname(rs.getString("unitname"));
            st.setUnitgrade(rs.getString("unitgrade"));
            list.add(st);
        }
        return list;

    }








}
