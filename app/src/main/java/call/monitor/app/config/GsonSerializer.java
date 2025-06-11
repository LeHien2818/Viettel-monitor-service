package call.monitor.app.config;

import com.google.gson.Gson;
import org.apache.kafka.common.serialization.Serializer;

public class GsonSerializer<T> implements Serializer<T> {
    private final Gson gson = new Gson();

    @Override
    public byte[] serialize(String topic, T data) {
        if (data == null) {
            return null;
        }
        try {
            return gson.toJson(data).getBytes();
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize object: " + data, e);
        }
    }
}

