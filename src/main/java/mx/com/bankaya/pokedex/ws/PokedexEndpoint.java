package mx.com.bankaya.pokedex.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import bankaya.test.pokedex_web_service.GetAbilitiesRequest;
import bankaya.test.pokedex_web_service.GetAbilitiesResponse;
import bankaya.test.pokedex_web_service.GetBaseExperienceRequest;
import bankaya.test.pokedex_web_service.GetBaseExperienceResponse;
import bankaya.test.pokedex_web_service.GetHeldItemsRequest;
import bankaya.test.pokedex_web_service.GetHeldItemsResponse;
import bankaya.test.pokedex_web_service.GetIdRequest;
import bankaya.test.pokedex_web_service.GetIdResponse;
import bankaya.test.pokedex_web_service.GetLocationAreaEncountersRequest;
import bankaya.test.pokedex_web_service.GetLocationAreaEncountersResponse;
import bankaya.test.pokedex_web_service.GetNameRequest;
import bankaya.test.pokedex_web_service.GetNameResponse;
import mx.com.bankaya.pokedex.service.PokedexService;

@Endpoint
public class PokedexEndpoint {
	private static final String NAMESPACE_URI = "http://bankaya/test/pokedex-web-service";
	
	@Autowired
	private PokedexService pokedexService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilitiesRequest")
	@ResponsePayload
	public GetAbilitiesResponse getAbilitiesRequest(@RequestPayload GetAbilitiesRequest request) {
		GetAbilitiesResponse response = new GetAbilitiesResponse();
		
		response.getAbilities().addAll(pokedexService.getAbilities(request.getPokemonName(),  new Throwable().getStackTrace()[0].getMethodName()));
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
	@ResponsePayload
	public GetBaseExperienceResponse getBaseExperienceRequest(@RequestPayload GetBaseExperienceRequest request) {
		GetBaseExperienceResponse response = new GetBaseExperienceResponse();
		
		response.setBaseExperience(pokedexService.getBaseExperience(request.getPokemonName(),  new Throwable().getStackTrace()[0].getMethodName()));
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
	@ResponsePayload
	public GetHeldItemsResponse getHeldItemsRequest(@RequestPayload GetHeldItemsRequest request) {
		GetHeldItemsResponse response = new GetHeldItemsResponse();
		
		response.getHeldItems().addAll(pokedexService.getHeldtem(request.getPokemonName(),  new Throwable().getStackTrace()[0].getMethodName()));
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
	@ResponsePayload
	public GetIdResponse getIdRequest(@RequestPayload GetIdRequest request) {
		GetIdResponse response = new GetIdResponse();
		response.setId(pokedexService.getId(request.getPokemonName(),  new Throwable().getStackTrace()[0].getMethodName()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
	@ResponsePayload
	public GetNameResponse getNameRequest(@RequestPayload GetNameRequest request) {
		GetNameResponse response = new GetNameResponse();
		response.setName(pokedexService.getName(request.getPokemonName(),  new Throwable().getStackTrace()[0].getMethodName()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
	@ResponsePayload
	public GetLocationAreaEncountersResponse getLocationAreaEncountersRequest(@RequestPayload GetLocationAreaEncountersRequest request) {
		GetLocationAreaEncountersResponse response = new GetLocationAreaEncountersResponse();
		response.setLocationAreaEncounters(pokedexService.getLocationAreaEncounters(request.getPokemonName(),  new Throwable().getStackTrace()[0].getMethodName()));
		return response;
	}
	
}