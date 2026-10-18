package fetvisuals.modules.hud;
import fetvisuals.module.*; import fetvisuals.render.FontRenderer; import net.minecraft.client.MinecraftClient; import net.minecraft.client.gui.DrawContext;
public final class Coordinates extends fetvisuals.module.Module {public Coordinates(){super("Coordinates","Player XYZ",Category.HUD);}public void onHud(DrawContext c,float d){MinecraftClient mc=MinecraftClient.getInstance();if(mc.player==null)return;String s=String.format("XYZ  %d %d %d",mc.player.getBlockX(),mc.player.getBlockY(),mc.player.getBlockZ());FontRenderer.draw(c,s,8,22,0xFFD0CCD8);}}
