import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DisplayingModule extends PaintingModule {
    public static ArrayList<Figures> FigsList2= new ArrayList<>();
    public static ArrayList temp = new ArrayList<>();
    public DisplayingModule(String n){
        super(n);
    }
    //Czyta figury z pliku tekstowego
    public void readFromFile(){
        String line;
        try{
            BufferedReader input = new BufferedReader((new FileReader("ile.txt")));
            if (!input.ready()){throw new IOException();}
            while ((line=input.readLine())!=null){
                System.out.println(line);temp.add(line);}
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();}
        System.out.println("Read from file finished");

    }
    //Dodaje figury wczytane z pliku tekstowego do ArrayList FigsList2 i rysuje je
    Thread threadDisplaying = new Thread(() -> {
        for(Object s : temp)
        {
            String line = String.valueOf(s);
            String splited[]= line.split("\\s");
            //System.out.println(Arrays.toString(splited));
            switch (splited[0]){
                case "Rect": {
                    FigsList2.add(new Rectangle(Integer.parseInt(splited[1]), Integer.parseInt(splited[2]), Integer.parseInt(splited[3]), Integer.parseInt(splited[4]), Integer.parseInt(splited[5]), Integer.parseInt(splited[6]), Integer.parseInt(splited[7]),"Rect"));
                    break;
                }
                case "FRec": {
                    FigsList2.add(new Rectangle(Integer.parseInt(splited[1]), Integer.parseInt(splited[2]), Integer.parseInt(splited[3]), Integer.parseInt(splited[4]), Integer.parseInt(splited[5]), Integer.parseInt(splited[6]), Integer.parseInt(splited[7]), "FRec"));
                    break;
                }
                case "Oval": {
                    FigsList2.add(new Oval(Integer.parseInt(splited[1]), Integer.parseInt(splited[2]), Integer.parseInt(splited[3]), Integer.parseInt(splited[4]), Integer.parseInt(splited[5]), Integer.parseInt(splited[6]), Integer.parseInt(splited[7]), "Oval"));
                    break;
                }
                case "FOva": {
                    FigsList2.add(new Oval(Integer.parseInt(splited[1]), Integer.parseInt(splited[2]), Integer.parseInt(splited[3]), Integer.parseInt(splited[4]), Integer.parseInt(splited[5]), Integer.parseInt(splited[6]), Integer.parseInt(splited[7]), "FOva"));
                    break;
                }
                case "Line": {
                    FigsList2.add(new Line(Integer.parseInt(splited[1]), Integer.parseInt(splited[2]), Integer.parseInt(splited[3]), Integer.parseInt(splited[4]), Integer.parseInt(splited[5]), Integer.parseInt(splited[6]), Integer.parseInt(splited[7]), "Line"));
                    break;
                }
                default:
                    System.out.printf("No such shape");
            }

        }
        for(Figures f: FigsList2) {
            f.paint(getGraphics());
            this.setVisible(true);
        }
        try{ Thread.sleep(10);
        } catch (Exception e) {
        }});
}

