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
        
        while((line = reader.readLine()) != null){
            if (line.isEmpty()) continue;
            records.add(createRecordFrom(line));
        }
        reader.close();
        System.out.println("Read from " + this.getFilename() + " Successfully, record size is " + records.size());
    }
    
    public Student createRecordFrom(String line){
        
    }
    public ArrayList<Student> returnAllRecords(){
        
        return this.records;
        
    }
    public boolean contains(String key){
    }
    public Student getRecord(String key){
     return 
    }

    public void insertRecord(Student record){
    }

    public void deleteRecord(String key){
    }

    public void saveToFile(){
    }
    

}
