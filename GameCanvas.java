package Home_tasks.Home_task_1;

import java.awt.Graphics;
import javax.swing.JPanel;

public class GameCanvas extends JPanel {
    private MainCircles gameWindow;
    private long lastFrameTime;

    GameCanvas(MainCircles gameWindow) {
        this.gameWindow = gameWindow;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float delta = (float)(currentTime - this.lastFrameTime) * 1.0E-9F;
        this.lastFrameTime = currentTime;

        try {
            Thread.sleep(17L);
        } catch (InterruptedException var6) {
            var6.printStackTrace();
        }

        this.gameWindow.onDrawPanel(this, g, delta);
        this.repaint();
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return this.getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return this.getHeight() - 1;
    }
}
