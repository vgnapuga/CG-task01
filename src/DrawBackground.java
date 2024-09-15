import java.awt.*;

public class DrawBackground {

    public DrawBackground(Graphics2D g2d, int x, int y, int width, int height) {
        g2d.setColor(Color.CYAN);
        g2d.fillRect(x, y, width, height);

        g2d.setColor(Color.GREEN);
        g2d.fillRect(x, y + (height / 10 * 9), width, height);
    }

}
