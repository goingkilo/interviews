package walmartlabs.game;

public class Dice {

    private  java.util.Random r = new java.util.Random(System.currentTimeMillis());

    public int throwDice(){
        return r.nextInt(6);
    }
}
