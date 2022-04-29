package br.jazz.sqsproject.services;

import br.jazz.sqsproject.auth.AWSCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;

public class SQSQueueClient {
    public static SqsClient getSQSClient() {
        final Region REGION_DEFAULT = Region.US_EAST_1;

        SqsClient sqsClient = SqsClient.builder()
                .region(REGION_DEFAULT)
                .credentialsProvider(AWSCredentials.getCredentials())
                .build();

        return sqsClient;
    }

    public static String getClientQueue() {
        String queueName = System.getenv("SQS_QUEUE_NAME");
        String queueOwnerAWSAccId = System.getenv("SQS_AWS_ACC_ID");

        GetQueueUrlRequest requestQueue = GetQueueUrlRequest.builder()
                .queueName(queueName)
                .queueOwnerAWSAccountId(queueOwnerAWSAccId).build();

        String queueUrlStr = getSQSClient().getQueueUrl(requestQueue).queueUrl();

        return queueUrlStr;
    }
}