package notifications.config;

import notifications.config.props.KafkaConfigProps;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author pranjal
 * @date 2023-11-29
 */

@Configuration
@Profile("dev")
public class KafkaConfig {
    @Bean
    NewTopic notificationsPublished(final KafkaConfigProps props) {
        return TopicBuilder.name(props.getTopic())
                .partitions(10)
                .replicas(1)
                .build();
    }
}
