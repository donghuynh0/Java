package drawing_panel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
//        Read data
        Point2D[] points = readData("/Users/myainguyen/Downloads/huynhdong/CS206V/Drawing_Panel/src/main/java/Data/points.txt");
//        Ask user enter center and radius
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int radius = scan.nextInt();
        Point2D center = new Point2D(x,y);
        DrawingPanel panel = new DrawingPanel(400,400);
        Graphics graphics = panel.getGraphics();

        bomb(points,center,radius,graphics);

    }
//    Read data from file
    public static Point2D[] readData(String filename){
        try {
            Scanner input = new Scanner(new File(filename));
            int point_no = input.nextInt();
            Point2D[] result = new Point2D[point_no];
            for (int i = 0; i < point_no; i++) {
                result[i] = new Point2D(input.nextInt(),input.nextInt());
            }
            return result;
        }catch (FileNotFoundException  ex){
            ex.printStackTrace();
        }
        return null;
    }
    public static void bomb(Point2D[] points, Point2D center, int radius, Graphics graphics){
        Color red = new Color(255,0,0);
        Color blue = new Color(0,0,255);
        graphics.setColor(new Color(0,255,0));
        center.draw(graphics);
        graphics.drawOval(center.getX()-radius, center.getY() -radius,radius*2,radius*2);
        for (int i = 0; i < points.length; i++) {
            Point2D p = points[i];
            if (center.distance(p) > radius)
                graphics.setColor(blue); //ouside circle is blue
            else
                graphics.setColor(red); //inside circle is red
            p.draw(graphics);
        }
    }
}