
package model;

public class Student {
    private int ID;
    private String name;
    private int age;
    private String gender;
    private String department;
    private double gpa;
    
    private final static int DEFAULTAGE = 16;
    private final static String DEFAULTGENDER = "N/A";

    public Student(int ID, String name, int age, String gender, String department, double gpa) {
        this.ID = ID;
        this.name = name;
        this.setAge(age);
        this.setGender(gender);
        this.department = department;
        this.gpa = gpa;
    }
    
    

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public boolean setName(String name){
        this.name = name;
        return true;
    }

    public int getAge() {
        return age;
    }

    public boolean setAge(int age) {
        if(age > 16 && age < 99){
            this.age = age;
            return true;
        }
       
       this.age = DEFAULTAGE;
       return false;
    }

    public String getGender() {
        return gender;
    }

    public boolean setGender(String gender) {
        if(gender.toLowerCase().equals("male") || gender.toLowerCase().equals("female")){
            this.gender = gender;
            return true;
        }
        
        this.gender = DEFAULTGENDER;
        return false;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
 
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    public String linerepresentation(){
        return "";
    }
    
   
    
    
}
