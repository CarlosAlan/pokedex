package mx.com.bankaya.pokedex.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rarity",
    "version"
})
public class VersionDetailDto implements Serializable
{

    @JsonProperty("rarity")
    private Integer rarity;
    @JsonProperty("version")
    private VersionDto version;
    private final static long serialVersionUID = 6303135451642622333L;

    @JsonProperty("rarity")
    public Integer getRarity() {
        return rarity;
    }

    @JsonProperty("rarity")
    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    @JsonProperty("version")
    public VersionDto getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(VersionDto version) {
        this.version = version;
    }

}
