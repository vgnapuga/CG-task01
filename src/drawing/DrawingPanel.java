package drawing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingPanel extends JFrame {

    private static ArrayList<Drawable> drawable = new ArrayList<>();

    private final int BACKGROUND_WIDTH = 800;
    private final int BACKGROUND_HEIGHT = 600;

    public DrawingPanel() {
        setTitle("Cats");
        setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void addDrawable(Drawable pic) {
        drawable.add(pic);
    }

    public static void removeDrawable(Drawable pic) {
        drawable.remove(pic);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for (Drawable obj : drawable)
            obj.draw(g2d);
    }

}

interface Drawable {
    void draw(Graphics2D g2d);
}