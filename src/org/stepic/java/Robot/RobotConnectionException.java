package org.stepic.java.Robot;

/**
 * Created by ������� on 05.10.2015.
 */
public class RobotConnectionException extends RuntimeException {
    public RobotConnectionException(String message) {
        super(message);

    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
