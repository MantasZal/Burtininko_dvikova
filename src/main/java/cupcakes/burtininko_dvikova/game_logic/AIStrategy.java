package cupcakes.burtininko_dvikova.game_logic;
import cupcakes.burtininko_dvikova.model.Character;
import cupcakes.burtininko_dvikova.model.Spell;

public interface AIStrategy {
    Spell chooseSpell(Character self, Character opponent);
}
