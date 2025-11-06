package cupcakes.burtininko_dvikova.game_logic;

import cupcakes.burtininko_dvikova.model.Spell;
import cupcakes.burtininko_dvikova.model.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {


    public static void main(String[] args) {
        Wizard player = new Wizard("Player", 100, 100);
        Wizard opponent= new Wizard("Opponent", 100, 100);
        Scanner scanner = new Scanner(System.in);

        System.out.println(player.getName() + " has " + player.getHealth() + " health and " + player.getMana() + " mana.");
        System.out.println(opponent.getName() + " has " + opponent.getHealth() + " health and " + opponent.getMana() + " mana.");
        System.out.println("All available spells:\n");
        int i =0;
        for(Spell spell : Spell.values())
        {
            i++;
            System.out.println(spell.getNum()+ " "+ spell.getName() + " - Mana Cost: " + spell.getManaCost() + ", Damage: " + spell.getDamage() + ", Healing: " + spell.getHealing());
        }
        while(isAlive(player) && isAlive(opponent)) {

            System.out.println("Choose your spell by its number:");
            int choice = scanner.nextInt();
            if (choice == 1) {
                Spell spell = Spell.values()[0];
                System.out.println("You cast " + spell.getName() + "!");
            } else if (choice == 2) {
                Spell spell = Spell.values()[1];
                System.out.println("You cast " + spell.getName() + "!");
            } else if (choice == 3) {
                Spell spell = Spell.values()[2];
                System.out.println("You cast " + spell.getName() + "!");
            } else {
                System.out.println("Invalid choice you lost 10 off your health.");
//            player.setHealth(player.getHealth() - 10); veliau padryt
            }
        }
        if (isAlive(player)) {
            System.out.println("Good job you won");
        } else {
            System.out.println("Sorry you lost");
        }

    }
    public int calculateDamage(Spell spell, Wizard caster, Wizard target) {
        if (caster.getMana() < spell.getManaCost()) {
            System.out.println(caster.getName() + " does not have enough mana to cast " + spell.getName() + "! you lost 5 off your health.");
//            caster.setHealth(caster.getHealth() - 5); veliau padryt
            return 0;
        }
        caster.setMana(caster.getMana() - spell.getManaCost());
        target.setHealth(target.getHealth() - spell.getDamage());
        caster.setHealth(caster.getHealth() + spell.getHealing());
        return spell.getDamage();
    }

    public static boolean isAlive(Wizard wizard) {
        return wizard.getHealth() > 0;
    }
}
