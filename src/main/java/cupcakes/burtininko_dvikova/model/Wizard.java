package cupcakes.burtininko_dvikova.model;

public class Wizard {
    protected int health;
    protected int mana;
    protected String name;

    public Wizard(String name, int health, int mana) {
        this.name = name;
        this.health = health;
        this.mana = mana;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
