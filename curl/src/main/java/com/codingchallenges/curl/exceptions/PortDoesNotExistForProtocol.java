package com.codingchallenges.curl.exceptions;

public class PortDoesNotExistForProtocol extends BaseException{
    public PortDoesNotExistForProtocol(String protocol) {
        super("Port does not exist for protocol " + protocol);
    }
}
