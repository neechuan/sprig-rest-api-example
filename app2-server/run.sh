export JAVA_HOME=/opt/homebrew/opt/openjdk@17
export PATH=$JAVA_HOME/bin:$PATH

mvn spring-boot:run \
  -Dspring-boot.run.jvmArguments="-javaagent:/Users/garychew/AppServerAgent/javaagent.jar \
  -Dappdynamics.socket.collection.bci.enable=true \
  -Dappdynamics.controller.hostName=apac-ps-sandbox.saas.appdynamics.com \
  -Dappdynamics.controller.port=443 \
  -Dappdynamics.controller.ssl.enabled=true \
  -Dappdynamics.agent.applicationName=gary-spring-rest \
  -Dappdynamics.agent.tierName=Server \
  -Dappdynamics.agent.nodeName=Server1 \
  -Dappdynamics.agent.accountName=apac-ps-sandbox \
  -Dappdynamics.agent.accountAccessKey=q9ic74tm00t0"
