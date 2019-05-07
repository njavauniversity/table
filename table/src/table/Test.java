package table;

import table.studentBL.StudentBL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.http.HttpClient;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        JFrame firstframe=new JFrame();
        firstframe.setBounds(0,0,400,400);
        JPanel panel=new JPanel();

        JTextField jid=new JTextField(10);
        jid.setToolTipText("only number");
        JTextField jname=new JTextField(10);
        JTextField jfamily=new JTextField(10);
        JTextField junitname=new JTextField(10);
        JTextField junitgrade=new JTextField(10);




        JLabel idlabel=new JLabel("Id");
        JLabel namelabel=new JLabel("Name");
        JLabel familylabel=new JLabel("Lastname");
        JLabel unitnamelabel=new JLabel("Unitname");
        JLabel unitgradelabel=new JLabel("Unitgrade");




        JButton register=new JButton("Register");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentBL studentBL=new StudentBL();
                Student st=new Student();
                st.setName(jname.getText());
                st.setFamily(jfamily.getText());
                st.setUnitname(junitname.getText());
                st.setUnitgrade(junitgrade.getText());
                st.setId(Integer .parseInt(jid.getText()));

                studentBL.register(st);

                JFrame peygham=new JFrame();
                peygham.setBounds(200,200,400,400);
                JPanel panel1=new JPanel();
                JLabel label=new JLabel("ثبت شد");

                panel1.add(label);
                peygham.add(panel1);
                peygham.setVisible(true);

            }
        });
        JButton tablebutton=new JButton("Grade list");
        tablebutton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("برای مشاهده لیست نمره دانش آموزان روی دکمه(لیست نمره) کلیک کنید");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("برای مشاهده لیست نمره دانش آموزان روی دکمه(لیست نمره) کلیک کنید");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("برای مشاهده لیست نمره دانش آموزان روی دکمه(لیست نمره) کلیک کنید");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("برای مشاهده لیست نمره دانش آموزان روی دکمه(لیست نمره) کلیک کنید");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("برای مشاهده لیست نمره دانش آموزان روی دکمه(لیست نمره) کلیک کنید");
            }
        });
        tablebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frametable=new JFrame();
                frametable.setBounds(200,200,400,400);
                JPanel panel2=new JPanel();


                DefaultTableModel defaultTableModel=new DefaultTableModel();
                JTable table=new JTable(defaultTableModel);
                defaultTableModel.addColumn("id");
                defaultTableModel.addColumn("Name");
                defaultTableModel.addColumn("Lastname");
                defaultTableModel.addColumn("Unitname");
                defaultTableModel.addColumn("unitgrade");
                JTableHeader header=table.getTableHeader();
                header.setBackground(Color.blue);

                StudentBL studentBL=new StudentBL();
                ArrayList<Student> list=studentBL.showAllStudent();

                for (Student st:list){
                    defaultTableModel.addRow(new Object[]{st.getId(),st.getName(),st.getFamily(),st.getUnitname(),st.getUnitgrade()} );
                }

                JScrollPane scrollPane=new JScrollPane(table);




                panel2.add(scrollPane);
                frametable.add(panel2);
                frametable.setVisible(true);
            }
        });



        panel.add(idlabel);
        panel.add(jid);

        panel.add(namelabel);
        panel.add(jname);

        panel.add(familylabel);
        panel.add(jfamily);

        panel.add(unitnamelabel);
        panel.add(junitname);

        panel.add(unitgradelabel);
        panel.add(junitgrade);


        panel.add(register);

        panel.add(tablebutton);

        firstframe.add(panel);
        firstframe.setVisible(true);

    }
}
