package homework.episode2;

import java.util.List;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Pokemon {
    private String name;
    private int level;
    private int hp;
    private int attack;
    private int defence;
    private ElementType elementType;
    private List<Move> moves = new ArrayList<Move>(4);
    private int stamina = 1000;

    public Pokemon(String name, int level, int hp, int attack,
                   int defence, ElementType elementType, List<Move> moves) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.elementType = elementType;
        this.moves = moves;
    }

    public Pokemon() {
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void showMoves() {
        for (Move move: moves) {
            System.out.println(move.getName() + "\n");
        }
    }

    public void showMovesWithNumber() {
        for (Move move: moves) {
            System.out.print(moves.indexOf(move) + " " + move.getName() + "    ");
        }
    }

    public double doAttack(Pokemon other, Move move) {
        double damage = (2 * this.level + 10) / 250d * (double) this.attack / other.getDefence() * move.getDamage();
        double modifier = this.elementType.calculateEffectiveness(other.getElementType());
        System.out.println(this.name + " dealt " + damage * modifier + " damage to " + other.getName() + ".");
        this.stamina -= move.getCost();
        other.takeDamage(damage * modifier);

        return damage * modifier;
    }

    private void takeDamage(double damage) {
        this.hp -= damage;
    }

    @Override
    public String toString() {
        String delim = "    ";

        return name + ": \n" + delim + "level: " + level +
                delim + "hp: " + hp +
                delim + "attack: " + attack +
                delim + "defence: " + defence +
                delim + "defence: " + defence +
                delim + "stamina: " + stamina +
                delim + "type: " + elementType.toString() + "\n" + delim +
                "moves: "  + "\n" + moves.get(0)  + "\n"  + moves.get(1)  + "\n"
                + moves.get(2)  + "\n"  + moves.get(3)  + "\n";
    }
}
