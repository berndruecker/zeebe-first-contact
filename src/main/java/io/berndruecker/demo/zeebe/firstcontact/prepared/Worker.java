package io.berndruecker.demo.zeebe.firstcontact.prepared;

import java.time.Duration;

import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.subscription.JobWorker;

public class Worker {

  public static void main(String[] args) {
    ZeebeClient zeebe = ZeebeClient.newClient();

    JobWorker jobWorker = zeebe.topicClient().jobClient().newWorker()
        .jobType("hello-world")
        .handler((client, job) -> {
          
          
          System.out.println("Hello world with payload '"+job.getPayload()+"' in " + job );
          client.newCompleteCommand(job).send().join();
          
        }).timeout(Duration.ofMinutes(1))
        .name("demo-worker")
        .open();
        
    System.out.println("Worker started");
  }

}
