package touhou.players;

import bases.GameObject;
import touhou.inputs.InputManager;

/**
 * Created by duyanh on 10/25/17.
 */
public class PlayerCastSpell {
    boolean spellDisabled;
    final int COOL_DOWN_TIME = 10;
    int coolDownCount;
    InputManager inputManager = InputManager.instance;

    public void run(Player owner){
        if(spellDisabled){
            coolDownCount++;
            if(coolDownCount >= COOL_DOWN_TIME){
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }

        if(inputManager.xPressed){
            PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
            newSpell.position.set(owner.position.x, owner.position.y-14);


            spellDisabled = true;
        }
    }
}
