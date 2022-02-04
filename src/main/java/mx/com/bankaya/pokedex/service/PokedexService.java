package mx.com.bankaya.pokedex.service;

import java.net.InetAddress;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankaya.test.pokedex_web_service.Ability;
import bankaya.test.pokedex_web_service.HeldItem;
import bankaya.test.pokedex_web_service.Version;
import bankaya.test.pokedex_web_service.VersionDetail;
import mx.com.bankaya.pokedex.client.PokeApiClient;
import mx.com.bankaya.pokedex.dto.AbilityDto;
import mx.com.bankaya.pokedex.dto.HeldItemDto;
import mx.com.bankaya.pokedex.dto.PokedexResponse;
import mx.com.bankaya.pokedex.dto.VersionDetailDto;
import mx.com.bankaya.pokedex.entity.Peticion;
import mx.com.bankaya.pokedex.repository.PeticionRepository;

@Service
public class PokedexService {
	
	@Autowired
	PokeApiClient PokeApiClient;
	
	@Autowired
	PeticionRepository peticionRepository;
	
	public List<Ability> getAbilities(String pokemonName, String method) {
		List<Ability> abilities = new ArrayList<>();
		
		PokedexResponse response = PokeApiClient.getPokemonInformation(pokemonName);
		
		List<AbilityDto> abilitiesFromApi =  response.getAbilities();
		
		for(AbilityDto abilityDto : abilitiesFromApi) {
			Version abilityNode = new Version();
			abilityNode.setName(abilityDto.getAbility().getName());
			abilityNode.setUrl(abilityDto.getAbility().getUrl());
			
			Ability ability = new Ability();
			ability.setAbility(abilityNode);
			ability.setIsHidden(abilityDto.getIsHidden());
			ability.setSlot(abilityDto.getSlot());
			
			abilities.add(ability);
		}
		
		registrarPeticion(method);
		
		return abilities;
	}
	
	public Integer getBaseExperience(String pokemonName, String method) {
		PokedexResponse response = PokeApiClient.getPokemonInformation(pokemonName);
		registrarPeticion(method);
		return response.getBaseExperience();
	}
	
	public List<HeldItem> getHeldtem(String pokemonName, String method) {
		List<HeldItem> heldItems = new ArrayList<>();
		
		PokedexResponse response = PokeApiClient.getPokemonInformation(pokemonName);
		
		List<HeldItemDto> heldItemsFromApi = response.getHeldItems();
		
		for(HeldItemDto heldItemDto: heldItemsFromApi) {
			HeldItem heldItem = new HeldItem();
			
			Version item = new Version();
			item.setName(heldItemDto.getItem().getName());
			item.setUrl(heldItemDto.getItem().getUrl());
			
			List<VersionDetail> versionDetails =  new ArrayList<>();
			for (VersionDetailDto versionDetailDto: heldItemDto.getVersionDetails()) {
				Version version = new Version();
				version.setName(versionDetailDto.getVersion().getName());
				version.setUrl(versionDetailDto.getVersion().getUrl());
				
				VersionDetail versionDetail = new VersionDetail();
				versionDetail.setRarity(versionDetailDto.getRarity());
				versionDetail.setVersion(version);
				
				versionDetails.add(versionDetail);
			}
			
			heldItem.setItem(item);
			heldItem.getVersionDetails().addAll(versionDetails);
			
			heldItems.add(heldItem);
		}
		
		registrarPeticion(method);
		
		return heldItems;
	}
	
	public Integer getId(String pokemonName, String method) {
		PokedexResponse response = PokeApiClient.getPokemonInformation(pokemonName);
		registrarPeticion(method);
		return response.getId();
	}
	
	public String getName(String pokemonName, String method) {
		PokedexResponse response = PokeApiClient.getPokemonInformation(pokemonName);
		registrarPeticion(method);
		return response.getName();
	}
	
	public String getLocationAreaEncounters(String pokemonName, String method) {
		PokedexResponse response = PokeApiClient.getPokemonInformation(pokemonName);
		registrarPeticion(method);
		return response.getLocationAreaEncounters();
	}
	
	private void registrarPeticion(String metodo) {
		
		try {
			Peticion peticion = new Peticion();
			peticion.setIdPeticion(UUID.randomUUID().toString());
			peticion.setFechaPeticion(LocalDate.now());
			peticion.setIpOrigen(InetAddress.getLocalHost().getHostAddress());
			peticion.setMetodo(metodo);
			
			peticionRepository.save(peticion);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
}