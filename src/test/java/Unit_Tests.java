import cupcakes.burtininko_dvikova.game_logic.BattleEngine;
import cupcakes.burtininko_dvikova.model.Spell;
import cupcakes.burtininko_dvikova.model.Wizard;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @Test
    public void healIncreasesCasterHealthAndReducesMana() {
        Wizard caster = new Wizard("Caster", 50, 100);
        Wizard target = new Wizard("Target", 100, 100);
        BattleEngine engine = new BattleEngine();

        engine.castSpell(Spell.HEAL, caster, target);

        assertEquals(65, caster.getHealth());
        assertEquals(92, caster.getMana());
        assertEquals(100, target.getHealth());
    }

    @Test
    public void castingSpellWithoutEnoughManaSetsManaToZero() {
        Wizard caster = new Wizard("Caster", 100, 5);
        Wizard target = new Wizard("Target", 100, 100);
        BattleEngine engine = new BattleEngine();

        engine.castSpell(Spell.FIREBALL, caster, target);

        assertEquals(-5, caster.getMana());
        assertEquals(100, target.getHealth());
    }

    @Test
    public void canFightReturnsTrueOnlyWhenAliveAndHasMana() {
        BattleEngine engine = new BattleEngine();

        Wizard ok = new Wizard("OK", 100, 10);
        Wizard noHealth = new Wizard("Dead", 0, 50);
        Wizard noMana = new Wizard("Empty", 100, 0);

        assertTrue(engine.canFight(ok));
        assertFalse(engine.canFight(noHealth));
        assertFalse(engine.canFight(noMana));
    }
    @Test
    public void spellFromNumReturnsCorrectSpell() {
        assertTrue(Spell.fromNum(1).isPresent());
        assertEquals(Spell.FIREBALL, Spell.fromNum(1).get());

        assertTrue(Spell.fromNum(2).isPresent());
        assertEquals(Spell.HEAL, Spell.fromNum(2).get());

        assertFalse(Spell.fromNum(999).isPresent());
    }
    @Test
    public void characterDiesWhenHealthBelowOrEqualZero() {
        Wizard wizard = new Wizard("Test", 5, 100);
        wizard.takeDamage(10);

        assertFalse(wizard.isAlive());
    }
}

