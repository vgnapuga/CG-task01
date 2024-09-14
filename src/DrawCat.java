import java.awt.*;
import java.awt.geom.GeneralPath;

public class DrawCat {

    public DrawCat(Graphics2D g2d, int x, int y, int width, int height, Color primaryColor, Color secondaryColor, Color eyeColor) {
        int headWidth = width / 2 - width / 4;
        int headHeight = height / 4;
        int headX = x;
        int headY = y;

        int bodyWidth = headWidth / 2;
        int bodyHeight = headHeight * 3;
        int bodyX = headX + headWidth / 4;
        int bodyY = headY + headHeight - bodyHeight / 5;

        int tailWidth = bodyWidth / 2;
        int tailHeight = bodyHeight / 2;
        int tailX = bodyX - tailWidth / 2;
        int tailY = bodyY - tailHeight / 2;

        drawTail(g2d, tailX, tailY, tailWidth, tailHeight, primaryColor, secondaryColor);
        drawBody(g2d, bodyX, bodyY, bodyWidth, bodyHeight, primaryColor, secondaryColor);
        drawHead(g2d, headX, headY, headWidth, headHeight, primaryColor, secondaryColor, eyeColor);
    }

    private void drawTail(Graphics2D g2d, int tailX, int tailY, int tailWidth, int tailHeight, Color primaryColor, Color secondaryColor) {
        GeneralPath tailFull = new GeneralPath();

        g2d.setColor(Color.BLACK);
        tailFull.moveTo(tailX, tailY);
        tailFull.curveTo(tailX, tailY, tailX - tailWidth, tailY - tailHeight, tailX - tailWidth / 2, tailY - tailHeight / 2);
    }

    private void drawBody(Graphics2D g2d, int bodyX, int bodyY, int bodyWidth, int bodyHeight, Color primaryColor, Color secondaryColor) {
        g2d.setColor(Color.BLACK);
        g2d.drawArc(bodyX, bodyY, bodyWidth, bodyHeight, 0, 180);
        g2d.setColor(primaryColor);
        g2d.fillArc(bodyX, bodyY, bodyWidth, bodyHeight, 0, 180);

        int insideColorX = bodyX + bodyWidth / 4;
        int insideColorY = bodyY;
        int insideColorWidth = bodyWidth / 2;
        int insideColorHeight = bodyHeight / 3;

        g2d.setColor(Color.BLACK);
        g2d.drawOval(insideColorX, insideColorY, insideColorWidth, insideColorHeight);
        g2d.setColor(secondaryColor);
        g2d.fillOval(insideColorX, insideColorY, insideColorWidth, insideColorHeight);
    }

    private void drawHead(Graphics2D g2d, int x, int y, int headWidth, int headHeight, Color primaryColor, Color secondaryColor, Color eyeColor) {
        drawEars(g2d, x, y, headWidth, headHeight, primaryColor, secondaryColor);

        g2d.setColor(Color.BLACK);
        g2d.drawRoundRect(x, y, headWidth, headHeight, 120, 120);
        g2d.setColor(primaryColor);
        g2d.fillRoundRect(x, y, headWidth, headHeight, 120, 120);

        drawEyes(g2d, x, y, headWidth, headHeight, eyeColor);
    }

    private void drawEars(Graphics2D g2d,int x, int y, int headWidth, int headHeight, Color primaryColor, Color secondaryColor) {
        int[] leftEarX = { x + headWidth / 10,
                x + headWidth / 9,
                x + headWidth / 4 };
        int[] leftEarY = { y + headHeight / 4,
                y - headHeight / 8,
                y + headHeight / 14 };
        int[] rightEarX = { x + headWidth - headWidth / 10,
                x + headWidth - headWidth / 9,
                x + headWidth - headWidth / 4 };
        int[] rightEarY = { y + headHeight / 4,
                y - headHeight / 8,
                y + headHeight / 14 };

        drawEar(g2d, leftEarX, leftEarY, primaryColor, secondaryColor, -1);
        drawEar(g2d, rightEarX, rightEarY, primaryColor, secondaryColor, 1);
    }

    private void drawEar(Graphics2D g2d, int[] earX, int[] earY, Color primaryColor, Color secondaryColor, int side) {
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(earX, earY, 3);
        g2d.setColor(primaryColor);
        g2d.fillPolygon(earX, earY, 3);

        int n = 10;
        if (side == -1) {
            earX[0] += n - n / 3;
            earX[1] += n / 2;
            earX[2] -= n;
        } else if (side == 1) {
            earX[0] -= n - n / 3;
            earX[1] -= n / 2;
            earX[2] += n;
        }
        earY[1] += n;

        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(earX, earY, 3);
        g2d.setColor(secondaryColor);
        g2d.fillPolygon(earX, earY, 3);
    }

    private void drawEyes(Graphics2D g2d, int x, int y, int headWidth, int headHeight, Color eyeColor) {
        int eyeWidth = headHeight / 5;
        int eyeHeight = headHeight / 4;
        int rightEyeX = x + headWidth / 6;
        int leftEyeX = x + headWidth - headWidth / 6 - eyeWidth;
        int eyeY = y + headHeight / 3;

        drawEye(g2d, rightEyeX, eyeY, eyeWidth, eyeHeight, eyeColor);
        drawEye(g2d, leftEyeX, eyeY, eyeWidth, eyeHeight, eyeColor);
    }

    private void drawEye(Graphics2D g2d, int eyeX, int eyeY, int eyeWidth, int eyeHeight, Color eyeColor) {
        g2d.setColor(Color.BLACK);
        g2d.drawOval(eyeX, eyeY, eyeWidth, eyeHeight);
        g2d.setColor(eyeColor);
        g2d.fillOval(eyeX, eyeY, eyeWidth, eyeHeight);

        int pupilX = eyeX + eyeWidth / 4;
        int pupilY = eyeY + eyeHeight / 4;
        int pupilWidth = eyeWidth / 2;
        int pupilHeight = eyeHeight / 2;

        g2d.setColor(Color.BLACK);
        g2d.fillOval(pupilX, pupilY, pupilWidth, pupilHeight);
    }

}