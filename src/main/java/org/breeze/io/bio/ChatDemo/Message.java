package org.breeze.io.bio.ChatDemo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {

    private Header header;
    private String message;

    public Message(Header header, String message) {
        this.header = header;
        this.message = message;
    }
}
