package call.monitor.app.config;

import org.apache.kafka.common.serialization.Deserializer;

import com.google.gson.Gson;

import call.monitor.app.model.CallEvent;

public class GsonDeserializer<T> implements Deserializer<T> {
    private final Gson gson = new Gson();
    private final Class<T> type;

    public GsonDeserializer(Class<T> type) {
        this.type = type;
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }
        try {
            boolean isSS = topic.startsWith("call-app-ss-");
            // System.out.println("Type for deserialization: " + type.getName());
            System.out.println("Deserializing data for topic: " + topic + ", data: " + new String(data));
            // System.out.println("----------------------------------------------------------------");
            try {
                CallEvent callEvent = CallParser.parseCallEvent(new String(data), isSS);

                String callEventJson = gson.toJson(callEvent);

                // System.out.println(gson.fromJson(callEventJson, type));
                // System.out.println("----------------------------------------------------------------");
                return gson.fromJson(callEventJson, type);
            } catch (Exception e) {
                System.out.println("Failed to parse CallEvent: " + e.getMessage());
                e.printStackTrace();
            }
            return gson.fromJson(new String(data), type);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize data for topic: " + topic, e);
        }
    }
}

