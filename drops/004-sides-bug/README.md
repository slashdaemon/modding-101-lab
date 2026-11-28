# Lab 004 · Bug hunt: the side that crashed

**Concept.** A bug hunt. The mod works in singleplayer and crashes a dedicated server at startup. Students
find why, from the server's log: the **Caused by** line, and the line under it that points at our own code.

**In game.** Singleplayer: starts fine. Look at what the log prints for the mod's message: that's a clue too.
Dedicated server: crashes before "Done".

**Change it.** Fix it so it runs on both sides. Then open this project's `gradle.properties`: one line in it is why
the build let this bug through.

**Solution** (opens Lab 005):

```java
// Common code can't translate on its own: the server has no language files loaded.
LOGGER.info("Lab 004 loaded.");
// Text for players: send Component.translatable("m101_sides_bug.loaded") and let each client translate it.
```

**Why it crashed.** `I18n` (client-side translation) is a **client class**; it doesn't exist in the server jar, so
the server dies with `NoClassDefFoundError: net/minecraft/class_1074`. That odd name is the second lesson: a shipped
mod runs on Fabric's runtime ("intermediary") names, so the crash names `class_1074`, not `I18n` (Lesson 6:
obfuscation). The stack trace still points at our own line, `SidesBugMod.java:21`. In singleplayer the log shows the
raw key `m101_sides_bug.loaded`: translations aren't even loaded yet when mods initialise.

**Why the build let it through.** This drop's `gradle.properties` sets `split_sources=false`. With split source sets
(every other drop), `src/main` can't import `I18n` at all and the build fails: the compiler catches the bug before
anyone runs it. That's the lesson's punchline. The other fix, moving the message into a client entrypoint, also runs
on both; which one is right depends on whether the server needs the message.

**Notes.**
- The crash report's "Caused by" line names the missing class; Lab 007 practises reading reports.
- Beginners hit this constantly: client classes in common code are a top cause of "works in singleplayer,
  crashes the server" threads.
