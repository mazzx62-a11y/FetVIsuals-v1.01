package fetvisuals.command;

import com.mojang.brigadier.CommandDispatcher;
import fetvisuals.FetVisuals;
import fetvisuals.module.Module;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.*;
import static com.mojang.brigadier.arguments.StringArgumentType.*;

public final class FetCommand {
    public static void register(CommandDispatcher<FabricClientCommandSource> d) {
        d.register(literal("fet")
            .then(literal("config")
                .then(literal("save").then(argument("name", word()).executes(c -> { FetVisuals.CONFIG.save(getString(c,"name")); return 1; })))
                .then(literal("load").then(argument("name", word()).executes(c -> { FetVisuals.CONFIG.load(getString(c,"name")); return 1; })))
                .then(literal("delete").then(argument("name", word()).executes(c -> FetVisuals.CONFIG.delete(getString(c,"name")) ? 1 : 0)))
                .then(literal("list").executes(c -> { c.getSource().sendFeedback(Text.literal(String.join(", ", FetVisuals.CONFIG.list()))); return 1; })))
            .then(literal("toggle").then(argument("module", word()).executes(c -> toggle(getString(c,"module"), null))))
            .then(literal("on").then(argument("module", word()).executes(c -> toggle(getString(c,"module"), true))))
            .then(literal("off").then(argument("module", word()).executes(c -> toggle(getString(c,"module"), false)))));
    }
    private static int toggle(String name, Boolean state) { Module m=FetVisuals.MODULES.get(name); if(m==null)return 0; if(state==null)m.toggle(); else m.setEnabled(state); return 1; }
}
