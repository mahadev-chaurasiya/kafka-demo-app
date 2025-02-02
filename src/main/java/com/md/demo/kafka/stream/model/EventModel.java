package com.md.demo.kafka.stream.model;
public class EventModel {
    private int id;
    private String eventName;
    private String eventSource;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", eventSource='" + eventSource + '\'' +
                '}';
    }
}
