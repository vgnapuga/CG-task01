import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JFrame {

    private final int BACKGROUND_WIDTH = 800;
    private final int BACKGROUND_HEIGHT = 600;


    protected DrawingPanel() {
        setTitle("Cats");

        setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        final int width = getWidth();
        final int height = getHeight();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0,
                width, height);

        new DrawCat(g2d, (width / 2) - 135, (height / 2) - 112,
                1200, 800,
                Color.BLACK, Color.WHITE, Color.CYAN);
    }

}
