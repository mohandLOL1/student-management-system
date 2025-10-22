
package misc;

import java.io.*;

public class studentValidations {
    public static boolean validateID(int ID) { //random ID, with only digits from 10000 to 20000

      return ID>=10000 && ID<=20000;
    }

    public static boolean validateGender(String gender) { //either male/female
      if(gender==null)
        return false;
      
      if(gender.toLowerCase().equals("male") || gender.toLowerCase().equals("female"))
        return true;
      
      return false;
    }
    
    public static boolean validateDepartment(String department){ //only letters 
     if(department==null)
       return false;
     
     char[]Department=department.toCharArray();
     
     for(int i=0;i<department.length();i++){
       if(!Character.isLetter(Department[i])){
          System.out.println("department not exist");
        return false;
       }
     }
     return true;
    }
    
    public static boolean validateGPA(double gpa){ //number from 0 to 4.0
     
       return gpa>=0 && gpa<=4.0;
    }
    public static boolean validateAge(int age){ //number from 16 to 99
        
       return age>=16 && age<=99;
    }
}
