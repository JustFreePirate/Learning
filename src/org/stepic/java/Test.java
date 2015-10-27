package org.stepic.java;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * Created by ??????? on 05.10.2015.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("ттр");
//        Logger LOGGER_A = Logger.getLogger("org.stepic.java.logging.ClassA");
//        LOGGER_A.setLevel(Level.ALL);
//        Logger LOGGER_B = Logger.getLogger("org.stepic.java.logging.ClassB");
//        LOGGER_B.setLevel(Level.WARNING);
//        ConsoleHandler ch = new ConsoleHandler();
//        ch.setFormatter(new XMLFormatter());
//        Logger log = Logger.getLogger("org.stepic.java");
//        log.setUseParentHandlers(false);
//        log.addHandler(ch);

    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        // ...
        RuntimeException exception = new RuntimeException();
        StackTraceElement[] stackTrace = exception.getStackTrace();
        if (stackTrace.length <= 2) {
            return null;
        }
        return stackTrace[2].getClassName() + "#" + stackTrace[2].getMethodName();
    }
}
