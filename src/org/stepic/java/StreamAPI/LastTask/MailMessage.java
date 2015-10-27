package org.stepic.java.StreamAPI.LastTask;

/**
 * Created by ִלטענטי on 23.10.2015.
 */
public class MailMessage implements MailThing<String> {
    private final String from;
    private final String to;
    private final String content;

    public MailMessage(final String from, final String to, final String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public String getThing() {
        return content;
    }

    public String getContent() {
        return content;
    }
}
