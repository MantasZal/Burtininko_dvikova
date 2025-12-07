package cupcakes.burtininko_dvikova.model;

public abstract class Character {
    private String name;
    private int health;
    private int mana;

    public Character(String name, int health, int mana) {
        this.name = name;
        this.health = health;
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public void takeDamage(int amount) {
        if (amount <= 0) return;
        this.health -= amount;
    }

    public void heal(int amount) {
        if (amount <= 0) return;
        this.health += amount;
    }

    public void spendMana(int amount) {
        if (amount <= 0) return;
        this.mana -= amount;
    }

    public boolean hasEnoughMana(int amount) {
        return mana >= amount;
    }

    public boolean isAlive() {
        return health > 0;
    }
    public boolean hasManaLeft() {
        return mana > 0;
    }
}
