package com.larp.visuals.gui;

import com.larp.visuals.gui.renderer.GuiRenderer;
import com.larp.visuals.gui.renderer.FontRenderer;
import net.minecraft.client.gui.DrawContext;

public class ClickGuiPanel {
    private String name;
    private int color;
    
    public ClickGuiPanel(String name, int color) {
        this.name = name;
        this.color = color;
    }
    
    public void render(DrawContext context, GuiRenderer renderer, FontRenderer fontRenderer, float progress) {
        // Will be overridden in subclasses
    }
    
    public String getName() {
        return name;
    }
    
    public int getColor() {
        return color;
    }
}