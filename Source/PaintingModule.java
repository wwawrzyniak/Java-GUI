import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import static java.lang.Math.random;

class PaintingModule extends JFrame {

    public static ArrayList<Figures> FigsList = new ArrayList<>();
    int Red, Green, Blue, x, y, figureWidth, figureHeight, myRandNr;
    public int windowWidth =500;
    public int windowHeight=700;
    public PaintingModule(String n) {

        this.setTitle(n);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(windowWidth,windowHeight);
        this.setLocationRelativeTo(null);
    }
    //Wpisuje do pliku tekstowego figury
    public void writeToFile () throws IOException {
        FileWriter fw = null;
        fw = new FileWriter("ile.txt");
        Writer output = new BufferedWriter(fw);
        int sz = FigsList.size();
        for (int i = 0; i < sz; i++)
            output.write(FigsList.get(i).toString()+"\r\n");
        output.close();
        System.out.println("Writing to a file - done");
    }
    //Rysuje figury i dodaje je do ArrayListy FigsList
    public void paint(Graphics g) {
        g.setColor(new Color(Red,Green,Blue));
        if (myRandNr == 0) {
            Figures f0 = new Rectangle(x, y, figureWidth, figureHeight, Red, Green, Blue, "Rect");
            f0.paint(g);
            FigsList.add(f0);
        }
        if (myRandNr == 1) {
            Figures f1 = new Oval(x, y, figureWidth, figureHeight, Red, Green, Blue, "Oval");
            f1.paint(g);
            FigsList.add(f1);
        }
        if (myRandNr == 2) {
            Figures f2 = new Line(x, y, figureWidth, figureHeight, Red, Green, Blue, "Line");
            f2.paint(g);
            FigsList.add(f2);
        }
        if (myRandNr == 3) {
            Figures f3 = new Oval(x, y, figureWidth, figureHeight, Red, Green, Blue, "FOva");
            f3.paint(g);
            FigsList.add(f3);
        }
        if (myRandNr == 4) {
            Figures f4 = new Rectangle(x, y, figureWidth, figureHeight, Red, Green, Blue, "FRec");
            f4.paint(g);
            FigsList.add(f4);
        }
        this.revalidate();
        this.repaint();
        try {
            Thread.sleep(50);
        } catch (Exception e) {
        }
    }
    //Losuje parametry figur
    Thread threadParameters = new Thread(() -> {
        for (int i=0; i<200; i++) {
           // System.out.println("Thread P running");
            this.Red = (int) (random() * 256);
            this.Green = (int) (random() * 256);
            this.Blue = (int) (random() * 256);
            this.x = new Random().nextInt((getSize().width - 100)) + 5; // 5 do Width-100
            this.y = new Random().nextInt((getSize().height - 100)) + 30; //30 do Height-100
            this.figureWidth = (int) (random() * ((getWidth() - x)));
            this.figureHeight = (int) (random() * ((getHeight() - y)));
            this.myRandNr = (int) (random() * 5);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
        }});

}