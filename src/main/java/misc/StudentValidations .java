package misc;

import java.util.Set;

public class StudentValidations {

    public static boolean validateID(String stringID) { //random ID, with only digits from 10000 to 20000
        int ID = Integer.parseInt(stringID);

        return ID >= 10000 && ID <= 20000;
    }

    public static boolean validateGender(String gender) { //either male/female
        if (gender == null) {
            return false;
        }

        if (gender.toLowerCase().equals("male") || gender.toLowerCase().equals("female")) {
            return true;
        }

        return false;
    }

    public static boolean validateDepartment(String department) { //only letters 
        if (department == null) {
            return false;
        }
        department = department.trim();
        Set<String> VALID_DEPARTMENTS = Set.of("mechanical engineering", "electrical engineering", "civil engineering", "computer engineering");

        if (!VALID_DEPARTMENTS.contains(department.toLowerCase())) {
            return false;
        }

        return true;
    }

    public static boolean validateGPA(double gpa) { //number from 0 to 4.0

        return gpa >= 0 && gpa <= 4.0;
    }

    public static boolean validateAge(int age) { //number from 16 to 99

        return age >= 16 && age <= 99;
    }

    public static void validate_name(String Name) {

        char[] name = Name.toCharArray();

        for (int i = 0; i < Name.length(); i++) {
            if (!Character.isLetter(name[i])) {
                throw new IllegalArgumentException("Name must be letters only");
            }
        }

    }
}
