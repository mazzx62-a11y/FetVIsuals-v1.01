package fetvisuals.module;

import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import fetvisuals.FetVisuals;
import java.util.*;
import net.minecraft.client.gui.DrawContext;

public abstract class Module {
    private final String name, description;
    private final Category category;
    private boolean enabled;
    private int keybind;
    private final List<Setting<?>> settings = new ArrayList<>();
    protected Module(String name,String description,Category category){this.name=name;this.description=description;this.category=category;}
    public final String name(){return name;} public final String description(){return description;} public final Category category(){return category;}
    public final boolean enabled(){return enabled;} public final int keybind(){return keybind;} public final List<Setting<?>> settings(){return settings;}
    protected final <T extends Setting<?>> T add(T setting){settings.add(setting);return setting;}
    public final void toggle(){setEnabled(!enabled);}
    public final void setEnabled(boolean value){if(enabled==value)return;enabled=value;if(enabled)onEnable();else onDisable(); if(FetVisuals.NOTIFICATIONS!=null)FetVisuals.NOTIFICATIONS.push(name+(enabled?" enabled":" disabled"),enabled?0xFFB889FF:0xFF8B8795);}
    public void setKeybind(int key){keybind=key;}
    protected void onEnable(){} protected void onDisable(){} public void onTick(){} public void onHud(DrawContext context,float tickDelta){ }
    public JsonObject toJson(){JsonObject o=new JsonObject();o.addProperty("enabled",enabled);o.addProperty("keybind",keybind);JsonObject s=new JsonObject();for(Setting<?> x:settings)s.add(x.name(),x.toJson());o.add("settings",s);return o;}
    public void fromJson(JsonObject o){if(o==null)return;setKeybind(o.has("keybind")?o.get("keybind").getAsInt():keybind);JsonElement en=o.get("enabled");if(en!=null)setEnabled(en.getAsBoolean());JsonObject s=o.has("settings")&&o.get("settings").isJsonObject()?o.getAsJsonObject("settings"):new JsonObject();for(Setting<?> x:settings)if(s.has(x.name()))x.fromJson(s.get(x.name()));}
}
