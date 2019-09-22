package Home_tasks.Home_task_1;

import java.awt.Graphics;

public class Sprite {
    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;

    public Sprite() {
    }

    protected float getLeft() {
        return this.x - this.halfWidth;
    }

    protected void setLeft(float left) {
        this.x = left + this.halfWidth;
    }

    protected float getRight() {
        return this.x + this.halfWidth;
    }

    protected void setRight(float right) {
        this.x = right - this.halfWidth;
    }

    protected float getTop() {
        return this.y - this.halfHeight;
    }

    protected void setTop(float top) {
        this.y = top + this.halfHeight;
    }

    protected float getBottom() {
        return this.y + this.halfHeight;
    }

    protected void setBottom(float bottom) {
        this.y = bottom - this.halfHeight;
    }

    protected float getWidth() {
        return 2.0F * this.halfWidth;
    }

    protected float getHeight() {
        return 2.0F * this.halfHeight;
    }

    void update(GameCanvas canvas, float deltaTime) {
    }

    void render(GameCanvas canvas, Graphics g) {
    }
}
