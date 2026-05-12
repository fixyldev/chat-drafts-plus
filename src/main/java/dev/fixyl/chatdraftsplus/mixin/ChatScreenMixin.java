package dev.fixyl.chatdraftsplus.mixin;

import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.ChatScreen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ChatScreen.class)
public abstract class ChatScreenMixin {

    @Shadow
    private EditBox input;

    @Shadow
    private boolean isDraft;

    @Inject(method = "init()V", at = @At(value = "TAIL"))
    private void init(CallbackInfo callback) {
        if (this.isDraft) {
            this.isDraft = false;

            this.input.moveCursorToStart(false);
            this.input.moveCursorToEnd(true);
        }
    }
}
