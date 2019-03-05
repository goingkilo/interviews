package walmartlabs.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SnakeNLadders {

    private int boardSize;
    private Map<Integer,Pair> pairs;

    public SnakeNLadders(int boardSize) {
        this.boardSize = boardSize;
        createSnakesAndLadders();
    }

    private void  createSnakesAndLadders() {

        List<Pair> pairs = new ArrayList<>();

        java.util.Random r = new java.util.Random();

        // putting in a set eliminates duplicates
        Set<Integer> uniqueSnakeLadderEndPoints = new HashSet<>();
        while( uniqueSnakeLadderEndPoints.size() < boardSize/3) {

            // we do this two at a time, so we have pairs
            int r1 = r.nextInt(boardSize);
            if( !uniqueSnakeLadderEndPoints.contains(r1) ) {
                uniqueSnakeLadderEndPoints.add(r1);
            }
            int r2 = r.nextInt(boardSize);
            if( !uniqueSnakeLadderEndPoints.contains(r2) ) {
                uniqueSnakeLadderEndPoints.add(r2);
            }
        }
        while( !uniqueSnakeLadderEndPoints.isEmpty()){
            int r1 = uniqueSnakeLadderEndPoints.iterator().next();
            int r2 = uniqueSnakeLadderEndPoints.iterator().next();

            Pair p = new Pair(r1,r2);
            p.setType( r1 > r2 ? Type.SNAKE : Type.LADDER );    //usage of set eliminates case where r1 == r2
            pairs.add(p);
            this.pairs.put(p.getStart(), p);
        }

    }

    public int nextPosition( int cur, int diceThrow) {
        int nextPos = cur + diceThrow;
        if( pairs.containsKey( nextPos)){
            nextPos = pairs.get(nextPos).getEnd();
        }
        return nextPos;
    }


    class Pair {
        int start, end;
        Type type;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getEnd() {
            return end;
        }

        public int getStart() {
            return start;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }
    }

    enum Type { SNAKE, LADDER };

}
