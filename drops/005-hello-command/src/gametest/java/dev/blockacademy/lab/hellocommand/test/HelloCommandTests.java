package dev.blockacademy.lab.hellocommand.test;

import java.util.ArrayList;
import java.util.List;
import net.fabricmc.fabric.api.gametest.v1.FabricGameTest;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

/** Runs inside a real game server: the command is executed exactly as a player would type it. */
public class HelloCommandTests implements FabricGameTest {

    /** A command source that keeps every message it is sent, so the test can read them back. */
    private static final class Recorder implements CommandSource {
        final List<String> messages = new ArrayList<>();
        @Override public void sendSystemMessage(Component message) { messages.add(message.getString()); }
        @Override public boolean acceptsSuccess() { return true; }
        @Override public boolean acceptsFailure() { return true; }
        @Override public boolean shouldInformAdmins() { return false; }
    }

    private static CommandSourceStack source(ServerLevel level, Recorder recorder, int permission) {
        return new CommandSourceStack(recorder, Vec3.ZERO, Vec2.ZERO, level, permission, "Tester",
                Component.literal("Tester"), level.getServer(), null);
    }

    @GameTest(template = EMPTY_STRUCTURE)
    public void helloGreetsTheName(GameTestHelper helper) {
        Recorder recorder = new Recorder();
        helper.getLevel().getServer().getCommands()
                .performPrefixedCommand(source(helper.getLevel(), recorder, 0), "m101 hello Ada");
        helper.assertTrue(recorder.messages.contains("Hello, Ada!"), "got " + recorder.messages);
        helper.succeed();
    }

    @GameTest(template = EMPTY_STRUCTURE)
    public void helloWithoutANameGreetsTheSender(GameTestHelper helper) {
        Recorder recorder = new Recorder();
        helper.getLevel().getServer().getCommands()
                .performPrefixedCommand(source(helper.getLevel(), recorder, 0), "m101 hello");
        helper.assertTrue(recorder.messages.contains("Hello, Tester!"), "got " + recorder.messages);
        helper.succeed();
    }

    @GameTest(template = EMPTY_STRUCTURE)
    public void announceNeedsPermission(GameTestHelper helper) {
        Recorder recorder = new Recorder();
        helper.getLevel().getServer().getCommands()
                .performPrefixedCommand(source(helper.getLevel(), recorder, 0), "m101 announce hi");
        helper.assertFalse(recorder.messages.contains("Announced."), "a non-operator could announce");
        helper.succeed();
    }
}
