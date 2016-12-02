package homework.episode2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Battle {
    private static Scanner br = new Scanner(new InputStreamReader(System.in));
    private static Pokemon pokemon1 = null;
    private static Pokemon pokemon2 = null;

    public static void doBattle(Trainer trainer1, Trainer trainer2) {
        System.out.println("==== Prepare for a battle! ====");
        System.out.print(trainer1.getName() + " pick your pokemon for a fight: ");
        while (pokemon1 == null) {
            pokemon1 = pickPokemon(trainer1);
        }
        System.out.println(trainer1.getName() + " picked " + pokemon1.getName());
        System.out.print(trainer2.getName() + " pick your pokemon for a fight: ");
        while (pokemon2 == null) {
            pokemon2 = pickPokemon(trainer2);
        }
        System.out.println(trainer2.getName() + " picked " + pokemon2.getName());
        System.out.println("==== Battle begins! ====");
        while (pokemon1.isAlive() && pokemon2.isAlive()) {
            System.out.print(trainer1.getName() + " pick a number of the move: ");
            pokemon1.showMovesWithNumber();
            Move tmp1 = pickMove(pokemon1.getMoves());
            while (tmp1 == null) {
                tmp1 = pickMove(pokemon1.getMoves());
            }
            pokemon1.doAttack(pokemon2, tmp1);

            System.out.print(trainer2.getName() + " pick a number of the move: ");
            pokemon2.showMovesWithNumber();
            Move tmp2 = pickMove(pokemon2.getMoves());
            while (tmp2 == null) {
                tmp2 = pickMove(pokemon2.getMoves());
            }
            pokemon2.doAttack(pokemon1, tmp2);
        }

        if (!pokemon1.isAlive()) {
            System.out.println(trainer2.getName() + " won!");
        } else {
            System.out.println(trainer1.getName() + " won!");
        }
    }

    public static Pokemon pickPokemon(Trainer trainer) {
        String pokemonName = br.nextLine();
        for (Pokemon pokemon: trainer.getPokemons()) {
            if (pokemonName.equals(pokemon.getName())) {
                return pokemon;
            }
        }
        System.out.println("No such pokemon. Try again.");
        return null;
    }

    public static Move pickMove(List<Move> moves) {
        int number = br.nextInt();
        if (number < moves.size() && number >= 0) {
            return moves.get(number);
        }
        System.out.println("No such move.");
        return null;
    }
}
