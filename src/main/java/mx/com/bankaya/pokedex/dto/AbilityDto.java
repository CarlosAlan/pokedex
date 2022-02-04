package mx.com.bankaya.pokedex.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ability",
    "is_hidden",
    "slot"
})
public class AbilityDto implements Serializable {
    private final static long serialVersionUID = -7642927529245894800L;

    @JsonProperty("ability")
    private VersionDto ability;
    @JsonProperty("is_hidden")
    private Boolean isHidden;
    @JsonProperty("slot")
    private Integer slot;

    @JsonProperty("ability")
    public VersionDto getAbility() {
        return ability;
    }

    @JsonProperty("ability")
    public void setAbility(VersionDto ability) {
        this.ability = ability;
    }

    @JsonProperty("is_hidden")
    public Boolean getIsHidden() {
        return isHidden;
    }

    @JsonProperty("is_hidden")
    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    @JsonProperty("slot")
    public Integer getSlot() {
        return slot;
    }

    @JsonProperty("slot")
    public void setSlot(Integer slot) {
        this.slot = slot;
    }

}
