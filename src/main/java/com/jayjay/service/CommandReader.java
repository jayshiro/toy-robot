package com.jayjay.service;

public interface CommandReader {

    public boolean isValid(String command);
    public void handle(String command);
}
