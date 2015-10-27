package org.stepic.java.Robot;

/**
 * Created by ������� on 05.10.2015.
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
        // ������� ����������� �������
        return direction;
    }

    public int getX() {
        // ������� ���������� X
        return x;
    }

    public int getY() {
        // ������� ���������� Y
        return y;
    }

    public void turnLeft() {
        // ����������� �� 90 �������� ������ ������� �������
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
        // ����������� �� 90 �������� �� ������� �������
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
        // ��� � ����������� �������
        // �� ���� ��� ����� �������� ���� ���� ���������� �� �������
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
