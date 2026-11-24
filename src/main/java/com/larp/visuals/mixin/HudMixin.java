package com.larp.visuals.mixin;

import com.larp.visuals.gui.ClickGuiManager;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.callback.CallbackInfo;
import net.minecraft.client.gui.DrawContext;

@Mixin(InGameHud.class)
public class HudMixin {
    
    @Inject(method = "render", at = @At("TAIL"))
    private void onRender(DrawContext drawContext, float tickDelta, CallbackInfo ci) {
        ClickGuiManager.getInstance().render(drawContext, 0, 0, tickDelta);
    }
}