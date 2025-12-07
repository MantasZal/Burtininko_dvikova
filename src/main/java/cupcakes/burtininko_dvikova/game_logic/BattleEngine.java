package cupcakes.burtininko_dvikova.game_logic;
import cupcakes.burtininko_dvikova.model.Character;

import cupcakes.burtininko_dvikova.model.Spell;

public class BattleEngine {
    public static final int INVALID_CHOICE_PENALTY = 10;

    public void castSpell(Spell spell, Character caster, Character target) {
        if (spell == null) {
            return;
        }

        if (!caster.hasEnoughMana(spell.getManaCost())) {
            System.out.println(caster.getName() + " does not have enough mana to cast " + spell.getName());
            caster.spendMana(spell.getManaCost());
            caster.setHealth(0);
            return;
        }

        caster.spendMana(spell.getManaCost());
        target.takeDamage(spell.getDamage());
        caster.heal(spell.getHealing());
    }

    public boolean isAlive(Character character) {
        return character.isAlive();
    }
    public boolean canFight(Character character) {
        return character.isAlive() && character.hasManaLeft();
    }
}
