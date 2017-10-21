package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

/**
 * Created by duyanh on 10/21/17.
 */
public class EnemySpawner extends GameObject {

    FrameCounter frameCounter = new FrameCounter(120);
    Random rdm = new Random();

    @Override
    public void run() {
        if(frameCounter.run()){
            frameCounter.reset();
            spawn();
        }
    }

    private void spawn() {
        Enemy enemy = new Enemy();
//        enemy.y = 10;
        enemy.position.y = -15;
        enemy.position.x = rdm.nextInt(384);
        GameObject.add(enemy);
    }
}
