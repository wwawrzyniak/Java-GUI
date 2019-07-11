import java.awt.event.ComponentAdapter;

public class A extends ComponentAdapter {
    public static void main(String[] args) throws Exception {
        PaintingModule paint = new PaintingModule("Painting module");
        Thread thread = paint.threadParameters;
        thread.start();
        paint.setVisible(true);
        thread.join();
        paint.writeToFile();
        DisplayingModule display = new DisplayingModule("Displaying module");
        display.readFromFile();
        Thread thread1 = display.threadDisplaying;
        thread1.start();
        display.setVisible(true);

    }

}
