package cupcakes.burtininko_dvikova.game_logic;

import cupcakes.burtininko_dvikova.model.Spell;
import cupcakes.burtininko_dvikova.model.Wizard;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {


    public static void main(String[] args) {
        Wizard player = new Wizard("Player", 100, 100);
        Wizard opponent= new Wizard("Opponent", 100, 100);
        Scanner scanner = new Scanner(System.in);

        System.out.println(player.getName() + " has " + player.getHealth() + " health and " + player.getMana() + " mana.");
        System.out.println(opponent.getName() + " has " + opponent.getHealth() + " health and " + opponent.getMana() + " mana.");
        System.out.println("All available spells:\n");

        while(isAlive(player) && isAlive(opponent)) {
            System.out.println("Your stats: " + player.getHealth() + " health and " + player.getMana() + " mana.");
            System.out.println("Your turn to choose a spell:");
            for(Spell spell : Spell.values())
            {
                System.out.println(spell.getNum()+ " "+ spell.getName() + " - Mana Cost: " + spell.getManaCost() + ", Damage: " + spell.getDamage() + ", Healing: " + spell.getHealing());
            }

            System.out.println("Choose your spell by its number:");
            int choice = scanner.nextInt();
            if (choice == 1) {
                calculateDamage(Spell.values()[0], player, opponent);
            } else if (choice == 2) {
                calculateDamage(Spell.values()[1], player, opponent);
            } else if (choice == 3) {
                calculateDamage(Spell.values()[2], player, opponent);
            } else {
                System.out.println("Invalid choice you lost 10 off your health.");
            player.setHealth(player.getHealth() - 10);
            }
            System.out.println("Opponent's stats: " + opponent.getHealth() + " health and " + opponent.getMana() + " mana.");
            if(isAlive(opponent)) {
                System.out.println("Opponent is still alive.");
            } else {
                break;
            }
            System.out.println("Opponent is choosing a spell...");
            int aiChoice = aiMove();
            System.out.println("Opponent chose " + Spell.values()[aiChoice].getName());
            calculateDamage(Spell.values()[aiChoice], opponent, player);



        }
        if (isAlive(player)) {
            System.out.println("Good job you won");
        } else {
            System.out.println("Sorry you lost");
        }

    }
    public static void calculateDamage(Spell spell, Wizard caster, Wizard target) {
        if (caster.getMana() < spell.getManaCost()) {
            System.out.println(caster.getName() + " does not have enough mana to cast " + spell.getName());

        }
        caster.setMana(caster.getMana() - spell.getManaCost());
        target.setHealth(target.getHealth() - spell.getDamage());
        caster.setHealth(caster.getHealth() + spell.getHealing());
    }

    public static boolean isAlive(Wizard wizard) {
        return wizard.getHealth() > 0;
    }
    public static int aiMove(){
        Random random = new Random();
        return random.nextInt(3);

    }
}
