import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by duyanh on 10/11/17.
 */
public class GameWindow extends JFrame{
    GameCanVas canvas;
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

        this.setContentPane(this.canvas);
        this.setVisible(true);


    }


}
