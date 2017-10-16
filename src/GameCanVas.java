import touhou.Enemies;
import touhou.EnemiesSpell;
import touhou.Player;
import touhou.PlayerSpell;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_X;

/**
 *  int playerX, playerY
 *  boolean rightPressed, leftPressed, upPressed, downPressed
 *  final int SPEED
 *  void keyPressed, void keyRelease
 *
 */
public class GameCanVas extends JPanel{

    BufferedImage background;


    Player player = new Player();
    Enemies enemies = new Enemies();
//    PlayerSpell playerSpell; // = null
    ArrayList<PlayerSpell> spells = new ArrayList<>();

    ArrayList<EnemiesSpell> enemSpells = new ArrayList<>();



    int backGroundX = 0;
    int backGroundY = -2500;





    BufferedImage backBuffer;
    Graphics backGraphics;


    final int backGroundSPEED = 3;

    public GameCanVas(){
        //0. CREATE BACK BUFFER
        //RGB không có màu trong suốt -> dùng ARGB mới có trong suốt
        backBuffer = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);

        //lấy bút vẽ của backBuffer
        backGraphics = backBuffer.getGraphics();


        //1. Load Background
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));






        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void render(){
        //1. Draw everything on back buffer

        backGraphics.drawImage(background,backGroundX,backGroundY,null);

        player.render(backGraphics);

        for(PlayerSpell spell: spells){
            spell.render(backGraphics);
        }

        enemies.render(backGraphics);
//
//        for(EnemiesSpell spell: enemSpells){
//            spell.render(backGraphics);
//        }


        //2. Call repaint

        repaint();
    }

    public void keyPressed(KeyEvent e){
        player.keyPressed(e);



//        playerSpell.KeyPressed(e);
    }

    public void keyReleased(KeyEvent e){
        player.keyReleased(e);


//        playerSpell.KeyReleased(e);
    }

    public void run(){
        player.run();
        enemies.run();

        player.shoot(spells);

        for(PlayerSpell spell : spells){
            spell.run();
        }

        enemies.shoot(enemSpells);

        for(EnemiesSpell spell : enemSpells){
            spell.run();
        }



    }

    //2. Draw Background


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer,0,0,null);
    }



    public void runBackground(){
        int vy = 0;

        if(backGroundY < 100){
            vy += backGroundSPEED;
//            System.out.println("vy = 3");
        }
        backGroundY += vy;
    }






}
