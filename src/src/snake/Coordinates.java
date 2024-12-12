package src.snake;

public class Coordinates {

    public int x;
    public int y;
    public String object;


    public Coordinates(int x, int y, String object) {
        this.x = x;
        this.y = y;
        this.object = object;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
