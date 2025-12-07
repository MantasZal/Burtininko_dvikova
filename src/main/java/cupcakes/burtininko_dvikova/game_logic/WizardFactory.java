package cupcakes.burtininko_dvikova.game_logic;

import cupcakes.burtininko_dvikova.model.Wizard;

public class WizardFactory {
    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_MANA = 100;

    public Wizard createPlayer(String name) {
        return new Wizard(name, DEFAULT_HEALTH, DEFAULT_MANA);
    }

    public Wizard createOpponent(String name) {
        return new Wizard(name, DEFAULT_HEALTH, DEFAULT_MANA);
    }
}
