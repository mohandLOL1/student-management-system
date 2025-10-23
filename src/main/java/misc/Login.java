package misc;

import java.io.*;

import java.util.Scanner;

public class Login {

    public static boolean user_login(String Username, String Password){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("data/users.txt"));
        } catch (FileNotFoundException ex) {
            System.getLogger(Login.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            String[] tokens = line.split(",");
            String name = tokens[0].trim();
            String pass = tokens[1].trim();
            if (Username.equals(name) && Password.equals(pass)) {
                return true;
            }
        }
        scanner.close();
        return false;
    }

}
