package pacstar;

import java.util.Scanner;

public class Game {

    private String message = "If you are reading this, it's time to change course....";

    private enum GAME_STATE { READY,RUNNING,PAUSED,OVER};
    GAME_STATE state = GAME_STATE.READY;

    Scanner sc = new Scanner(System.in);
    public void play(){
        state = GAME_STATE.RUNNING;
        while(state == GAME_STATE.RUNNING){

            System.out.println(message);
            String a = sc.next();
            updateWorld(a.trim().toLowerCase());
        }

    }

    private void updateWorld(String a) {
        switch(a){
            case "quit":
                state = GAME_STATE.OVER;
                return;
            case "pause":
                state = GAME_STATE.PAUSED;
        }
        message = "new message ";

    }

}
