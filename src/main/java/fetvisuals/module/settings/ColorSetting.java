package fetvisuals.module.settings;
import com.google.gson.*; import fetvisuals.module.Setting;
public final class ColorSetting extends Setting<Integer>{public ColorSetting(String n,int v){super(n,v);} public JsonElement toJson(){return new JsonPrimitive(value);} public void fromJson(JsonElement j){if(j!=null&&j.isJsonPrimitive())value=j.getAsInt();}}
