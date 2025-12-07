package cupcakes.burtininko_dvikova.game_logic;
import cupcakes.burtininko_dvikova.model.Character;
import cupcakes.burtininko_dvikova.model.Spell;

import java.util.Random;

public class RandomAIStrategy implements AIStrategy {
    private final Random random = new Random();

    @Override
    public Spell chooseSpell(Character self, Character opponent) {
        Spell[] spells = Spell.values();
        int index = random.nextInt(spells.length);
        return spells[index];
    }
}
