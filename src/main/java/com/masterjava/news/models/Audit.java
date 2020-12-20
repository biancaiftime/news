package com.masterjava.news.models;

public class Audit {
    private int id;
    private Operation operation;
    private ObjectType objectType;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Audit(int id, Operation operation, ObjectType objectType, String description) {
        this.id = id;
        this.operation = operation;
        this.objectType = objectType;
        this.description = description;
    }

    public Audit() {
    }
}

