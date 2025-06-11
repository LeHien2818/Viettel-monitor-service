package call.monitor.app.config;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class GsonSerde<T> implements Serde<T> {
    private final GsonSerializer<T> serializer;
    private final GsonDeserializer<T> deserializer;

    public GsonSerde(Class<T> type) {
        System.out.println("GsonSerde instantiated for type: " + type.getName());
        this.serializer = new GsonSerializer<>();
        this.deserializer = new GsonDeserializer<>(type);
    }

    @Override
    public Serializer<T> serializer() {
        return serializer;
    }

    @Override
    public Deserializer<T> deserializer() {
        return deserializer;
    }
}

