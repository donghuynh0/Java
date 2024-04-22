package drawing_panel;

import java.awt.*;
public class Point2D {
    private int x,y;

    public Point2D(){
        this(0,0);

    }
    public Point2D(int x, int y){
        this.x = x;
        this.y = y;
    }

//    static is function if not is method, method is relevant with states
    private static void sth(){
        System.out.println("Private static!");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance(Point2D other){
        return Math.sqrt(Math.pow(x-other.x,2) + Math.pow(y -other.y,2));
    }

    public void draw(Graphics g){
        g.fillOval(this.x-1,this.y-1,2,2);
        g.drawString("("+this.x+","+this.y+")",this.x,this.y+5);
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
