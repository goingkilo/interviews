package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Interval {

    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        sb.append("start=").append(start);
        sb.append(",end=").append(end);
        sb.append(']');
        return sb.toString();
    }

    public void go(List<Interval> intervals, Interval newInterval) {
        Stack<Interval> stack = new Stack<>();

        int newStart = newInterval.start;
        int newEnd  = newInterval.end;

        for( Interval iv : intervals){

            if( !stack.empty()){
                Interval i = stack.peek();

                if(i.end < newInterval.start ){
                    stack.push(iv);
                }

                if ( i.start > newInterval.start){
                    i.start = newInterval.start;
                }
                else if (i.end < newInterval.end){
                    i.end = newInterval.end;
                }

                if(i.end < iv.start ){
                    stack.push(iv);
                }
            }
            else {
                stack.push(iv);
            }

        }
        stack.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Interval  i  = new Interval();
        List<Interval> l = new ArrayList<>();
        //1
//        l.add( new Interval(1,3));
//        l.add( new Interval(6,9));
//        i.go( l, new Interval(2,5));

        //2
        //[1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9]
        l.add( new Interval(1,2));
        l.add( new Interval(3,5));
        l.add( new Interval(6,7));
        l.add( new Interval(8,10));
        l.add( new Interval(12,16));

        i.go( l, new Interval(4,9));
    }

}
