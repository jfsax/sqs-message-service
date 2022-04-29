package br.jazz.sqsproject.services;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

public class SQSMessageSender {
	public static void sendMessage(String message) {
		try {
			SqsClient sqsClient = SQSQueueClient.getSQSClient();

			String queueUrlStr = SQSQueueClient.getClientQueue();

			SendMessageRequest sendMsgRequest = SendMessageRequest.builder()
					.queueUrl(queueUrlStr)
					.messageBody(message)
					.build();

			sqsClient.sendMessage(sendMsgRequest);

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