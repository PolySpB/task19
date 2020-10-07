FROM jboss/wildfly
COPY target/task19.war /opt/jboss/wildfly/standalone/deployments/

