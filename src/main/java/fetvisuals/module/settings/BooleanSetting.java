package fetvisuals.module.settings;
import com.google.gson.*; import fetvisuals.module.Setting;
public final class BooleanSetting extends Setting<Boolean>{ public BooleanSetting(String n,boolean v){super(n,v);} public void toggle(){value=!value;} public JsonElement toJson(){return new JsonPrimitive(value);} public void fromJson(JsonElement j){if(j!=null&&j.isJsonPrimitive())value=j.getAsBoolean();}}
