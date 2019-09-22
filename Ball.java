package Home_tasks.Home_task_1;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Sprite {
    private float vx = 150.0F + (float)(Math.random() * 200.0D);
    private float vy = 150.0F + (float)(Math.random() * 200.0D);
    private final Color color = new Color((int)(Math.random() * 255.0D), (int)(Math.random() * 255.0D), (int)(Math.random() * 255.0D));

    Ball() {
        this.halfHeight = 20.0F + (float)(Math.random() * 50.0D);
        this.halfWidth = this.halfHeight;
    }

    void update(GameCanvas canvas, float deltaTime) {
        this.x += this.vx * deltaTime;
        this.y += this.vy * deltaTime;
        if (this.getLeft() < (float)canvas.getLeft()) {
            this.setLeft((float)canvas.getLeft());
            this.vx = -this.vx;
        }

        if (this.getRight() > (float)canvas.getRight()) {
            this.setRight((float)canvas.getRight());
            this.vx = -this.vx;
        }

        if (this.getTop() < (float)canvas.getTop()) {
            this.setTop((float)canvas.getTop());
            this.vy = -this.vy;
        }

        if (this.getBottom() > (float)canvas.getBottom()) {
            this.setBottom((float)canvas.getBottom());
            this.vy = -this.vy;
        }

    }

    void render(GameCanvas canvas, Graphics g) {
        g.setColor(this.color);
        g.fillOval((int)this.getLeft(), (int)this.getTop(), (int)this.getWidth(), (int)this.getHeight());
    }
}
