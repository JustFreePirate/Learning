package org.stepic.java.Robot;

import java.io.Closeable;

/**
 * Created by ִלטענטי on 05.10.2015.
 */
public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close() throws Exception;
}
