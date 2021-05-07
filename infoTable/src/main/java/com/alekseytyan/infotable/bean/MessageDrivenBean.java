package com.alekseytyan.infotable.bean;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
                propertyName = "acknowledgeMode",
                propertyValue = "Auto-acknowledge"
        ),
        @ActivationConfigProperty(
                propertyName = "destination",
                propertyValue = "infoTable"
        ),
        @ActivationConfigProperty(
                propertyName = "destinationType",
                propertyValue = "javax.jms.Queue"
        ),
})
@RequiredArgsConstructor
public class MessageDrivenBean implements MessageListener {

    private final WebSocket webSocket;

    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        webSocket.interpretMsg(textMessage.getText());
    }

}