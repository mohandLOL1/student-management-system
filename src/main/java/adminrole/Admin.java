package adminrole;

import fileio.FileHandler;
import java.io.IOException;
import java.util.ArrayList;
import misc.Generator;
import model.Student;

public class Admin {

    private final FileHandler fileHandler;

    public Admin(){
    try {
        this.fileHandler = new FileHandler("data/students.txt");
        this.fileHandler.readFromFile();
    } catch (IOException e) {
        throw new RuntimeException("Failed to load student data", e);
    }
    }

    public void addStudent(String name, int age, String gender, String department, double gpa){

        Student temp = new Student(name, age, gender, department, gpa);
        while (fileHandler.contains(temp.getID())) {
            temp.setNewID(Integer.toString(Generator.randomID()));
        }
        fileHandler.insertRecord(temp);
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

    public Student getStudent(String key) {
        Student temp = fileHandler.getRecord(key);
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
}
