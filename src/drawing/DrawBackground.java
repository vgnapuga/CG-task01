package drawing;

import java.awt.*;

public class DrawBackground implements Drawable {

    private final int x, y, width, height;

    public DrawBackground(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.CYAN);
        g2d.fillRect(x, y, width, height);

        g2d.setColor(Color.GREEN);
        g2d.fillRect(x, y + (height / 10 * 9), width, height / 10);
    }

}