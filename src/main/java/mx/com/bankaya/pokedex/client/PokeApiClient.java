package mx.com.bankaya.pokedex.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import mx.com.bankaya.pokedex.dto.PokedexResponse;

@Component
public class PokeApiClient {
	
	private String baseEndpoint = "https://pokeapi.co/api/v2/pokemon/{pokemonName}";

	private RestTemplate restTemplate;
	
	public PokedexResponse getPokemonInformation(String pokemonName) {
		restTemplate = new RestTemplate();
		return restTemplate.getForObject(baseEndpoint, PokedexResponse.class, pokemonName);
	}
	
}
