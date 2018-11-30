package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Author: hezi.hz
 * Date: 11/29/18
 */
public class MyKafkaProducer {

    public static void main(String[] args) {
        Properties props = MyKafkaConfig.kafkaProducerConf();
        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 5; i++)
            producer.send(new ProducerRecord<String, String>("phoebe-topic", "I am from java-producer key-"+Integer.toString(i),
                "I am from java-producer value-"+Integer.toString(i)));
        producer.close();
    }
}
