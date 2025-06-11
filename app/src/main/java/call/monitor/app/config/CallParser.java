package call.monitor.app.config;

import org.json.JSONObject;

import call.monitor.app.model.CallEvent;
import call.monitor.app.model.CustomChannelVars;

public class CallParser {
    public static CallEvent parseCallEvent(String jsonString, boolean isSS) {
        CallEvent callEvent = new CallEvent();
        JSONObject jsonData = new JSONObject(jsonString);

        if (isSS) {
            JSONObject rawCustomChannelVars = jsonData.optJSONObject("ccvs");
            CustomChannelVars customChannelVars = new CustomChannelVars();
            // customChannelVars.setAccountID(rawCustomChannelVars.optString("username", null));
            // customChannelVars.setAccountName(rawCustomChannelVars.optString("accountName", null));
            // customChannelVars.setAccountID(rawCustomChannelVars.optString("accountID", null));
            // customChannelVars.setCallInteractionID(rawCustomChannelVars.optString("callInteractionID", null));
            // customChannelVars.setOwnerID(rawCustomChannelVars.optString("ownerID", null));
            // customChannelVars.setQueueID(rawCustomChannelVars.optString("queueID", null));
            // customChannelVars.setOverflowID(rawCustomChannelVars.optString("overflowID", null));
            // customChannelVars.setMemberCallID(rawCustomChannelVars.optString("memberCallID", null));
            // customChannelVars.setVcGroup(rawCustomChannelVars.optString("vcGroup", null));
            // customChannelVars.setVcNumber(rawCustomChannelVars.optString("vcNumber", null));
        
            callEvent.setCcvs(customChannelVars);
        } else {
            JSONObject rawCustomChannelVars = jsonData.optJSONObject("Custom-Channel-Vars");
            CustomChannelVars customChannelVars = new CustomChannelVars();
            customChannelVars.setAccountID(rawCustomChannelVars.optString("Username", null));
            customChannelVars.setAccountName(rawCustomChannelVars.optString("Account-Name", null));
            customChannelVars.setAccountID(rawCustomChannelVars.optString("Account-ID", null));
            customChannelVars.setCallInteractionID(rawCustomChannelVars.optString("Call-Interaction-ID", null));
            customChannelVars.setOwnerID(rawCustomChannelVars.optString("Owner-ID", null));
            customChannelVars.setQueueID(rawCustomChannelVars.optString("Queue-ID", null));
            customChannelVars.setOverflowID(rawCustomChannelVars.optString("Overflow-ID", null));
            customChannelVars.setMemberCallID(rawCustomChannelVars.optString("Member-Call-ID", null));
            customChannelVars.setVcGroup(rawCustomChannelVars.optString("Voice-Channel-Group", null));
            customChannelVars.setVcNumber(rawCustomChannelVars.optString("Voice-Channel-Number", null));
            
            callEvent.setCcvs(customChannelVars);
        }

       
        callEvent.setEventName(jsonData.optString("Event-Name", null));
        callEvent.setCallID(jsonData.optString("Call-ID", null));
        callEvent.setAccountId(jsonData.optString("Account-ID", null));
        callEvent.setAccountName(jsonData.optString("Account-Name", null));
        callEvent.setInteractionId(jsonData.optString("Interaction-ID", null));
        callEvent.setOriginationCallID(jsonData.optString("Origination-Call-ID", null));
        callEvent.setPresenceID(jsonData.optString("Presence-ID", null));
        callEvent.setBridgeId(jsonData.optString("Bridge-ID", null));
        callEvent.setOtherLegCallID(jsonData.optString("Other-Leg-Call-ID", null));
        callEvent.setOtherLegDirection(jsonData.optString("Other-Leg-Direction", null));
        callEvent.setOtherLegDestinationNumber(jsonData.optString("Other-Leg-Destination-Number", null));
        callEvent.setCallerIDName(jsonData.optString("Caller-ID-Name", null));
        callEvent.setCallerIDNumber(jsonData.optString("Caller-ID-Number", null));
        callEvent.setFrom(jsonData.optString("From", null));
        callEvent.setTo(jsonData.optString("To", null));
        callEvent.setFromUri(jsonData.optString("From-URI", null));
        callEvent.setToUri(jsonData.optString("To-URI", null));
        callEvent.setRequest(jsonData.optString("Request", null));
        callEvent.setCalleeIDNumber(jsonData.optString("Callee-ID-Number", null));
        callEvent.setCallDirection(jsonData.optString("Call-Direction", null));
        callEvent.setChannelCreatedTimeMs(java.time.Instant.now().toEpochMilli());
        callEvent.setCavs(jsonData.optJSONObject("Custom-Application-Vars"));
        callEvent.setCshs(jsonData.optJSONObject("Custom-SIP-Headers"));
        callEvent.setNode(jsonData.optString("Node", null));
        callEvent.setSwitchNodename(jsonData.optString("Switch-Nodename, null"));
        callEvent.setSipHangupDisposition(jsonData.optString("Sip-Hangup-Disposition", null));
        callEvent.setHangupCode(jsonData.optString("Hangup-Code", null));
        callEvent.setHangupCause(jsonData.optString("Hangup-Cause", null));
        callEvent.setSmartRouting(jsonData.optBoolean("Smart-Routing", false));
        callEvent.setSmartRoutingExit(jsonData.optBoolean("Smart-Routing-Exit"));

        

        


        return callEvent;
    }
    
    
}
