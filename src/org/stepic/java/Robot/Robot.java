package org.stepic.java.Robot;

/**
 * Created by Дмитрий on 05.10.2015.
 */
public class Robot {
    private Direction direction;
    private int x;
    private int y;
    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    public Direction getDirection() {
        // текущее направление взгляда
        return direction;
    }

    public int getX() {
        // текущая координата X
        return x;
    }

    public int getY() {
        // текущая координата Y
        return y;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
        switch (direction) {
            case UP:
                direction = Direction.LEFT; break;
            case LEFT:
                direction = Direction.DOWN; break;
            case DOWN:
                direction = Direction.RIGHT; break;
            case RIGHT:
                direction = Direction.UP; break;

        }
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        switch (direction) {
            case UP:
                direction = Direction.RIGHT; break;
            case LEFT:
                direction = Direction.UP; break;
            case DOWN:
                direction = Direction.LEFT; break;
            case RIGHT:
                direction = Direction.DOWN; break;

        }
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        switch (direction) {
            case UP:
                y++; break;
            case LEFT:
                x--;
            case DOWN:
                y--;
            case RIGHT:
                x++;

        }
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) throws Exception {
        for (int i = 0; i < 3; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw e;
                }
            }
        }

    }
}
