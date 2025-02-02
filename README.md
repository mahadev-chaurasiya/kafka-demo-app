#Kafka Integration

#JAVA 17
#SpringBoot 3.4.2

API's Developed

1.localhost:8080/api/v1/kafka/publish2
Payload
{
	"id":4,
	"eventName":"test",
	"eventSource":"local"
}


2.localhost:8080/api/v1/kafka/publish?message=hello

#Step 1: Get Kafka
Download the latest Kafka release and extract it:
https://kafka.apache.org/downloads

#Step 2: Start the Kafka environment
NOTE: Your local environment must have Java 8+ installed.
Apache Kafka can be started using KRaft or ZooKeeper. To get started with either configuration follow one of the sections below but not both. 

Kafka with ZooKeeper
Run the following commands in order to start all services in the correct order:
# Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties

Open another terminal session and run:
# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties


#Step 3: Create a topic to store your events

$ bin/kafka-topics.sh --create --topic EVENT_JSON_TOPIC --bootstrap-server localhost:9092


All of Kafka's command line tools have additional options: run the kafka-topics.sh command without any arguments to display usage information. For example, it can also show you details such as the partition count of the new topic:
$ bin/kafka-topics.sh --describe --topic EVENT_JSON_TOPIC --bootstrap-server localhost:9092
Topic: EVENT_JSON_TOPIC        TopicId: NPmZHyhbR9y00wMglMH2sg PartitionCount: 1       ReplicationFactor: 1	Configs:
Topic: EVENT_JSON_TOPIC Partition: 0    Leader: 0   Replicas: 0 Isr: 0


#Step 4: Write some events into the topic
A Kafka client communicates with the Kafka brokers via the network for writing (or reading) events. Once received, the brokers will store the events in a durable and fault-tolerant manner for as long as you need—even forever.
Run the console producer client to write a few events into your topic. By default, each line you enter will result in a separate event being written to the topic.
$ bin/kafka-console-producer.sh --topic EVENT_JSON_TOPIC --bootstrap-server localhost:9092>This is my first event>This is my second event
You can stop the producer client with Ctrl-C at any time.

#Step 5: Read the events
Open another terminal session and run the console consumer client to read the events you just created:
$ bin/kafka-console-consumer.sh --topic EVENT_JSON_TOPIC --from-beginning --bootstrap-server localhost:9092
This is my first event
This is my second event
You can stop the consumer client with Ctrl-C at any time.
