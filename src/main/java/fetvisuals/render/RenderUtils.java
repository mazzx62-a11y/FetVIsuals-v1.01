package fetvisuals.render;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.font.TextRenderer;

public final class RenderUtils {
    private RenderUtils(){}
    public static void rect(DrawContext c,int x,int y,int w,int h,int color){c.fill(x,y,x+w,y+h,color);}
    public static void rounded(DrawContext c,int x,int y,int w,int h,int r,int color){
        c.fill(x+r,y,x+w-r,y+h,color); c.fill(x,y+r,x+w,y+h-r,color);
        c.fill(x,y+r,x+r,y+h-r,color); c.fill(x+w-r,y+r,x+w,y+h-r,color);
        c.fill(x+r,y,x+w-r,y+r,color); c.fill(x+r,y+h-r,x+w-r,y+h,color);
    }
    public static void outline(DrawContext c,int x,int y,int w,int h,int color){rect(c,x,y,w,1,color);rect(c,x,y+h-1,w,1,color);rect(c,x,y,1,h,color);rect(c,x+w-1,y,1,h,color);}
    public static int alpha(int rgb,int a){return (a<<24)|(rgb&0xFFFFFF);}
    public static int lerpColor(int a,int b,float t){t=Math.max(0,Math.min(1,t));int aa=(a>>>24)&255,ar=(a>>>16)&255,ag=(a>>>8)&255,ab=a&255;int ba=(b>>>24)&255,br=(b>>>16)&255,bg=(b>>>8)&255,bb=b&255;return ((int)(aa+(ba-aa)*t)<<24)|((int)(ar+(br-ar)*t)<<16)|((int)(ag+(bg-ag)*t)<<8)|(int)(ab+(bb-ab)*t);}
    public static void text(DrawContext c,TextRenderer tr,String s,float x,float y,int color){c.drawTextWithShadow(tr,s,(int)x,(int)y,color);}
}
