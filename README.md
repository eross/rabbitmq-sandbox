# Example using Reactive REST API to publish messages to RabbitMQ.

## Description

As simple single server that supports the following API Endpoints.  By default listens on port 8080

- /hello -- Sends a default message
- /hello/custom message -- Sends "custom message"

This service also has a Receiver that subscribes to the appropriate topic and recieves the messages.  This class
can be copied over to a subscriber service mostly as is to receive the messages.

