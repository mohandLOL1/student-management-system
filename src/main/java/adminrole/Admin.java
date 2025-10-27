package adminrole;

import fileio.FileHandler;
import java.io.IOException;
import java.util.ArrayList;
import misc.Generator;
import model.Student;

public class Admin {

    private final FileHandler fileHandler;

    public Admin() {
        try {
            this.fileHandler = new FileHandler("data/students.txt");
            this.fileHandler.readFromFile();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load student data", e);
        }
    }

    public void addStudent(String name, int age, String gender, String department, double gpa) throws IOException { //check duplicate students
        fileHandler.readFromFile();
        ArrayList<Student> l = fileHandler.returnAllRecords();
        for (int i = 0; i < l.size(); i++) {
            Student s = l.get(i);
            if (s == null) {
                continue;
            }
            if (s.getName().equalsIgnoreCase(name) && s.getAge() == age && s.getGPA() == gpa && s.getGender().equalsIgnoreCase(gender) && s.getDepartment().equalsIgnoreCase(department)) {
                throw new IllegalArgumentException("This student already exists!");
            }
        }
        Student temp = new Student(name, age, gender, department, gpa);
        while (fileHandler.contains(temp.getID())) {
            temp.setNewID(Integer.toString(Generator.randomID()));
        }
        fileHandler.insertRecord(temp);

    }
    
    public ArrayList<Student> getArrayListofStudents(){
        return fileHandler.returnAllRecords();
    }

    public Student[] getListOfStudents() {
        ArrayList<Student> list = fileHandler.returnAllRecords();
        return list.toArray(new Student[0]);
    }

    public void removeStudent(String key) {
        if (!fileHandler.deleteRecord(key)) {
            throw new IllegalArgumentException("Student not found");
        }
    }

    public Student getStudent(String key) throws IOException {
        fileHandler.readFromFile();
        Student temp = fileHandler.getRecord(key);
        if (temp == null) {
            throw new IllegalArgumentException("Student not found");
        }
        return temp;
    }

    public ArrayList<Student> getStudent_byname(String name) throws IOException {
        fileHandler.readFromFile();
        ArrayList<Student> temp = fileHandler.getRecord_byname(name);
        if (temp == null) {
            throw new IllegalArgumentException("Student not found");
        }
        return temp;
    }
        
    public void logout() {
        try {
            fileHandler.saveToFile();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save data to file", e);
        }
    }

   public void updateStudent(Student updatedStudent) {
    ArrayList<Student> students = fileHandler.returnAllRecords();
    
    for (Student s : students) {
        if (updatedStudent.getID().equals(s.getID())) {
            System.out.println("Found matching student!");
            
            s.setName(updatedStudent.getName());
            s.setAge(updatedStudent.getAge());
            s.setGender(updatedStudent.getGender());
            s.setDepartment(updatedStudent.getDepartment());
            s.setGPA(updatedStudent.getGPA());
            
            
            logout();
            break;
        }
    }
    
    
    
    
 

}

}


