import java.awt.*;

class Rectangle extends Figures{

    Color c;
    public Rectangle(int x, int y, int w, int h, int r, int g, int b, String n) {
        super(x, y, w,h,r,g,b,n);
        c= new Color(r,g,b);
    }
    public String toString(){return super.toString();}
    public void paint(Graphics g1){
        super.paintComponent(g1);
        g1.setColor(c);
        switch (name){
           case "FRec":
               g1.fillRect(x,y,width,height);
                repaint();
                break;
            case "Rect":
                g1.drawRect(x,y,width,height);
                repaint();
                break;
        }


    }
}