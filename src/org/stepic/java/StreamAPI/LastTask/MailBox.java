package org.stepic.java.StreamAPI.LastTask;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ִלטענטי on 23.10.2015.
 */
public class MailBox<T> extends HashMap<String,List<T>> {
    public MailBox() {
        super();
    }

    @Override
    public List<T> get(Object key) {
        List<T> list = super.get(key);
        return list != null ? list : Collections.<T>emptyList();
    }
}
