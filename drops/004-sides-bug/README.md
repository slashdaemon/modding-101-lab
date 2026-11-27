# Lab 004 · Bug hunt: the side that crashed

**Concept.** A bug hunt. The mod works in singleplayer and crashes a dedicated server at startup. Students
find why, from the server's log: the **Caused by** line, and the line under it that points at our own code.

**In game.** Singleplayer: starts fine. Look at what the log prints for the mod's message: that's a clue too.
Dedicated server: crashes before "Done".

**Change it.** Fix it so it runs on both sides. Then open this project's `gradle.properties`: one line in it is why
the build let this bug through.

_The solution opens the next Lab._
