package homework.episode2;

public class Move {
    private String name;
    private int damage;
    private ElementType elementType;

    public int getCost() {
        return cost;
    }

    private int cost;

    public Move(String name, int damage, ElementType elementType, int cost) {
        this.name = name;
        this.damage = damage;
        this.elementType = elementType;
        this.cost = cost;
    }

    public Move(){
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public ElementType getElementType() {
        return elementType;
    }

    @Override
    public String toString() {
        String delim = "        ";
        return delim + name + ": \n" + delim + "damage: " + damage + "\n" +
                delim + "element: " + elementType + "\n";
    }
}
