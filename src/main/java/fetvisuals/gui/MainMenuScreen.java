package fetvisuals.gui;

import fetvisuals.FetVisuals;
import fetvisuals.render.FontRenderer;
import fetvisuals.render.RenderUtils;
import fetvisuals.theme.Theme;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.text.Text;
import java.util.*;

public final class MainMenuScreen extends Screen {
    private final long opened=System.currentTimeMillis();
    private final List<Action> actions=new ArrayList<>();
    private record Action(String label,int x,int y,int w,int h,Runnable run){}
    public MainMenuScreen(){super(Text.literal("FetVisuals"));}
    @Override protected void init(){rebuild();}
    private void rebuild(){actions.clear();int w=220;int h=34;int x=width/2-w/2;int y=height/2-58;add("SinglePlayer",x,y,w,h,()->client.setScreen(new SelectWorldScreen(this)));add("MultiPlayer",x,y+40,w,h,()->client.setScreen(new MultiplayerScreen(this)));add("Accounts",x,y+80,w,h,()->client.setScreen(new AccountsScreen(this)));add("Settings",x,y+120,165,h,()->client.setScreen(new OptionsScreen(this,client.options)));add("Exit",x+173,y+120,47,h,()->client.stop());}
    private void add(String s,int x,int y,int w,int h,Runnable r){actions.add(new Action(s,x,y,w,h,r));}
    @Override public void render(DrawContext c,int mouseX,int mouseY,float delta){Theme t=FetVisuals.THEMES.current();long age=System.currentTimeMillis()-opened;float fade=Math.min(1f,age/550f);c.fill(0,0,width,height,RenderUtils.alpha(t.background(),(int)(255*fade)));int glow=RenderUtils.alpha(t.primary(),18);c.fill(width/2-360,height/2-240,width/2+360,height/2+240,glow);int titleY=height/2-132;FontRenderer.draw(c,"FetVisuals",width/2-FontRenderer.width("FetVisuals")/2,titleY,t.text());FontRenderer.draw(c,FetVisuals.VERSION,width/2-FontRenderer.width(FetVisuals.VERSION)/2,titleY+22,0xFF77737F);for(Action a:actions){boolean hover=mouseX>=a.x&&mouseX<=a.x+a.w&&mouseY>=a.y&&mouseY<=a.y+a.h;int bg=hover?RenderUtils.lerpColor(t.panel(),t.primary(),.20f):t.panel();RenderUtils.rounded(c,a.x,a.y,a.w,a.h,9,bg);if(hover)RenderUtils.outline(c,a.x,a.y,a.w,a.h,RenderUtils.alpha(t.accent(),90));FontRenderer.draw(c,a.label,a.x+(a.w-FontRenderer.width(a.label))/2,a.y+10,hover?t.text():0xFFD1CDD8);}int sy=height/2+112;String[] social={"D","T","Y"};for(int i=0;i<3;i++){int sx=width/2-40+i*40;RenderUtils.rounded(c,sx,sy,26,22,7,RenderUtils.alpha(t.panel(),180));FontRenderer.draw(c,social[i],sx+9,sy+5,0xFF8C8795);}String foot="© FetVisuals 2026  •  All Rights Reserved";FontRenderer.draw(c,foot,width/2-FontRenderer.width(foot)/2,height-28,0xFF55515C);}
    @Override public boolean mouseClicked(double mx,double my,int button){if(button==0)for(Action a:actions)if(mx>=a.x&&mx<=a.x+a.w&&my>=a.y&&my<=a.y+a.h){a.run().run();return true;}return super.mouseClicked(mx,my,button);}
    @Override public boolean shouldPause(){return false;}
}
