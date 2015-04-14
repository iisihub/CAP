package com.iisigroup.cap.security.captcha.producer;

import nl.captcha.text.producer.TextProducer;

public class CapTextProducer implements TextProducer {

    private String str;

    public CapTextProducer(String str) {
        this.str = str;
    }

    public String getText() {
        return str;
    }

}
