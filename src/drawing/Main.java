package drawing;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        int backgroundX = 0;
        int backgroundY = 0;
        int backgroundWidth = 800;
        int backgroundHeight = 600;
        Drawable background = new DrawBackground(backgroundX, backgroundY,
                backgroundWidth, backgroundHeight);
        DrawingPanel.addDrawable(background);

        int firstCatX = backgroundWidth / 2 - 135;
        int firstCatY = backgroundHeight / 2 - 112;
        int firstCatWidth = 1200;
        int firstCatHeight = 800;
        Color firstCatPrimaryColor = Color.BLACK;
        Color firstCatSecondaryColor = Color.WHITE;
        Color firstCatEyeColor = new Color(255, 215, 0);
        Drawable firstCat = new DrawCat(firstCatX, firstCatY,
                firstCatWidth, firstCatHeight,
                firstCatPrimaryColor, firstCatSecondaryColor, firstCatEyeColor);
        DrawingPanel.addDrawable(firstCat);

        new DrawingPanel();
    }

}