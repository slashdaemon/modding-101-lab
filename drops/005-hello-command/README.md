# Lab 005 · Commands

**Concept.** Commands are a tree (Brigadier): a literal word (`m101`), then branches (`hello`, `announce`),
then arguments (`<name>`). Any node can `.executes(...)` code, and `.requires(...)` hides a branch from
anyone without permission.

**In game.** `/m101 hello` → *Hello, <you>!* · `/m101 hello Ada` → *Hello, Ada!* ·
`/m101 announce <message>` (operators, or singleplayer with cheats on) → *[Lab] <message>* to everyone.
Tab-completion shows the tree as you type.

**Notes.**
- First drop with GameTests (`src/gametest`): they start a real server, run the command the way a player
  would, and read the reply. `./gradlew runGametest` runs them. Lab 074 teaches them properly.
- Every Lab drop shares `/m101`: Brigadier merges literal nodes with the same name, so `/m101 hello`,
  `/m101 countdown` (Lab 006) and `/m101 crash` (Lab 007) all live under one root.
- Permission levels: 0 everyone, 2 command blocks and operators' cheats, 4 the server console.
- ⤴ 1.21.11 replaces `hasPermission(2)` with `permissions().hasPermission(Permissions.COMMANDS_GAMEMASTER)`.

**Change it.** Add `/m101 hello <name> <times>` that greets the name that many times (1 to 5).
(Hint: `IntegerArgumentType.integer(1, 5)`.)

_The solution opens the next Lab._
