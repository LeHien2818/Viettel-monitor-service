package call.monitor.app.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
public class KafkaConfiguration {
    @Value("${kafka.broker.address}")
    private String kafkaAddress;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        String kafkaConnectionServer = "localhost:9092,localhost:9093";
        if(kafkaAddress != null){
            if(!kafkaAddress.equals(kafkaConnectionServer) &&
                !kafkaAddress.equals("default")){
                kafkaConnectionServer = kafkaAddress;
            }
        }

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConnectionServer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "call-app-consumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, GsonDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return new DefaultKafkaConsumerFactory<>(props);
    }

    
}
