
package misc;

import java.util.Random;


public class Generator {
    
   public static int randomID(){ //generates random ID from 10000 to 20000
        Random rand = new Random();
        int ID = 10000 + rand.nextInt(10001);
        return ID;
    }
}
