package fetvisuals.config;

import com.google.gson.*;
import fetvisuals.FetVisuals;
import fetvisuals.module.Module;
import net.fabricmc.loader.api.FabricLoader;
import java.io.*; import java.nio.file.*; import java.util.*;

public final class ConfigManager {
    private final Path root=FabricLoader.getInstance().getConfigDir().resolve("fetvisuals").resolve("configs");
    private final Gson gson=new GsonBuilder().setPrettyPrinting().create();
    public ConfigManager(){try{Files.createDirectories(root);}catch(IOException ignored){}}
    public void save(String name){try{Files.createDirectories(root);JsonObject o=new JsonObject();JsonObject ms=new JsonObject();for(Module m:FetVisuals.MODULES.all())ms.add(m.name(),m.toJson());o.add("modules",ms);Files.writeString(root.resolve(safe(name)+".json"),gson.toJson(o));if(FetVisuals.NOTIFICATIONS!=null)FetVisuals.NOTIFICATIONS.push("Config saved: "+name,0xFFB889FF);}catch(IOException e){}}
    public void load(String name){Path p=root.resolve(safe(name)+".json");if(!Files.exists(p)){if("default".equalsIgnoreCase(name))save("default");return;}try{JsonObject o=JsonParser.parseString(Files.readString(p)).getAsJsonObject();JsonObject ms=o.has("modules")?o.getAsJsonObject("modules"):new JsonObject();for(Module m:FetVisuals.MODULES.all())if(ms.has(m.name()))m.fromJson(ms.getAsJsonObject(m.name()));if(FetVisuals.NOTIFICATIONS!=null)FetVisuals.NOTIFICATIONS.push("Config loaded: "+name,0xFFB889FF);}catch(Exception ignored){}}
    public boolean delete(String name){try{return Files.deleteIfExists(root.resolve(safe(name)+".json"));}catch(IOException e){return false;}}
    public List<String> list(){try{return Files.list(root).filter(p->p.getFileName().toString().endsWith(".json")).map(p->p.getFileName().toString().replaceFirst("\\.json$","")).sorted().toList();}catch(IOException e){return List.of();}}
    public Path file(String name){return root.resolve(safe(name)+".json");}
    private String safe(String s){return s.replaceAll("[^a-zA-Z0-9._-]","_");}
}
