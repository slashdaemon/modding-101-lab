# Lab 001 · Hello

**Concept.** A mod is a class the loader calls once while the game starts. `fabric.mod.json` tells Fabric
what the mod is called, what it needs, and which class to call (its *entrypoint*).

**In game.** Nothing visible yet: the line `Hello from Modding 101! Lab 001 is loaded.` in `logs/latest.log`
(the launcher's log window shows it too). With Mod Menu installed, the mod appears in the Mods list.

**Notes.**
- The one drop that doesn't need Fabric API: `fabric.mod.json` depends only on the loader, Minecraft and
  Java. Every later drop adds `"fabric-api": "*"`.
- The logger is named after the mod id, so the line is tagged `m101_hello` in the log.

**Change it (homework).** Log a second line with the Minecraft version you're running.

**Solution** (opens Lab 002):

```java
LOGGER.info("Running on Minecraft {}", SharedConstants.getCurrentVersion().getName());
```
