package mycar.swing.tools;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LoadImage extends JPanel {

    private Image img;

    private Image loadImage(String imagePath) {
        try {
            // 이미지를 클래스 패스에서 로드
            System.out.println(imagePath);
            System.out.println(getClass().getResource(imagePath));
            URL imageURL = getClass().getResource(imagePath);
            if (imageURL != null) {
                return ImageIO.read(imageURL);
            } else {
                System.err.println("Image not found: " + imagePath);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Image resizeImage(Image originalImage, int maxWidth, int maxHeight) {
        int newWidth = Math.min(originalImage.getWidth(null), maxWidth);
        int newHeight = Math.min(originalImage.getHeight(null), maxHeight);

        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight,
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g.dispose();

        return resizedImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 이미지를 중앙에 그리도록 좌표를 조정
        int x = (getWidth() - img.getWidth(null)) / 2;
        int y = (getHeight() - img.getHeight(null)) / 2;
        g.drawImage(img, x, y, null);
    }

    public LoadImage(String imagePath, int maxWidth, int maxHeight) {
        this.img = loadImage(imagePath);

        if (img.getWidth(null) > maxWidth || img.getHeight(null) > maxHeight) {
            this.img = resizeImage(img, maxWidth, maxHeight);
        }

        setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
    }
}
