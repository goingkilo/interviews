package misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by kraghunathan on 6/28/18.
 */
public class Exception {

    public static void main(String[] args) {

        try {
            new FileInputStream(new File("/Users/kraghunathan/donotexist"));
        }
        catch( FileNotFoundException fe) {
            fe.printStackTrace();
            //this will raise an exception
//            throw fe;
        }
        catch(java.lang.Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
