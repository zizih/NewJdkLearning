package kafka;

import java.util.Properties;

/**
 * Author: hezi.hz
 * Date: 11/29/18
 */
public class MyKafkaConfig {

    public static Properties kafkaConsumerConf() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }

    public static Properties kafkaProducerConf() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("delivery.timeout.ms", 30000);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("request.timeout.ms", 20000);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

}
