package com.kalyan.MonkeyBananaGame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GrassField {

    public BufferedImage getGrassImage() {
        URL bananaResource = getClass().getResource("/media/grass.png");
        BufferedImage grassImage = null;
        try {
            grassImage = ImageIO.read(bananaResource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grassImage;
    }
}
