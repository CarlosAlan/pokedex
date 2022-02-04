package mx.com.bankaya.pokedex.dto;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "item",
    "version_details"
})
public class HeldItemDto implements Serializable {
    private final static long serialVersionUID = -8247053628348397816L;

    @JsonProperty("item")
    private ItemDto item;
    @JsonProperty("version_details")
    private List<VersionDetailDto> versionDetails = null;

    @JsonProperty("item")
    public ItemDto getItem() {
        return item;
    }

    @JsonProperty("item")
    public void setItem(ItemDto item) {
        this.item = item;
    }

    @JsonProperty("version_details")
    public List<VersionDetailDto> getVersionDetails() {
        return versionDetails;
    }

    @JsonProperty("version_details")
    public void setVersionDetails(List<VersionDetailDto> versionDetails) {
        this.versionDetails = versionDetails;
    }

}
