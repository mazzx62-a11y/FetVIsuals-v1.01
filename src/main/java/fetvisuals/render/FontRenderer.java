package fetvisuals.render;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
public final class FontRenderer {
    public static void draw(DrawContext c,String text,float x,float y,int color){RenderUtils.text(c,MinecraftClient.getInstance().textRenderer,text,x,y,color);}
    public static int width(String text){return MinecraftClient.getInstance().textRenderer.getWidth(text);}
}
