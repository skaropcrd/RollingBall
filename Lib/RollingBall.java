package Lib;

import javax.swing.*;
import java.awt.*;

public class RollingBall extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int width = getWidth();
        int height = getHeight();
        int diameter = 100;
        int radius = diameter/2;
        
        int x = (width/2)-radius;
        int y = (height/2)-radius;
        
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x, y, diameter, diameter);
        
        g2d.setColor(Color.BLACK);
        g2d.fillArc(x, y, diameter, diameter, 0, 180);
        
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.drawOval(x, y, diameter, diameter);
        g2d.drawLine(x, y+radius, x+diameter, y+radius);
    }
}