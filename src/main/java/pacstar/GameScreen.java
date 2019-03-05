//package pacstar;
//
//import processing.core.PApplet;
//
//public class GameScreen extends PApplet {
//
//    World world;
//
//    public GameScreen(World world) {
//        this.world = world;
//    }
//
//    @Override
//    public void setup(){
//        size(640,640);
//        background(254);
//
//    }
//
//    @Override
//    public void draw(){
//    }
//
//    @Override
//    public void mouseClicked(){
//
//    }
//
//
//    @Override
//    public void keyPressed() {
//        if( key == CODED) {
//            world.update( key);
//
//            }
//        }
//        else if( key == TAB ){
//            world.getSmiley().stop();//println("stop");
//        }
//        else if( key == 'r' ){
//            state = gameState.Paused;
//            world  = new World(this);
//            state = gameState.Running;
//        }
//    }
//    }
//}
