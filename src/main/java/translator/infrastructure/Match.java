
package translator.infrastructure;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "segment",
    "translation",
    "quality",
    "reference",
    "usage-count",
    "subject",
    "created-by",
    "last-updated-by",
    "create-date",
    "last-update-date",
    "match"
})
public class Match {

    @JsonProperty("id")
    private String id;
    @JsonProperty("segment")
    private String segment;
    @JsonProperty("translation")
    private String translation;
    @JsonProperty("quality")
    private String quality;
    @JsonProperty("reference")
    private Object reference;
    @JsonProperty("usage-count")
    private Integer usageCount;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("created-by")
    private String createdBy;
    @JsonProperty("last-updated-by")
    private String lastUpdatedBy;
    @JsonProperty("create-date")
    private String createDate;
    @JsonProperty("last-update-date")
    private String lastUpdateDate;
    @JsonProperty("match")
    private Integer match;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("segment")
    public String getSegment() {
        return segment;
    }

    @JsonProperty("segment")
    public void setSegment(String segment) {
        this.segment = segment;
    }

    @JsonProperty("translation")
    public String getTranslation() {
        return translation;
    }

    @JsonProperty("translation")
    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @JsonProperty("quality")
    public String getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(String quality) {
        this.quality = quality;
    }

    @JsonProperty("reference")
    public Object getReference() {
        return reference;
    }

    @JsonProperty("reference")
    public void setReference(Object reference) {
        this.reference = reference;
    }

    @JsonProperty("usage-count")
    public Integer getUsageCount() {
        return usageCount;
    }

    @JsonProperty("usage-count")
    public void setUsageCount(Integer usageCount) {
        this.usageCount = usageCount;
    }

    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonProperty("created-by")
    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("created-by")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("last-updated-by")
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    @JsonProperty("last-updated-by")
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @JsonProperty("create-date")
    public String getCreateDate() {
        return createDate;
    }

    @JsonProperty("create-date")
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @JsonProperty("last-update-date")
    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    @JsonProperty("last-update-date")
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @JsonProperty("match")
    public Integer getMatch() {
        return match;
    }

    @JsonProperty("match")
    public void setMatch(Integer match) {
        this.match = match;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
