package pacstar;

import java.util.Map;

public class World {

    private Map<GameState,Screen> screens;

    public GameState update(Tick tick) {
        return null;
    }

    public Screen getScreen(GameState state){
        return null;
    }

    public void update(char key) {
    }
}
