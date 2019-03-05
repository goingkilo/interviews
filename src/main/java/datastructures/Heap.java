package  datastructures;

/**
 * Created by kraghunathan on 10/9/18.
 */
public class Heap                                           {

    int[] heap;
    int depth,pos;

    public Heap()                                           {
        heap = new int[32];
                                                            }
    /*
    1                   a                           1                   0
    2               b        c                      2                   1 2
    3            d    e    f    g                   4                   3 4 5 6
    4        h     i j  k l  m n  o                 8 elts              7 8 9 10


    num_elts per depth = Math.pow( 2, depth-1)
    depth   #elts
    1       1
    2       2
    3       4
    4       8

    nth elt = Math.pow(2,depth-1) -1 + pos
            = sum terms till

    a . al ar . all alr arl arr. alll allr alrl alrr arll arlr arrl arrr.
    0   1  2     3   4   5   6    7    8    9    10   11   12   13   14
    1. 2. 4. 8
    each segment contains Math.pow(2,depth-1) elements
    number of elements to cross to get to the nth segment =

    thing to remember about heap is that you can add things like an array, at the end,
    for every elt at i, its parent is at i/2.
    */

    void add(int i)                                         {
        if( heap.length == 0 )                              {
            pos = 0;
            heap[0] = i;
            depth ++;
            return;
                                                            }
        if( levelComplete())                                {
            depth ++;
            pos = 0;
                                                            }
        else
                                                            {

                                                            }
        int index = sumTillPreviousDepths() + pos;
        heap[index] = i;
        pos ++;

                                                            }

    private boolean levelComplete()                         {
        return pos == Math.pow(2,depth);
                                                            }

    private int getNextArrayIndex(){
        return sumTillPreviousDepths() + pos;
                                                            }

    private int sumTillPreviousDepths()                     {
        //formula is a(1-r^n)/1-r
        // a = 1 r = 2 n = depth-1
        return (int)Math.pow(2,depth-1) -1;
                                                            }


    public static void main(String[] args)                  {
        Heap h = new Heap();
        System.out.println(h.sumTillPreviousDepths());
        h.add(1);
        System.out.println(h.sumTillPreviousDepths());
                                                            }
                                                            }