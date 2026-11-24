package com.larp.visuals.gui.renderer;

import net.minecraft.client.gui.DrawContext;

public class GuiRenderer {
    
    public void renderMainPanel(DrawContext context, int screenWidth, int screenHeight, 
                               float progress, float scale, int color) {
        int panelSize = (int)(400 * scale);
        int centerX = screenWidth / 2;
        int centerY = screenHeight / 2;
        
        int x = centerX - panelSize / 2;
        int y = centerY - panelSize / 2;
        
        float animProgress = easeOutCubic(progress);
        int alpha = (int)(255 * animProgress);
        
        int colorWithAlpha = (alpha << 24) | (color & 0xFFFFFF);
        
        fillRoundedRect(context, x, y, x + panelSize, y + panelSize, 12, colorWithAlpha);
        drawBorder(context, x, y, x + panelSize, y + panelSize, 2, 0xFFFFFFFF, 12);
    }
    
    public void renderCategory(DrawContext context, int x, int y, String name, 
                              boolean selected, float progress) {
        int bgColor = selected ? 0xFF6B5B95 : 0xFF2A2A2A;
        int alpha = (int)(255 * easeOutCubic(progress));
        int colorWithAlpha = (alpha << 24) | (bgColor & 0xFFFFFF);
        
        fillRoundedRect(context, x, y, x + 160, y + 40, 8, colorWithAlpha);
    }
    
    private void fillRoundedRect(DrawContext context, int x1, int y1, int x2, int y2, 
                                 int radius, int color) {
        context.fill(x1 + radius, y1, x2 - radius, y2, color);
        context.fill(x1, y1 + radius, x2, y2 - radius, color);
    }
    
    private void drawBorder(DrawContext context, int x1, int y1, int x2, int y2, 
                           int thickness, int color, int radius) {
        for (int i = 0; i < thickness; i++) {
            context.drawHorizontalLine(x1 + radius, x2 - radius, y1 + i, color);
            context.drawHorizontalLine(x1 + radius, x2 - radius, y2 - i, color);
            context.drawVerticalLine(x1 + i, y1 + radius, y2 - radius, color);
            context.drawVerticalLine(x2 - i, y1 + radius, y2 - radius, color);
        }
    }
    
    private float easeOutCubic(float progress) {
        float t = progress;
        return 1 - (1 - t) * (1 - t) * (1 - t);
    }
}