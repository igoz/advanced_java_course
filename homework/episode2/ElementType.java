package homework.episode2;

public enum ElementType {
    NORMAL, FIRE, WATER, ELECTRIC;

//    private int id;
//
//    ElementType(int id) {
//        this.id = id;
//    }
    public double calculateEffectiveness(ElementType other) {
        if (this == NORMAL) {
            return 1;
        } else if (this == FIRE) {
            switch (other) {
                case NORMAL:
                    return 1;
                case FIRE:
                    return 0.5;
                case WATER:
                    return 0.5;
                case ELECTRIC:
                    return 1;
            }
        } else if (this == WATER) {
            switch (other) {
                case NORMAL:
                    return 1;
                case FIRE:
                    return 2;
                case WATER:
                    return 0.5;
                case ELECTRIC:
                    return 1;
            }
        } else if (this == ELECTRIC) {
            switch (other) {
                case NORMAL:
                    return 1;
                case FIRE:
                    return 1;
                case WATER:
                    return 2;
                case ELECTRIC:
                    return 0.5;
            }
        }
        return 1;
    }
}
