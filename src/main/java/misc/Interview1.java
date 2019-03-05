package misc;

import java.util.*;

/**
 * Created by kraghunathan on 6/11/18.
 */
public class Interview1 {

        public static void main(String[] args) {

            String val ="abcdefghijklmnopqrstuvwxyz";

           /* Pattern p = Pattern.compile("^[abcdefghijklmnopqrstuvwxyz]+$");
            Matcher m = p.matcher(val);

            while (m.find()) System.out.println(m.group());*/

            char[] charArray = val.toCharArray();
            Map<Character,Integer> m = new LinkedHashMap<>();
            for(int i=0;i<charArray.length;i++) {

                m.put(charArray[i], 1);

            }
            System.out.println(m);

        }
}
