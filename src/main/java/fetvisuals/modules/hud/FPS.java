package fetvisuals.modules.hud;
import fetvisuals.module.*; import fetvisuals.module.settings.*; import fetvisuals.render.FontRenderer; import net.minecraft.client.MinecraftClient; import net.minecraft.client.gui.DrawContext;
public final class FPS extends fetvisuals.module.Module {private final NumberSetting scale=add(new NumberSetting("Scale",1,0.5,2,0.05));public FPS(){super("FPS","Frames per second",Category.HUD);}public void onHud(DrawContext c,float d){String s="FPS  "+MinecraftClient.getInstance().getCurrentFps();FontRenderer.draw(c,s,8,8,0xFFEAE7F2);}}
