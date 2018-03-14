import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

class hangmanPaint extends JPanel {

    public hangmanPaint() {
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(10.0F));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawLine(320, 10, 320, 260);
        g2.drawLine(320, 10, 445, 10);
        g2.drawLine(300, 260, 470, 260);
        g2.setStroke(new BasicStroke(7.0F));
        g2.drawLine(320, 200, 400, 260);
        g2.fillOval(370, 60, 30, 30);
        g2.drawLine(385, 70, 385, 135);
        g2.drawLine(385, 135, 390, 145);
        g2.drawLine(385, 135, 380, 145);
        g2.drawLine(370, 100, 400, 100);
        g2.setStroke(new BasicStroke(3.0F));
        g2.drawLine(385, 10, 385, 135);
    }
}
