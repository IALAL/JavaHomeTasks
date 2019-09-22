package Home_tasks.Home_task_1;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainCircles extends JFrame {
    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final int UPDATE_BACKGROUND_FREQUENCY = 3;
    private static final int SpritesNum = 10;
    private static float timer = 0;
    private static int BallsCount = 5;
    Color color = new Color((int) (Math.random() * 255.0D), (int) (Math.random() * 255.0D), (int) (Math.random() * 255.0D));
    Sprite[] sprites;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        this.sprites = new Sprite[SpritesNum];
        this.setDefaultCloseOperation(3);
        this.setBounds(600, 200, 800, 600);
        this.setTitle("Circles");
        GameCanvas gameCanvas = new GameCanvas(this);
        this.add(gameCanvas);
        this.initGame();
        this.setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MouseClick(e);
            }
        });
    }

    private void initGame() {
        for (int i = 0; i < BallsCount; ++i) {
            this.sprites[i] = new Ball();
        }

    }

    void onDrawPanel(GameCanvas canvas, Graphics g, float deltaTime) {
        this.update(canvas, deltaTime);
        this.render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < BallsCount; ++i) {
            this.sprites[i].update(canvas, deltaTime);
        }
        SetCanvasBackGroundforTime(canvas,deltaTime);

    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < BallsCount; ++i) {
            this.sprites[i].render(canvas, g);
        }

    }

    void SetCanvasBackGroundforTime(GameCanvas Canvas, float deltaTime) {
        this.timer += deltaTime;
        if (timer >= UPDATE_BACKGROUND_FREQUENCY ) {
            color = new Color((int) (Math.random() * 255.0D), (int) (Math.random() * 255.0D), (int) (Math.random() * 255.0D));
            Canvas.setBackground(color);
            this.timer = 0;
        }
    }

    void MouseClick(MouseEvent e){
//        switch (e.getButton()) {
//            case MouseEvent.BUTTON1:
                if (BallsCount < this.sprites.length) {
                    this.sprites[BallsCount] = new Ball();
                    BallsCount++;
                }
 //               break;
//        }
    }
}
