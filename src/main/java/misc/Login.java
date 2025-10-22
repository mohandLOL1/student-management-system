
package misc;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
  private String Username;
  private String Password;

public Login(String Username, String Password) {
     this.Username = Username;
     this.Password = Password;
}

public boolean user_login(String Username, String Password)throws IOException{
  Scanner f=new Scanner(new File("users.txt"));
 
  while(f.hasNextLine()){
    String l=f.nextLine().trim();
    String [] tokens=l.split(",");
    String name=tokens[0].trim();
    String pass=tokens[1].trim();
  if(Username.equals(name)&&Password.equals(pass)){
      return true;}
  }
  f.close();
      return false;
}

public void setUsername(String Username) {
     this.Username = Username;
}

public void setPassword(String Password) {
     this.Password = Password;
}


public String getUsername() {
     return Username;
}

public String getPassword() {
     return Password;
}
  
}
