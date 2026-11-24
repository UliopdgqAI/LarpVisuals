package com.larp.visuals.gui.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class FontRenderer {
    private TextRenderer textRenderer;
    
    public FontRenderer() {
        this.textRenderer = MinecraftClient.getInstance().textRenderer;
    }
    
    public void drawText(DrawContext context, String text, int x, int y, int color) {
        context.drawText(textRenderer, Text.literal(text), x, y, color, false);
    }
    
    public void drawCenteredText(DrawContext context, String text, int x, int y, int color) {
        int width = textRenderer.getWidth(text);
        context.drawText(textRenderer, Text.literal(text), x - width / 2, y, color, false);
    }
    
    public int getWidth(String text) {
        return textRenderer.getWidth(text);
    }
}