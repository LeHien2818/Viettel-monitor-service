package call.monitor.app.model;

import java.io.Serial;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString

public class CallEvent {
    @SerializedName("eventName")
    private String eventName;

    @SerializedName("callID")
    private String callID;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("accountName")
    private String accountName;

    @SerializedName("interactionId")
    private String interactionId;

    @SerializedName("originationCallID")
    private String originationCallID;

    @SerializedName("presenceID")
    private String presenceID;

    @SerializedName("bridgeId")
    private String bridgeId;

    @SerializedName("otherLegCallID")
    private String otherLegCallID;

    @SerializedName("otherLegDirection")
    private String otherLegDirection;

    @SerializedName("otherLegDestinationNumber")
    private String otherLegDestinationNumber;

    @SerializedName("callerIDName")
    private String callerIDName;

    @SerializedName("callerIDNumber")
    private String callerIDNumber;

    @SerializedName("from")
    private String from;

    @SerializedName("fromUri")
    private String fromUri;

    @SerializedName("to")
    private String to;

    @SerializedName("dialedNumber")
    private String dialedNumber;

    @SerializedName("request")
    private String request;

    @SerializedName("requestNumber")
    private String requestNumber;

    @SerializedName("calleeIDNumber")
    private String calleeIDNumber;

    @SerializedName("toUri")
    private String toUri;

    @SerializedName("callDirection")
    private String callDirection;

    @SerializedName("channelCreatedTimeMs")
    private Long channelCreatedTimeMs;

    @SerializedName("unixTimeMs")
    private Long unixTimeMs;
    
    @SerializedName("ownerId")
    private String ownerId;

    @SerializedName("channelLoopbackLeg")
    private String channelLoopbackLeg;

    @SerializedName("channelLoopbackOtherLegID")
    private String channelLoopbackOtherLegID;

    @SerializedName("cavs")
    private JSONObject cavs; // Assuming this is a JSON object for custom audio/video variables
    
    @SerializedName("cshs")
    private JSONObject cshs;

    @SerializedName("node")
    private String node;

    @SerializedName("sipHangupDisposition")
    private String sipHangupDisposition;

    @SerializedName("hangupCode")
    private String hangupCode;

    @SerializedName("hangupCause")
    private String hangupCause;

    @SerializedName("switchNodename")
    private String switchNodename;

    @SerializedName("smartRouting")
    private Boolean smartRouting = false;

    @SerializedName("smartRoutingExit")
    private Boolean smartRoutingExit = false;

    @SerializedName("IVRCallId")
    private String IVRCallId;

    @SerializedName("IVRCallRequestNumber")
    private String IVRCallRequestNumber;

    @SerializedName("icvs")
    private JSONObject icvs;

    @SerializedName("ccvs")
    private CustomChannelVars ccvs; // Assuming this is a class that holds custom channel variables
    public boolean isSmartRouting() {
        return this.smartRouting;
    }
    public boolean isSmartRoutingExit() {
        return this.smartRoutingExit;
    }
    public boolean isCreateEvent() {
        
        if (this.eventName == null) return false;
        return this.eventName.equals("CHANNEL_CREATE");
        
    }
    public boolean isAnswerEvent() {
        if (this.eventName == null) return false;
        return this.eventName.equals("CHANNEL_ANSWER");
    }
    public boolean isBridgeEvent() {
        if (this.eventName == null) return false;
        return this.eventName.equals("CHANNEL_BRIDGE");
    }
    public boolean isUnbridgeEvent() {
        if (this.eventName == null) return false;
        return this.eventName.equals("CHANNEL_UNBRIDGE");
    }
    public boolean isChannelQueueEvent() {
        if (this.eventName == null) return false;
        return this.eventName.equals("CHANNEL_QUEUE");
    }
    public boolean isDestroyEvent() {
        if (this.eventName == null) return false;
        return this.eventName.equals("CHANNEL_DESTROY");
    }
    public boolean isHoldEvent() {
        return false;
    }
    public boolean isUnholdEvent() {
        return false;
    }
    public boolean isTransferorEvent() {
        return false;
    }
    public boolean isTransfereeEvent() {
        return false;
    }

    public CallEvent copy() {
        CallEvent copy = new CallEvent();
        copy.eventName = this.eventName;
        copy.callID = this.callID;
        copy.accountId = this.accountId;
        copy.accountName = this.accountName;
        copy.interactionId = this.interactionId;
        copy.originationCallID = this.originationCallID;
        copy.presenceID = this.presenceID;
        copy.bridgeId = this.bridgeId;
        copy.otherLegCallID = this.otherLegCallID;
        copy.otherLegDirection = this.otherLegDirection;
        copy.otherLegDestinationNumber = this.otherLegDestinationNumber;
        copy.callerIDName = this.callerIDName;
        copy.callerIDNumber = this.callerIDNumber;
        copy.from = this.from;
        copy.fromUri = this.fromUri;
        copy.to = this.to;
        copy.dialedNumber = this.dialedNumber;
        copy.request = this.request;
        copy.requestNumber = this.requestNumber;
        copy.calleeIDNumber = this.calleeIDNumber;
        copy.toUri = this.toUri;
        copy.callDirection = this.callDirection;
        copy.channelCreatedTimeMs = this.channelCreatedTimeMs;
        copy.unixTimeMs = this.unixTimeMs;
        copy.ownerId = this.ownerId;
        copy.channelLoopbackLeg = this.channelLoopbackLeg;
        copy.channelLoopbackOtherLegID = this.channelLoopbackOtherLegID;
        if (this.cavs != null) {
            copy.cavs = new JSONObject(this.cavs.toString());
        }
        if (this.cshs != null) {
            copy.cshs = new JSONObject(this.cshs.toString());
        }
        copy.node = this.node;
        copy.sipHangupDisposition = this.sipHangupDisposition;
        copy.hangupCode = this.hangupCode;
        copy.hangupCause = this.hangupCause;
        copy.switchNodename = this.switchNodename;
        
        if (this.icvs != null) {
            copy.icvs = new JSONObject(this.icvs.toString());
        }
        
        if (this.ccvs != null) {
            CustomChannelVars ccvsCopy = new CustomChannelVars();
            ccvsCopy.setUsername(this.ccvs.getUsername());
            ccvsCopy.setAccountID(this.ccvs.getAccountID());
            
        }

        return copy;
    }
}
