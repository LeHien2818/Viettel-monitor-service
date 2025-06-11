package call.monitor.app.processor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

@Component
@CrossOrigin(origins = "*")
public class KafkaConsumer {
    private SocketIOServer socketIOServer;

    public KafkaConsumer() {
        Configuration config = new Configuration();
        config.setHostname("0.0.0.0");
        config.setPort(8085);
        this.socketIOServer = new SocketIOServer(config);
        socketIOServer.start();
    }

    @KafkaListener(topics = "output-call-topic", groupId = "call-app-consumer")
    public void consumeMessage(String message) {
        // Logic to consume messages from Kafka topic
        System.out.println("Consumed message: " + message);

        try {
            socketIOServer.getBroadcastOperations().sendEvent("call-message", message);
            System.out.println("Broadcasted message to Socket.IO clients: " + message);
            // Write message to a file in pretty JSON format
            // Get data from socket
            // socketIOServer.addEventListener("call-message", String.class, new DataListener<String>() {
            //     @Override
            //     public void onData(com.corundumstudio.socketio.SocketIOClient client,
            //     String data, com.corundumstudio.socketio.AckRequest ackRequest) {
            //         System.out.println("Received message: " + message);
            //         client.sendEvent("call-message", message);
            //     }
 
            // });
            
            System.out.println("Socket.IO server started on port 8085");
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Error starting Socket.IO server: " + e.getMessage());
            socketIOServer.stop();
        }  

    }
}
