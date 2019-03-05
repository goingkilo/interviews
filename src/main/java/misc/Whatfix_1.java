package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kraghunathan on 6/6/18.
 */
public class Whatfix_1 {

    String[] memory = new String[10];
    // 4 files 5 records each
    // 10 in memory


    public void  sort( List<String[]> files) {

        List<String[]> largeList = new ArrayList<String[]>();

        for( int i = 0 ; i < files.size()-1 ; i += 2){
            String[] a  = files.get(i);
            String[] b  = files.get(i+1);

            int m_ptr = 0;
            int a_ptr = 0;
            int b_ptr = 0;

            for( int j = 0 ; j < a.length ; j++ ){
                if( a[a_ptr].compareTo(b[b_ptr]) >= 0 ){
                    memory[m_ptr] = a[a_ptr];
                    a_ptr++;
                }
                else {
                    memory[m_ptr] = b[b_ptr];
                    b_ptr++;
                }
            }

            for( int k = 0 ; k < memory.length/2 ; k++ ) {
                a[k] = memory[k];
                b[k] = memory[ memory.length/2 + k];
            }
            largeList.add( a);
            largeList.add( b);
        }

    }

    public static void main(String[] args) {

        String[] page1 = new String[4];
        page1[0] = "dfgd";
        page1[1] = "ghhf";
        page1[2] = "dhgf";
        page1[3] = "fyfg";

        String[] page2 = new String[4];
        page2[0] = "dfgd";
        page2[1] = "ghhf";
        page2[2] = "dhgf";
        page2[3] = "fyfg";

        String[] page3 = new String[4];
        page2[0] = "dfgd";
        page2[1] = "ghhf";
        page2[2] = "dhgf";
        page2[3] = "fyfg";

        String[] page4 = new String[4];
        page2[0] = "dfgd";
        page2[1] = "ghhf";
        page2[2] = "dhgf";
        page2[3] = "fyfg";

        List<String[]> pages = new ArrayList<String[]>();
        pages.add( page1);
        pages.add( page2);
        pages.add( page3);
        pages.add( page4);


        new Whatfix_1().sort(pages);



    }


}
