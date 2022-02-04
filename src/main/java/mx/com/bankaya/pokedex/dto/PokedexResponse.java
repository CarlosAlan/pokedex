package mx.com.bankaya.pokedex.dto;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "abilities",
    "base_experience",
    "held_items",
    "id",
    "name",
    "location_area_encounters"
})
public class PokedexResponse implements Serializable {

    @JsonProperty("abilities")
    private List<AbilityDto> abilities = null;
    @JsonProperty("base_experience")
    private Integer baseExperience;
    @JsonProperty("held_items")
    private List<HeldItemDto> heldItems = null;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("location_area_encounters")
    private String locationAreaEncounters;
    private final static long serialVersionUID = -8040616517165242340L;

    @JsonProperty("abilities")
    public List<AbilityDto> getAbilities() {
        return abilities;
    }

    @JsonProperty("abilities")
    public void setAbilities(List<AbilityDto> abilities) {
        this.abilities = abilities;
    }

    @JsonProperty("base_experience")
    public Integer getBaseExperience() {
        return baseExperience;
    }

    @JsonProperty("base_experience")
    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }

    @JsonProperty("held_items")
    public List<HeldItemDto> getHeldItems() {
        return heldItems;
    }

    @JsonProperty("held_items")
    public void setHeldItems(List<HeldItemDto> heldItems) {
        this.heldItems = heldItems;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("location_area_encounters")
    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    @JsonProperty("location_area_encounters")
    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

}
