package homework.episode2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static HashMap<String, Pokemon> pokemons = new HashMap<>();
    public static Trainer player1 = new Trainer();
    public static Trainer player2 = new Trainer();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        pokemons = readPokemonsJSON(pokemons, "homework/episode2/pokemons.json");
        System.out.print("Player 1 choose your name: ");
        readPlayerName(player1);
        System.out.print("Player 2 choose your name: ");
        readPlayerName(player2);
        printPokemons(pokemons);
        int tmp = player1.getPokemonNumber();
        while (player1.getPokemonNumber() == tmp) {
            catchPokemon(player1, pokemons);
        }
        tmp = player2.getPokemonNumber();
        while (player2.getPokemonNumber() == tmp) {
            catchPokemon(player2, pokemons);
        }
        Battle.doBattle(player1, player2);
    }

    public static HashMap<String, Pokemon> readPokemonsJSON(HashMap<String, Pokemon> pokemons, String path) {
        HashSet<Pokemon> tmp;
        File json = new File(path);
        ObjectMapper mapper = new ObjectMapper();
        try {
            tmp = mapper.readValue(json, new TypeReference<HashSet<Pokemon>>(){});
            for (Pokemon pokemon: tmp) {
                pokemons.put(pokemon.getName(), pokemon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pokemons;
    }

    public static void printPokemons(HashMap<String, Pokemon> pokemons) {
        if (pokemons.size() > 0) {
            for (Map.Entry<String, Pokemon> pokemon: pokemons.entrySet()) {
                System.out.println(pokemon.getValue());
            }
        } else {
            System.out.println("There is no pokemons.");
        }
    }

    public static void readPlayerName(Trainer trainer) {
        try {
            trainer.setName(br.readLine());
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
        }
    }

    public static void catchPokemon(Trainer trainer, HashMap<String, Pokemon> pokemons) {
        System.out.print(trainer.getName() + " pick your pokemon: ");
        try {
            String pokemonName = br.readLine();
            if (pokemons.containsKey(pokemonName)) {
                trainer.catchPokemon(pokemons.get(pokemonName));
            } else {
                System.out.println("No such pokemon.");
            }
        } catch (IOException ioe) {
            System.out.println("IO error trying to read pokemon name!");
        }
    }
}
