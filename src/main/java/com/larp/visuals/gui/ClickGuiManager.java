package com.larp.visuals.gui;

import com.larp.visuals.gui.animation.AnimationType;
import com.larp.visuals.gui.animation.GuiAnimation;
import com.larp.visuals.gui.renderer.GuiRenderer;
import com.larp.visuals.gui.renderer.FontRenderer;
import com.larp.visuals.gui.settings.GuiSettings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class ClickGuiManager {
    private static ClickGuiManager INSTANCE;
    
    private boolean isOpen = false;
    private GuiAnimation currentAnimation;
    private GuiSettings guiSettings;
    private GuiRenderer guiRenderer;
    private FontRenderer fontRenderer;
    
    private ClickGuiPanel[] panels;
    private int currentPanelIndex = 0;
    
    public ClickGuiManager() {
        this.guiSettings = new GuiSettings();
        this.guiRenderer = new GuiRenderer();
        this.fontRenderer = new FontRenderer();
        this.currentAnimation = new GuiAnimation(AnimationType.SCALE);
        initializePanels();
    }
    
    private void initializePanels() {
        panels = new ClickGuiPanel[]{
            new ClickGuiPanel("Combat", 0xFF6B5B95),
            new ClickGuiPanel("Visuals", 0xFF88B0D3),
            new ClickGuiPanel("Player", 0xFF90BE6D),
            new ClickGuiPanel("Misc", 0xFFFFA502)
        };
    }
    
    public void toggleGui() {
        isOpen = !isOpen;
        if (isOpen) {
            currentAnimation.start();
        } else {
            currentAnimation.reverse();
        }
    }
    
    public void render(DrawContext context, int mouseX, int mouseY, float partialTicks) {
        if (!isOpen) return;
        
        int screenWidth = MinecraftClient.getInstance().getWindow().getWidth();
        int screenHeight = MinecraftClient.getInstance().getWindow().getHeight();
        
        currentAnimation.update();
        float progress = currentAnimation.getProgress();
        
        guiRenderer.renderMainPanel(context, screenWidth, screenHeight, progress, 
                                   guiSettings.getScale(), guiSettings.getColor());
        
        renderCategories(context, screenWidth, screenHeight, progress);
        
        if (currentPanelIndex < panels.length) {
            panels[currentPanelIndex].render(context, guiRenderer, fontRenderer, progress);
        }
    }
    
    private void renderCategories(DrawContext context, int screenWidth, int screenHeight, float progress) {
        int centerX = screenWidth / 2;
        int centerY = screenHeight / 2;
        int panelSize = (int)(400 * guiSettings.getScale());
        int topY = centerY - panelSize / 2;
        
        for (int i = 0; i < panels.length; i++) {
            int categoryY = topY + 30 + (i * 50);
            boolean isSelected = i == currentPanelIndex;
            
            guiRenderer.renderCategory(context, centerX - panelSize / 2 + 20, categoryY, 
                                      panels[i].getName(), isSelected, progress);
        }
    }
    
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (!isOpen) return;
        
        int screenWidth = MinecraftClient.getInstance().getWindow().getWidth();
        int screenHeight = MinecraftClient.getInstance().getWindow().getHeight();
        int centerX = screenWidth / 2;
        int centerY = screenHeight / 2;
        int panelSize = (int)(400 * guiSettings.getScale());
        int topY = centerY - panelSize / 2;
        
        for (int i = 0; i < panels.length; i++) {
            int categoryY = topY + 30 + (i * 50);
            if (mouseX >= centerX - panelSize / 2 + 20 && mouseX <= centerX - panelSize / 2 + 200 &&
                mouseY >= categoryY && mouseY <= categoryY + 40) {
                currentPanelIndex = i;
                break;
            }
        }
    }
    
    public boolean isOpen() {
        return isOpen;
    }
    
    public GuiSettings getSettings() {
        return guiSettings;
    }
    
    public static ClickGuiManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClickGuiManager();
        }
        return INSTANCE;
    }
}