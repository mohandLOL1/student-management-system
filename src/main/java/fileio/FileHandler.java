package fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import model.Student;

public class FileHandler {

    private String filename;
    private ArrayList<Student> records;

    public FileHandler(String filename) {
        this.setFilename(filename);
        this.records = new ArrayList<>();

    }

    public void setFilename(String filename) {

        Path path = Paths.get(filename);

        if (!Files.exists(path)) {
            throw new IllegalArgumentException("File not found: " + path.toAbsolutePath());
        }

        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void readFromFile() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(getFilename()));
        String line;

        ArrayList<Student> records = returnAllRecords();
        records.clear();

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            records.add(createRecordFrom(line));
        }
        reader.close();
        System.out.println("Read from " + this.getFilename() + " Successfully, record size is " + records.size());
    }

    public Student createRecordFrom(String line) {
        String[] tokens = line.split(",");

        String ID = tokens[0];
        String name = tokens[1];
        int age = Integer.parseInt(tokens[2]);
        String gender = tokens[3];
        String department = tokens[4];
        double gpa = Double.parseDouble(tokens[5]);

        return new Student(ID, name, age, gender, department, gpa);
    }

    public ArrayList<Student> returnAllRecords() {
        return this.records;
    }

    public boolean contains(String key) {
        ArrayList<Student> records = returnAllRecords();
        for (Student record : records) {
            if (record.getID().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Student getRecord(String key) {
        ArrayList<Student> records = returnAllRecords();
        for (Student record : records) {
            if (record.getID().equals(key)) {
                return record;
            }
        }
        return null;
    }

    public boolean insertRecord(Student record) {

        ArrayList<Student> records = returnAllRecords();
        if (!contains(record.getID())) {
            records.add(record);
            return true;

        } else {
            return false;
        }

    }

    public boolean deleteRecord(String key){
        
        ArrayList<Student> records = returnAllRecords();
        for(Student record : records){
            if(record.getID().equals(key)){
                records.remove(record);
                return true;
            }
        }
        return false;
    }
    
    public void saveToFile() {
        
    }
}
