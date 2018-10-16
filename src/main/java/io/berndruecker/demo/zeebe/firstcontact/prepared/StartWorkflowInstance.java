package io.berndruecker.demo.zeebe.firstcontact.prepared;

import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.events.WorkflowInstanceEvent;

public class StartWorkflowInstance {

  public static void main(String[] args) {
    ZeebeClient zeebe = ZeebeClient.newClient();

    WorkflowInstanceEvent workflowInstanceEvent = zeebe.workflowClient().newCreateInstanceCommand()
        .bpmnProcessId("prepared")
        .latestVersion()
        .payload("{ \"someJson\": \"someValue\"}")
        .send().join();
        
    
    System.out.println("Workflow instance started: " + workflowInstanceEvent);

    zeebe.close();
  }

}
