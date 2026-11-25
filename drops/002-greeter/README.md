# Lab 002 · Greeter

**Concept.** Events: the game (through Fabric API) tells your mod when something happens, and your mod
registers a listener. Here, `ServerPlayConnectionEvents.JOIN` fires on the server for each player who joins.

**In game.** Open any world (or join a server running the mod): chat says *Welcome to the Lab, <you>!*
with your name in green.

**Notes.**
- First drop that needs Fabric API (`"fabric-api": "*"` in `fabric.mod.json`).
- The listener runs on the *server*, even in singleplayer (Lesson 1: singleplayer runs a server inside
  your game). Lab 003 makes that visible.
- `Component` is how Minecraft represents text: pieces you can style and join. `Component.literal` is fixed
  text; Lab 012 introduces translatable text.

**Change it.** Greet players differently the very first time they join a world.

_The solution opens the next Lab._
