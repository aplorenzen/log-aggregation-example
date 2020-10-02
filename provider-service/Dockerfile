FROM openjdk:11-jdk-slim

RUN apt-get update && \
  apt-get install -y wget && \
  rm -rf /var/lib/apt/lists/*

RUN wget -O /apm-agent.jar https://search.maven.org/remotecontent?filepath=co/elastic/apm/elastic-apm-agent/1.18.0/elastic-apm-agent-1.18.0.jar

COPY target/provider-service-*.jar /opt/provider-service.jar

CMD java \
  -javaagent:/apm-agent.jar \
  -Delastic.apm.service_name=provider-service \
  -Delastic.apm.server_url=http://apm:8200 \
  -Delastic.apm.secret_token= \
  -Delastic.apm.application_packages=com.netcompany.elk.provider \
  ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom \
  -jar /opt/provider-service.jar
