package cupcakes.burtininko_dvikova.game_logic;

import cupcakes.burtininko_dvikova.model.Spell;
import cupcakes.burtininko_dvikova.model.Wizard;

import java.util.Scanner;

public class Game {
    private static final String PLAYER_NAME = "Player";
    private static final String OPPONENT_NAME = "Opponent";

    public static void main(String[] args) {
        WizardFactory factory = new WizardFactory();
        Wizard player = factory.createPlayer(PLAYER_NAME);
        Wizard opponent = factory.createPlayer(OPPONENT_NAME);

        AIStrategy aiStrategy = new RandomAIStrategy();
        BattleEngine engine = new BattleEngine();

        Scanner scanner = new Scanner(System.in);

        printInitialStats(player, opponent);

        while (engine.canFight(player) && engine.canFight(opponent))  {
            playerTurn(scanner, engine, player, opponent);
            if (!engine.isAlive(opponent)) {
                break;
            }
            opponentTurn(engine, aiStrategy, player, opponent);
        }

        printWinner(player);
    }

    private static void printInitialStats(Wizard player, Wizard opponent) {
        System.out.println(player.getName() + " has " + player.getHealth() + " health and " + player.getMana() + " mana.");
        System.out.println(opponent.getName() + " has " + opponent.getHealth() + " health and " + opponent.getMana() + " mana.");
        System.out.println("All available spells:\n");
        for (Spell spell : Spell.values()) {
            System.out.println(spell.getNum() + " " + spell.getName() +
                    " - Mana Cost: " + spell.getManaCost() +
                    ", Damage: " + spell.getDamage() +
                    ", Healing: " + spell.getHealing());
        }
    }

    private static void playerTurn(Scanner scanner, BattleEngine engine, Wizard player, Wizard opponent) {
        System.out.println("Your stats: " + player.getHealth() + " health and " + player.getMana() + " mana.");
        System.out.println("Choose your spell by its number:");

        int choice = scanner.nextInt();

        Spell spell = Spell.fromNum(choice).orElse(null);

        if (spell == null) {
            System.out.println("Invalid choice, you lost " + BattleEngine.INVALID_CHOICE_PENALTY + " health.");
            player.setHealth(player.getHealth() - BattleEngine.INVALID_CHOICE_PENALTY);
        } else {
            engine.castSpell(spell, player, opponent);
        }

        System.out.println("Opponent's stats: " + opponent.getHealth() + " health and " + opponent.getMana() + " mana.");
    }

    private static void opponentTurn(BattleEngine engine, AIStrategy aiStrategy, Wizard player, Wizard opponent) {
        System.out.println("Opponent is still alive.");
        System.out.println("Opponent is choosing a spell...");

        Spell aiSpell = aiStrategy.chooseSpell(opponent, player);

        System.out.println("Opponent chose " + aiSpell.getName());
        engine.castSpell(aiSpell, opponent, player);
    }

    private static void printWinner(Wizard player) {
        if (player.isAlive()) {
            System.out.println("Good job you won");
        } else {
            System.out.println("Sorry you lost");
        }
    }
}
