package br.jazz.sqsproject.services;

import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

public class SQSMessageReceiver {
    public static List<Message> receiveMessages(SqsClient sqsClient, String queueUrlStr) {
        try {
            ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                    .queueUrl(queueUrlStr)
                    .waitTimeSeconds(20)
                    .maxNumberOfMessages(5)
                    .build();

            List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();

            return messages;
        } catch (AmazonServiceException ex) {
            System.out.println("Error Message: " + ex.getMessage());
            System.out.println("HTTP Status Code: " + ex.getStatusCode());
            System.out.println("AWS Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());

            return null;
        } catch (AmazonClientException ex) {
            System.out.println("Error Message: " + ex.getMessage());

            return null;
        }
    }
}
