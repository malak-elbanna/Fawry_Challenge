package com.malak;

public class MailService {
    public MailService() {}

    public void send(Emailable item, String email) {
        System.out.println("\nSending " + item.getTitle() + " to " + email);
    }
}
