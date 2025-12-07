import cupcakes.burtininko_dvikova.game_logic.BattleEngine;
import cupcakes.burtininko_dvikova.model.Spell;
import cupcakes.burtininko_dvikova.model.Wizard;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Unit_Tests {
    @Test
    public void fireballReducesOpponentHealthAndCasterMana() {
        Wizard caster = new Wizard("Caster", 100, 100);
        Wizard target = new Wizard("Target", 100, 100);
        BattleEngine engine = new BattleEngine();

        engine.castSpell(Spell.FIREBALL, caster, target);

        assertEquals(100 - Spell.FIREBALL.getManaCost(), caster.getMana());
        assertEquals(100 - Spell.FIREBALL.getDamage(), target.getHealth());
    }
}
