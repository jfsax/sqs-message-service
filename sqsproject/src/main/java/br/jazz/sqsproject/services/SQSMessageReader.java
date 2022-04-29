package br.jazz.sqsproject.services;

import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;

public class SQSMessageReader {
    public static void readMessages() {
        try {
            SqsClient sqsClient = SQSQueueClient.getSQSClient();
            String queueUrlStr = SQSQueueClient.getClientQueue();

            List<Message> messages = SQSMessageReceiver.receiveMessages(sqsClient, queueUrlStr);

            for (Message message : messages) {
                System.out.println("\n====== Incoming Message ======");
                System.out.println("Message ID: " + message.messageId());
                System.out.println("ReceiptHandle: " + message.receiptHandle());
                System.out.println("Body: " + message.body());

                // burn after reading - @jfsax
                SQSDeleteMessage.deleteMessages(sqsClient, queueUrlStr, message);
            }

            sqsClient.close();
        } catch (AmazonServiceException ex) {
            System.out.println("Error Message: " + ex.getMessage());
            System.out.println("HTTP Status Code: " + ex.getStatusCode());
            System.out.println("AWS Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
        } catch (AmazonClientException ex) {
            System.out.println("Error Message: " + ex.getMessage());
        }
    }
}