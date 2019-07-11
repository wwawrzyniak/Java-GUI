import java.awt.*;

class Oval extends Figures{
    Color c;
    public Oval(int x, int y, int w, int h, int r, int g, int b, String n) {
        super(x, y, w,h,r,g,b,n);
        c= new Color(r,g,b);
    }
    public String toString(){return super.toString();}
    public void paint(Graphics g1){
        Graphics2D g2= (Graphics2D)g1;
        super.paintComponent(g2);
        g2.setColor(c);
        switch (name){
        case "FOva" :
            g2.fillOval(x,y,width,height);
            repaint();
            break;
        case "Oval":
            g2.drawOval(x,y,width,height);
            repaint();
            break;
        }
    }
}