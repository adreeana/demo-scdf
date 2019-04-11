# Pimp up your Spring Batch en streaming avec Spring Cloud Data Flow and Kafka

Spring Cloud Data Flow comes with an out of the box Docker distribution.
Follow the
[procedure](https://docs.spring.io/spring-cloud-dataflow/docs/current/reference/htmlsingle/#getting-started-local-deploying-spring-cloud-dataflow-docker)
to download, install, configure and run the platform on your computer.
The distribution contains, Spring Cloud Data Flow, Kafka, Prometheus and
Grafana.

Application's jars are located in the local Maven repository
(MAVEN_LOCAL_REPO). 

Run Skipper Server with the following parameter:
>--maven.localRepository=$MAVEN_LOCAL_REPO_PATH
 
and Spring Cloud Data Flow with the following parameters:
>--maven.localRepository=$MAVEN_LOCAL_REPO_PATH
>--spring.cloud.dataflow.applicationProperties.stream.management.metrics.export.prometheus.enabled=true
>--spring.cloud.dataflow.applicationProperties.stream.spring.cloud.streamapp.security.enabled=false
>--spring.cloud.dataflow.applicationProperties.stream.management.endpoints.web.exposure.include=prometheus,info,health
>--spring.cloud.dataflow.grafana-info.url=http://localhost:3000
    
- **Build applications jars**

In the demo-scdf directory execute *mvn clean install*.

- **Deploy applications**

Use the Spring Cloud Data Flow Dashboard to add the following
applications:

> task_source.toy_task=maven://com.devoxxfr.scdf:demo-task-source-toy:0.0.1-SNAPSHOT
> source.toy_source=maven://com.devoxxfr.scdf:demo-task-source-toy:0.0.1-SNAPSHOT
> processor.child_processor=maven://com.devoxxfr.scdf:demo-processor-child:0.0.1-SNAPSHOT
> sink.letter_sink=maven://com.devoxxfr.scdf:demo-sink-lettre:0.0.1-SNAPSHOT

- **Create Task and Streams**
 
Use the Spring Cloud Data Flow Dashboard to create the Task and the
Streams.

- **Deploy the streams**

deployer.*.count=1
 
deployer.*.cpu=3 

deployer.*.disk=200

deployer.*.memory=512 

spring.cloud.dataflow.skipper.platformName=default

- **Metrics**

Applications: localhost:3000/d/scdf-applications/applications?refresh=10s

Streams: localhost:3000/d/scdf-streams/streams?refresh=10s

- **Learn more**

[Spring online reference documentation](https://docs.spring.io/spring-cloud-dataflow/docs/current/reference/htmlsingle/#getting-started)