FROM jboss/wildfly
ADD target/task19.war /opt/jboss/wildfly/standalone/deployments/
