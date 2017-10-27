package touhou.enemies;

import bases.GameObject;

/**
 * Created by duyanh on 10/27/17.
 */
public class EnemyCastSpell {

    boolean spellDisabled;
    final int COOL_DOWN_TIME = 40;
    int coolDownCount;

    public void run(Enemy owner) {
        if (spellDisabled) {
            coolDownCount++;
            if (coolDownCount >= COOL_DOWN_TIME) {
                spellDisabled = false;
                coolDownCount = 0;

            }
            return;
        }

        if (coolDownCount < 1) {
            EnemiesSpell enemiesSpell = GameObject.recycle(EnemiesSpell.class);
//            enemiesSpell.x = x + 5;
//
//            enemiesSpell.y = y + 50;
            enemiesSpell.position.set(owner.position.x, owner.position.y);
            GameObject.add(enemiesSpell);
            spellDisabled = true;
        }

    }
}