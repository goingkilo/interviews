package walmartlabs.game;

public class NextPlayerChooser {
    int player = -1, playerCount;

    public NextPlayerChooser(int playerCount) {
        this.playerCount = playerCount;
    }

    public int nexPlayer(){
        player += 1;
        return player % playerCount;
    }
}
