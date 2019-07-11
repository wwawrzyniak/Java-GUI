import java.awt.*;

class Line extends Figures{
    Color c;
    public Line(int x, int y, int w, int h, int r, int g, int b, String n) {
        super(x, y, w,h,r,g,b,n);
        c= new Color(r,g,b);
    }
    public String toString(){return super.toString();}
    @Override
    public void paint(Graphics g1){
        super.paintComponent(g1);
        g1.setColor(c);
        g1.drawLine(x,y,width,height);
        repaint();
    }
}

