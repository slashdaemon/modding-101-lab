# Lab 003 · Client and server

**Concept.** The game is two programs: the client (your window, sound, keys) and the server (the world).
Singleplayer runs both in one game. A mod can have three entrypoints: `main` (everywhere), `client` (only a
player's game) and `server` (only a dedicated server). Client code lives in `src/client`, so code in
`src/main` can't reach client classes by accident: the build refuses to compile it.

**In game.** Start a world and read `logs/latest.log`:
- `[main] Lab 003 loaded…` and `[client] Lab 003 client code loaded…` while the game starts,
- `A server just started. Kind: integrated server (singleplayer)` when the world opens.
On a dedicated server the log shows `[main]`, `[server]` and `Kind: dedicated server`, and never `[client]`.

**Notes.**
- `splitEnvironmentSourceSets()` in `build.gradle` is what makes `src/client` a separate folder. Lab 004
  turns it off to show what it protects you from.
- Entrypoints run very early: the client entrypoint runs before the game window exists, so
  `getWindow()` there returns null (the first draft of this drop crashed exactly so; the check caught it).
  Code that needs the window waits for `ClientLifecycleEvents.CLIENT_STARTED`.
- The integrated server in singleplayer is a real server: `[main]` code that listens for server events runs
  there too. That's why Lab 002's greeting works in singleplayer.

**Change it.** Make the client log the player's name once they join a world.
(Hint: `ClientPlayConnectionEvents.JOIN`, in `src/client`.)

**Solution** (opens Lab 004). In `SidesClient.onInitializeClient`, with
`import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;`:

```java
ClientPlayConnectionEvents.JOIN.register((handler, sender, client) ->
        SidesMod.LOGGER.info("[client] Joined as {}", client.getUser().getName()));
```
