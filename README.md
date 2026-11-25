# Modding 101 Lab

Small, complete Minecraft mods, one idea each, from The Block Academy's **Modding 101** course. Every Lab is a mod
you can run tonight: read it, change one thing, run it again.

- **Minecraft 1.21.1 with Fabric**, written in Java with Mojang's official names.
- New Labs are added here as their lessons come out.

## Start here

New to this? **[Lab 000 · Setup](setup/LAB-000.md)** gets IntelliJ IDEA installed and a Lab running on Windows or
a Mac. You don't need to install Java yourself.

## The Labs

| Lab | What it teaches |
|---|---|
| [Lab 000 · Setup](setup/LAB-000.md) | Install IntelliJ IDEA and open a Lab |
| [Lab 001 · Hello](drops/001-hello) | Entrypoint and fabric.mod.json |
| [Lab 002 · Greeter](drops/002-greeter) | Server events (player join) |

## Using a Lab

Each folder in `drops/` is a complete project on its own. Open the folder in IntelliJ IDEA and run
**Minecraft Client**, or from a terminal inside it:

```bash
./gradlew runClient    # start Minecraft with the Lab's mod (Windows: gradlew runClient)
./gradlew build        # the mod's jar lands in build/libs/
```

Each Lab's README says what to look for in game, and ends with a small change to try yourself. Its answer opens
the next Lab.

## Licence

MIT: use the code in your own mods. See [LICENSE](LICENSE).
