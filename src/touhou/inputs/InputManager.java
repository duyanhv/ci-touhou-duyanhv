package touhou.inputs;

import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_X;

/**
 * Created by duyanh on 10/25/17.
 */
public class InputManager {
    // Tracking user input
    // Provide input states for other classes

    public boolean rightPressed;
    public boolean leftPressed;
    public boolean upPressed;
    public boolean downPressed;
    public boolean xPressed;

    // Singleton: cả chương trình chỉ có 1 object
    public static final InputManager instance = new InputManager();

    private InputManager(){

    }

    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = true;

        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = true;


        }

        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = true;

        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = true;
        }

        if(e.getKeyCode() == VK_X){ //KeyEvent.VK_X
            xPressed = true;
        }

    }


    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = false;

        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = false;


        }

        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = false;

        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = false;
        }

        if(e.getKeyCode() == VK_X){
            xPressed = false;
        }
    }

}
