# sqs-message-service

<a href="https://github.com/jfsax">@jfsax</a> - 2022-04-29 / 15:06

TODO: documentation

# before running the project:
- add environment variables to .bash_profile or .bashrc

```shell
code ~/.bash_profile
```

```
export AWS_ACCESS_KEY="<YOUR_ACCESS_KEY>"
export AWS_SECRET_KEY="<YOUR_SECRET_KEY>"
export SQS_QUEUE_NAME="<YOUR_QUEUE_NAME>"
export SQS_AWS_ACC_ID="<YOUR_SQS_AWS_ID>"
```

- however you can also insert your <b>queueName</b> and <b>queueOwnerAWSAccountId</b> as strings on the SQSQueueClient class.

```shell
source ~/.bash_profile
```
