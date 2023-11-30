package notifications.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pranjal
 * @date 2023-11-29
 */

@RestController
@Slf4j
public class NotificationController {

    final KafkaTemplate<String, String> kafkaTemplate;

    public NotificationController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/n")
    public String publish(@RequestParam String message) {
        kafkaTemplate.send("notification.created", message);
        log.info(message);
        System.out.println(message);
        return "OK";
    }

    @GetMapping("/not")
    public String publish() {
        log.info("here");
        System.out.println("here");
        return "OK";
    }
}
