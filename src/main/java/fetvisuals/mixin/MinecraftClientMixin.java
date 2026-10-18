package fetvisuals.mixin;

import fetvisuals.gui.MainMenuScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    private static boolean fetvisuals$redirecting;

    @Inject(method = "setScreen", at = @At("HEAD"), cancellable = true)
    private void fetvisuals$replaceTitle(Screen screen, CallbackInfo ci) {
        if (!fetvisuals$redirecting && screen instanceof TitleScreen) {
            fetvisuals$redirecting = true;
            try {
                ((MinecraftClient)(Object)this).setScreen(new MainMenuScreen());
                ci.cancel();
            } finally {
                fetvisuals$redirecting = false;
            }
        }
    }
}
