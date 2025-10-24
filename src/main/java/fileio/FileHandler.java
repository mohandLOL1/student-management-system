package fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class FileHandler {

    private String filename;
    private final ArrayList<Student> records;

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

        Student s = new Student(name, age, gender, department, gpa);
        s.setNewID(ID); 
        return s;
    }

    public ArrayList<Student> returnAllRecords() {
        return this.records;
    }

    public boolean contains(String key) {
       
        for (Student record : records) {
            if (record.getID().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Student getRecord(String key) {
   
        for (Student record : records) {
            if (record.getID().equals(key)) {
                return record;
            }
        }
        return null;
    }
    public ArrayList<Student> getRecord_byname(String name) {
        ArrayList<Student> l= new ArrayList<>();
        for (Student record : records) {
            if (record.getName().equalsIgnoreCase(name)) {
               l.add(record);
            }
        }
        return l;
    }

    public void insertRecord(Student record) {
            records.add(record);
    }

    public boolean deleteRecord(String key){
        
       
        for(Student record : records){
            if(record.getID().equals(key)){
                records.remove(record);
                return true;
            }
        }
        return false;
    }
    
    public void saveToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(getFilename()));
        for (Student record : records) {
            writer.write(record.lineRepresentation() + "\n");
        }
        writer.close();
    }
}
