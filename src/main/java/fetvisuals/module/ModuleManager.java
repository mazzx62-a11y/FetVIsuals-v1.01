package fetvisuals.module;

import fetvisuals.modules.combat.ScreenPulse;
import fetvisuals.modules.effects.DamageVignette;
import fetvisuals.modules.effects.LowHealthVignette;
import fetvisuals.modules.hud.Coordinates;
import fetvisuals.modules.hud.FPS;
import fetvisuals.modules.hud.Keystrokes;
import fetvisuals.modules.hud.TargetHUD;
import fetvisuals.modules.visuals.CustomCrosshair;
import fetvisuals.modules.visuals.DynamicCrosshair;
import fetvisuals.modules.visuals.HitColor;
import fetvisuals.modules.visuals.TrajectoryPrediction;
import java.util.*;
import net.minecraft.client.gui.DrawContext;
import fetvisuals.FetVisuals;
import fetvisuals.render.FontRenderer;
import fetvisuals.render.RenderUtils;

public final class ModuleManager {
    private final List<Module> modules=new ArrayList<>();
    public void register(Module m){modules.add(m);}
    public void registerDefaults(){
        register(new ScreenPulse()); register(new HitColor());
        register(new FPS()); register(new Coordinates()); register(new Keystrokes()); register(new TargetHUD());
        register(new CustomCrosshair()); register(new DynamicCrosshair()); register(new TrajectoryPrediction());
        register(new LowHealthVignette()); register(new DamageVignette());
    }
    public List<Module> all(){return Collections.unmodifiableList(modules);}
    public List<Module> byCategory(Category c){return modules.stream().filter(m->m.category()==c).toList();}
    public Module get(String name){return modules.stream().filter(m->m.name().equalsIgnoreCase(name)).findFirst().orElse(null);}
    public void tick(){for(Module m:modules)if(m.enabled())m.onTick();}
    public void hud(DrawContext c,float delta){for(Module m:modules)if(m.enabled())m.onHud(c,delta);
        int y=c.getScaledWindowHeight()-20; for(var n:FetVisuals.NOTIFICATIONS.all()){int w=Math.min(300,FontRenderer.width(n.text)+28); int x=c.getScaledWindowWidth()-w-10; RenderUtils.rounded(c,x,y-24,w,22,7,0xE8181422); FontRenderer.draw(c,n.text,x+10,y-17,n.color); y-=28;} }
}
