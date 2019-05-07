package table.studentBL;

import table.Student;
import table.studentDAO.StudentDAO;

import java.util.ArrayList;

public class StudentBL {
    private StudentDAO std;
    public StudentBL(){
        std=new StudentDAO();
    }
    public void register(Student st){
        std.insert(st);
    }

    public ArrayList<Student> showAllStudent()  {
        try {
            return std.getAllStudent();
        }catch (Exception em){
            System.out.println("khata dar namayesh :+" +em.getMessage());
            return null;
        }

    }
}
