package io.berndruecker.demo.zeebe.firstcontact.prepared;

import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.ZeebeFuture;
import io.zeebe.client.api.events.DeploymentEvent;

public class DeployWorkflowModel {

  public static void main(String[] args) {
    ZeebeClient zeebe = ZeebeClient.newClient();

    ZeebeFuture<DeploymentEvent> deploymentFuture = zeebe.topicClient().workflowClient().newDeployCommand()
      .addResourceFromClasspath("prepared.bpmn")
      .send();
    
    System.out.println("Deployment sent...");
    
    DeploymentEvent deploymentEvent = deploymentFuture.join();

    System.out.println("   ... and succesfully deployed: " + deploymentEvent);

    zeebe.close();
  }

}
