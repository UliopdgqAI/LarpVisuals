package com.larp.visuals.gui.util;

import net.minecraft.client.gui.DrawContext;

public class RenderUtil {
    
    public static void fillRoundedRect(DrawContext context, int x1, int y1, int x2, int y2, 
                                       int radius, int color) {
        int r = (color >> 16) & 255;
        int g = (color >> 8) & 255;
        int b = color & 255;
        int a = (color >> 24) & 255;
        
        context.fill(x1 + radius, y1, x2 - radius, y2, color);
        context.fill(x1, y1 + radius, x2, y2 - radius, color);
    }
    
    public static void drawBorder(DrawContext context, int x1, int y1, int x2, int y2, 
                                 int thickness, int color, int radius) {
        for (int i = 0; i < thickness; i++) {
            context.drawHorizontalLine(x1 + radius, x2 - radius, y1 + i, color);
            context.drawHorizontalLine(x1 + radius, x2 - radius, y2 - i, color);
            context.drawVerticalLine(x1 + i, y1 + radius, y2 - radius, color);
            context.drawVerticalLine(x2 - i, y1 + radius, y2 - radius, color);
        }
    }
}