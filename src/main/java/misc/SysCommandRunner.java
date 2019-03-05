package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kraghunathan on 3/16/18.
 */
public class SysCommandRunner {


    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println( "Executing " + args[0]);
        new SysCommandRunner().execute( args[0]);
    }

    public void execute( String command) throws IOException, InterruptedException {
        Runtime r = Runtime.getRuntime();
        Process p = r.exec(command);
        p.waitFor();
        BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";

        while ((line = b.readLine()) != null) {
            System.out.println(line);
        }

        b.close();
    }
}
