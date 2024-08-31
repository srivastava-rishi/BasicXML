package com.example.myapplication;


public class MessageData {
    private String message;
    private String senderId;
    private String timeStamp;
    private String messageType;

    public MessageData(String message, String senderId, String timeStamp, String messageType) {
        this.message = message;
        this.senderId = senderId;
        this.timeStamp = timeStamp;
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

}