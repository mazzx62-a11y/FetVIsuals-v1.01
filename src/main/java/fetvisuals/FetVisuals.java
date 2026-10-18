package fetvisuals;

import fetvisuals.command.FetCommand;
import fetvisuals.config.ConfigManager;
import fetvisuals.event.EventBus;
import fetvisuals.gui.ClickGuiScreen;
import fetvisuals.input.KeybindManager;
import fetvisuals.module.ModuleManager;
import fetvisuals.notification.NotificationManager;
import fetvisuals.theme.ThemeManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public final class FetVisuals implements ClientModInitializer {
    public static final String NAME = "FetVisuals";
    public static final String VERSION = "1.21.4";
    public static ModuleManager MODULES;
    public static ConfigManager CONFIG;
    public static NotificationManager NOTIFICATIONS;
    public static ThemeManager THEMES;
    public static EventBus EVENTS;
    private static KeyBinding clickGuiKey;

    @Override
    public void onInitializeClient() {
        EVENTS = new EventBus();
        THEMES = new ThemeManager();
        CONFIG = new ConfigManager();
        NOTIFICATIONS = new NotificationManager();
        MODULES = new ModuleManager();
        MODULES.registerDefaults();
        CONFIG.load("default");

        clickGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.fetvisuals.clickgui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_SHIFT, "category.fetvisuals"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (clickGuiKey.wasPressed()) {
                if (client.currentScreen == null) client.setScreen(new ClickGuiScreen());
                else if (client.currentScreen instanceof ClickGuiScreen) client.setScreen(null);
            }
            MODULES.tick();
            NOTIFICATIONS.tick();
        });

        HudRenderCallback.EVENT.register((context, tickDelta) -> { MODULES.hud(context, tickDelta); NOTIFICATIONS.tick(); });
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> FetCommand.register(dispatcher));
        ClientLifecycleEvents.CLIENT_STOPPING.register(client -> CONFIG.save("autosave"));
    }
}
