package homework.episode2;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private final int MAX_NUMBER_OF_POKEMONS = 6;
    private String name;
    private int pokemonNumber;
    private List<Pokemon> pokemons;

    public Trainer(String name, int pokemonNumber, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemonNumber = pokemonNumber;
        this.pokemons = pokemons;
    }

    public Trainer() {
        this.name = "";
        this.pokemonNumber = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPokemonNumber() {
        return pokemonNumber;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void catchPokemon(Pokemon pokemon) {
        if (pokemonNumber <= MAX_NUMBER_OF_POKEMONS) {
            pokemons.add(pokemon);
            pokemonNumber++;
        } else {
            System.out.println(name + " has max number of pokemons.");
        }
    }

    public void challenge(Trainer other) {

    }

    public void acceptChallenge(Trainer other) {

    }
}
