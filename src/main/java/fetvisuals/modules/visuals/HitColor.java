package fetvisuals.modules.visuals;
import fetvisuals.module.*; import fetvisuals.module.settings.*;
public final class HitColor extends fetvisuals.module.Module {public final ColorSetting color=add(new ColorSetting("Color",0xFFB66DFF));public final NumberSetting alpha=add(new NumberSetting("Alpha",1,0,1,.01));public HitColor(){super("HitColor","Accent used by hit visuals",Category.VISUALS);}}
