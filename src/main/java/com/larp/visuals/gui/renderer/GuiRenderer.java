package com.larp.visuals.gui.renderer;

import com.larp.visuals.gui.util.RenderUtil;
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
        
        RenderUtil.fillRoundedRect(context, x, y, x + panelSize, y + panelSize, 
                                  12, colorWithAlpha);
        
        RenderUtil.drawBorder(context, x, y, x + panelSize, y + panelSize, 
                             2, 0xFFFFFFFF, 12);
    }
    
    public void renderCategory(DrawContext context, int x, int y, String name, 
                              boolean selected, float progress) {
        int bgColor = selected ? 0xFF6B5B95 : 0xFF2A2A2A;
        int alpha = (int)(255 * easeOutCubic(progress));
        int colorWithAlpha = (alpha << 24) | (bgColor & 0xFFFFFF);
        
        RenderUtil.fillRoundedRect(context, x, y, x + 160, y + 40, 8, colorWithAlpha);
    }
    
    private float easeOutCubic(float progress) {
        float t = progress;
        return 1 - (1 - t) * (1 - t) * (1 - t);
    }
}