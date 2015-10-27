package org.stepic.java.StreamAPI.LastTask;

/**
 * Created by ִלטענטי on 23.10.2015.
 */
public class Salary implements MailThing<Integer> {
    private final String from;
    private final String to;
    private final Integer salary;

    public Salary(String from, String to, Integer salary) {
        this.from = from;
        this.to = to;
        this.salary = salary;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public Integer getThing() {
        return salary;
    }
}
