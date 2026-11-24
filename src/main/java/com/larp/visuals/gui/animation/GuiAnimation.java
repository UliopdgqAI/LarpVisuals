package com.larp.visuals.gui.animation;

public class GuiAnimation {
    private AnimationType type;
    private float progress = 0f;
    private float speed = 0.08f;
    private boolean isForward = true;
    
    public GuiAnimation(AnimationType type) {
        this.type = type;
    }
    
    public void start() {
        isForward = true;
        progress = 0f;
    }
    
    public void reverse() {
        isForward = false;
    }
    
    public void update() {
        if (isForward) {
            progress = Math.min(1f, progress + speed);
        } else {
            progress = Math.max(0f, progress - speed);
        }
    }
    
    public float getProgress() {
        return progress;
    }
    
    public void setType(AnimationType type) {
        this.type = type;
    }
    
    public AnimationType getType() {
        return type;
    }
    
    public boolean isAnimating() {
        return progress > 0f && progress < 1f;
    }
}