package br.jazz.sqsproject;

import java.time.LocalDate;
import java.time.LocalTime;

import br.jazz.sqsproject.services.SQSMessageReader;
import br.jazz.sqsproject.services.SQSMessageSender;

public class App {
	public static void main(String[] args) {
		SQSMessageSender.sendMessage("New message: " + LocalDate.now() + " - " + LocalTime.now());

		while (true) {
			SQSMessageReader.readMessages();
		}
	}
}
