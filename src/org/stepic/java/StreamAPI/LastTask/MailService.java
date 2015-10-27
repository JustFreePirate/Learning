package org.stepic.java.StreamAPI.LastTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by ִלטענטי on 23.10.2015.
 */
public class MailService<T> implements Consumer <MailThing<T>> {
    private MailBox<T> mailBox;

    public MailService() {
        mailBox = new MailBox<>();
    }

    @Override
    public void accept(MailThing<T> t) {
        if (mailBox.containsKey(t.getTo())) {
            mailBox.get(t.getTo()).add(t.getThing());
        } else {
            List<T> list = new ArrayList<>();
            list.add(t.getThing());
            mailBox.put(t.getTo(), list);
        }
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
