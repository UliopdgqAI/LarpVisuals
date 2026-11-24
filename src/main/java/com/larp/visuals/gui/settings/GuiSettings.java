package com.larp.visuals.gui.settings;

import com.larp.visuals.gui.animation.AnimationType;

public class GuiSettings {
    private float scale = 1.0f;
    private int color = 0xFF1A1A1A;
    private AnimationType animationType = AnimationType.SCALE;
    
    public float getScale() {
        return scale;
    }
    
    public void setScale(float scale) {
        this.scale = Math.max(0.5f, Math.min(2.0f, scale));
    }
    
    public int getColor() {
        return color;
    }
    
    public void setColor(int color) {
        this.color = color;
    }
    
    public AnimationType getAnimationType() {
        return animationType;
    }
    
    public void setAnimationType(AnimationType type) {
        this.animationType = type;
    }
}