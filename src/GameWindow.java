import touhou.inputs.InputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by duyanh on 10/11/17.
 */
public class GameWindow extends JFrame{
    GameCanVas canvas;

    long lastTimeUpdate;

    public GameWindow(){
        this.setSize(800,600);

//        this.setBackground(Color.BLACK);

        this.canvas = new GameCanVas();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setResizable(false);
       // this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                InputManager.instance.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                InputManager.instance.keyReleased(e);
            }
        });

        this.setContentPane(this.canvas);
        this.setVisible(true);
        lastTimeUpdate = System.nanoTime();


    }
    /**
     * fps = 60 (frame per second) -> delta t = 1/60 = 17ms
     */
    public void gameLoop(){
        while(true){

                long currentTime = System.nanoTime();

                if(currentTime - lastTimeUpdate >= 17000000){
                    canvas.runBackground();

                    canvas.run();
                    canvas.render();
                    lastTimeUpdate = currentTime;
                }



        }
    }


}
