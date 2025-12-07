package cupcakes.burtininko_dvikova.model;

import java.util.Arrays;
import java.util.Optional;

public enum Spell {
    FIREBALL(1,"Fire Ball", 10, 20, 0),
    HEAL(2,"Healing", 8, 0, 15),
    SOUL_Drain(3,"Soul Drain", 12, 15, 5);
    private final int num;
    private final String name;
    private final int manaCost;
    private final int damage;
    private final int healing;

    Spell(int num, String name, int manaCost, int damage, int healing) {
        this.num = num;
        this.name = name;
        this.manaCost = manaCost;
        this.damage = damage;
        this.healing = healing;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealing() {
        return healing;
    }

    public static Optional<Spell> fromNum(int num) {
        return Arrays.stream(values())
                .filter(spell -> spell.getNum() == num)
                .findFirst();
    }
}
