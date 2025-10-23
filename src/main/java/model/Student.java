package model;

import misc.*;

public class Student {

    private String ID;
    private String name;
    private int age;
    private String gender;
    private String department;
    private double gpa;

    public Student() {
        this.ID = Integer.toString(Generator.randomID());
    }
    
    public Student(String name, int age, String gender, String department, double gpa){
        setAge(age);
        setName(name);
        setGender(gender);
        setDepartment(department);
        setGPA(gpa);
        this.ID = Integer.toString(Generator.randomID());
    }


    public void setNewID(String ID) {
        if (StudentValidations.validateID(ID) == false) {
            throw new IllegalArgumentException("Invalid ID, has to be between 10000 to 20000");
        }

        this.ID = ID;
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (StudentValidations.validateAge(age) == false) {
            throw new IllegalArgumentException("Age must be within valid range (16-99)");
        }

        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (StudentValidations.validateGender(gender) == false) {
            throw new IllegalArgumentException("Gender must be either male or female");
        }
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (StudentValidations.validateDepartment(department) == false) {
            throw new IllegalArgumentException("Invalid departement, please choose from either of these (mechanical, electrical, civil, computer)");
        }
        this.department = department;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
        if (StudentValidations.validateGPA(gpa) == false) {
            throw new IllegalArgumentException("Invalid GPA range, please enter gpa from (0 to 4.0)");
        }
        this.gpa = gpa;
    }

    public String lineRepresentation() {
        String stringAge = Integer.toString(this.age);
        String stringGPA = Double.toString(this.gpa);
        return this.ID + "," + this.name + "," + stringAge + "," + this.gender.toLowerCase() + "," + this.department.toLowerCase() + "," + stringGPA;
    }
}
