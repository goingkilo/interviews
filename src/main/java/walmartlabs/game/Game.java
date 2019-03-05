package walmartlabs.game;

public class Game {

    GameState gameState;
    GameWorld world;

    public Game() {
        gameState = GameState.NOT_STARTED;
        world = new GameWorld(100);
    }

    public void gameLoop(Game game){
        while( gameState == GameState.PLAYING){
            world.update(game);
        }
    }

}
