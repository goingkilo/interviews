package walmartlabs.game;

public class Player {

    int pos;
    String name;

    public Player(String name) {
        this.name = name;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int throwDice(Dice dice){
        return dice.throwDice();
    }
}
