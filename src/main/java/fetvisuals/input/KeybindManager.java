package fetvisuals.input;
import fetvisuals.FetVisuals; import fetvisuals.module.Module; import net.minecraft.client.util.InputUtil;
public final class KeybindManager {public static void press(int key){for(Module m:FetVisuals.MODULES.all())if(m.keybind()==key)m.toggle();}public static String name(int key){if(key==InputUtil.UNKNOWN_KEY.getCode())return "None";return InputUtil.fromKeyCode(key,0).getLocalizedText().getString();}}
