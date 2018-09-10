package io.berndruecker.demo.zeebe.firstcontact.prepared;

import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.ZeebeFuture;
import io.zeebe.client.api.events.DeploymentEvent;
import io.zeebe.client.api.events.WorkflowInstanceEvent;

public class StartWorkflowInstance {

  public static void main(String[] args) {
    ZeebeClient zeebe = ZeebeClient.newClient();

    WorkflowInstanceEvent workflowInstanceEvent = zeebe.topicClient().workflowClient().newCreateInstanceCommand()
        .bpmnProcessId("prepared")
        .latestVersion()
        .payload("{ \"someJson\": \"someValue\"}")
        .send().join();
        
    
    System.out.println("Workflow instance started: " + workflowInstanceEvent);

    zeebe.close();
  }

}
