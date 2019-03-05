package walmartlabs.game;

import java.util.ArrayList;
import java.util.List;

class GameWorld {

    private int boardSize;
    private List<Player> players;
    private SnakeNLadders snakesNLadders;
    private NextPlayerChooser nextPlayerChooser;
    private Dice dice;


    public GameWorld(int boardSize) {

        this.boardSize = boardSize;

        dice        = new Dice();

        players     = new ArrayList<>();
        players.add( new Player("Player 1"));
        players.add( new Player("Player 2"));

        snakesNLadders     = new SnakeNLadders(boardSize);
        nextPlayerChooser  = new NextPlayerChooser(players.size());
    }

    public void update(Game game){
        if( game.gameState != GameState.PLAYING) {

        }
            Player p = players.get(nextPlayerChooser.nexPlayer());
            int nextPos = snakesNLadders.nextPosition(p.getPos(), p.throwDice(dice));
            p.setPos(nextPos);

    }

}
