import javax.swing.*;
import java.awt.*;

/**
 * Created by duyanh on 10/11/17.
 */
public class GameWindow extends JFrame{
    GameCanVas canvas;
    public GameWindow(){
        this.setSize(800,600);
        this.setVisible(true);
//        this.setBackground(Color.BLACK);

        this.canvas = new GameCanVas();
        this.setContentPane(this.canvas);

    }
}
