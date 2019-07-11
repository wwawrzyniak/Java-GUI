import javax.swing.*;
import java.awt.*;
abstract class Figures extends JComponent {
    int x,y,width,height,r,G,b;
    Color c1;
    protected String name;
    public Figures(int x, int y, int width, int height, int r, int g, int b, String n) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.r=r;
        this.G=g;
        this.b=b;
        this.c1=(new Color(r,g,b));
        this.name=n;
    }
    public String toString(){return name+" "+x+" "+y+" "+width+" "+height+" "+r+" "+G+" "+b;}

    public void paint(Graphics g){
    System.out.println("Painting figure");
}}
