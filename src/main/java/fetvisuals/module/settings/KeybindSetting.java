package fetvisuals.module.settings;
import com.google.gson.*; import fetvisuals.module.Setting;
public final class KeybindSetting extends Setting<Integer>{public KeybindSetting(String n,int v){super(n,v);} public JsonElement toJson(){return new JsonPrimitive(value);} public void fromJson(JsonElement j){if(j!=null&&j.isJsonPrimitive())value=j.getAsInt();}}
