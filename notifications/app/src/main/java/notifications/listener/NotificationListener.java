package notifications.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author pranjal
 * @date 2023-11-29
 */

@Component
@Profile("dev")
@Slf4j
public class NotificationListener {

    @KafkaListener(topics = "notification.created")
    public String listener(final String msg) {
        log.info("Received Notification: {}", msg);

        return msg;
    }
}
