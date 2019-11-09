
package translator.infrastructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "responseData",
    "quotaFinished",
    "mtLangSupported",
    "responseDetails",
    "responseStatus",
    "responderId",
    "exception_code",
    "matches"
})
public class MyMemoryResponse {

    @JsonProperty("responseData")
    private ResponseData responseData;
    @JsonProperty("quotaFinished")
    private Boolean quotaFinished;
    @JsonProperty("mtLangSupported")
    private Object mtLangSupported;
    @JsonProperty("responseDetails")
    private String responseDetails;
    @JsonProperty("responseStatus")
    private Integer responseStatus;
    @JsonProperty("responderId")
    private String responderId;
    @JsonProperty("exception_code")
    private Object exceptionCode;
    @JsonProperty("matches")
    private List<Match> matches = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("responseData")
    public ResponseData getResponseData() {
        return responseData;
    }

    @JsonProperty("responseData")
    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    @JsonProperty("quotaFinished")
    public Boolean getQuotaFinished() {
        return quotaFinished;
    }

    @JsonProperty("quotaFinished")
    public void setQuotaFinished(Boolean quotaFinished) {
        this.quotaFinished = quotaFinished;
    }

    @JsonProperty("mtLangSupported")
    public Object getMtLangSupported() {
        return mtLangSupported;
    }

    @JsonProperty("mtLangSupported")
    public void setMtLangSupported(Object mtLangSupported) {
        this.mtLangSupported = mtLangSupported;
    }

    @JsonProperty("responseDetails")
    public String getResponseDetails() {
        return responseDetails;
    }

    @JsonProperty("responseDetails")
    public void setResponseDetails(String responseDetails) {
        this.responseDetails = responseDetails;
    }

    @JsonProperty("responseStatus")
    public Integer getResponseStatus() {
        return responseStatus;
    }

    @JsonProperty("responseStatus")
    public void setResponseStatus(Integer responseStatus) {
        this.responseStatus = responseStatus;
    }

    @JsonProperty("responderId")
    public String getResponderId() {
        return responderId;
    }

    @JsonProperty("responderId")
    public void setResponderId(String responderId) {
        this.responderId = responderId;
    }

    @JsonProperty("exception_code")
    public Object getExceptionCode() {
        return exceptionCode;
    }

    @JsonProperty("exception_code")
    public void setExceptionCode(Object exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    @JsonProperty("matches")
    public List<Match> getMatches() {
        return matches;
    }

    @JsonProperty("matches")
    public void setMatches(List<Match> matches) {
        this.matches = matches;
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
