package call.monitor.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class CustomChannelVars {


    @SerializedName("username")
    private String username;

    @SerializedName("accountID")
    private String accountID;

    @SerializedName("accountName")
    private String accountName;

    @SerializedName("callInteractionID")
    private String callInteractionID;

    @SerializedName("presenceID")
    private String presenceID;

    @SerializedName("bridgeID")
    private String bridgeID;

    @SerializedName("ownerID")
    private String ownerID;

    @SerializedName("resourceType")
    private String resourceType;

    @SerializedName("queueID")
    private String queueID;

    @SerializedName("overflowID")
    private String overflowID;

    @SerializedName("memberCallID")
    private String memberCallID;

    @SerializedName("vcGroup")
    private String vcGroup;

    @SerializedName("vcNumber")
    private String vcNumber;

    @SerializedName("applicationZone")
    private String applicationZone;

    @SerializedName("zoneWithAcdc")
    private String zoneWithAcdc;

    @SerializedName("CustomerLevel")
    private String CustomerLevel;

    @SerializedName("serviceVipCode")
    private String serviceVipCode;

    @SerializedName("expertFlag")
    private Boolean expertFlag;

    @SerializedName("expertGroup")
    private String expertGroup;

    @SerializedName("outboundFlags")
    private Boolean outboundFlags;

    @SerializedName("referredBy")
    private String referredBy;

    @SerializedName("referredTo")
    private String referredTo;

    @SerializedName("mediaNames")
    private String mediaNames;

    @SerializedName("mediaRecordings")
    private String mediaRecordings;


}
