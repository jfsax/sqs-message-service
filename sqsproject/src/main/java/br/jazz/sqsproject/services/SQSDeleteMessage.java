package br.jazz.sqsproject.services;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.Message;

public class SQSDeleteMessage {
    public static void deleteMessages(SqsClient sqsClient, String queueUrlStr, Message message) {
        DeleteMessageRequest deleteMessageReq = DeleteMessageRequest.builder()
                .queueUrl(queueUrlStr)
                .receiptHandle(message.receiptHandle())
                .build();

        sqsClient.deleteMessage(deleteMessageReq);
    }
}
