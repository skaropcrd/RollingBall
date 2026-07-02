package Lib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RollingBall extends JPanel implements ActionListener {

    private int ballX;
    private int ballY;
    private final int diameter = 100;
    private final int radius = diameter / 2;
    
    private double angle = 0;
    private final Timer timer;

    public RollingBall() {
        ballX = 150 - radius;
        ballY = 150 - radius;

        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (ballY == 150 - radius && getHeight() > 0) {
            ballY = (getHeight() / 2) - radius;
        }

        g2d.translate(ballX + radius, ballY + radius);
        g2d.rotate(angle);

        g2d.setColor(Color.WHITE);
        g2d.fillOval(-radius, -radius, diameter, diameter);
        
        g2d.setColor(Color.BLACK);
        g2d.fillArc(-radius, -radius, diameter, diameter, 180, 180);
        
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.drawOval(-radius, -radius, diameter, diameter);
        g2d.drawLine(-radius, 0, radius, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ballX -= 2; 
        angle -= (2.0 / radius); 

        if (ballX + diameter < 0) {
            ballX = getWidth();
        }

        repaint();
    }
}