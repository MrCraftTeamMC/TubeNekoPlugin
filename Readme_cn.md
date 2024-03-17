# TubeNekoPlugin

![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/MrCraftTeamMC/TubeNekoPlugin/ci.yml)
![GitHub Downloads (all assets, all releases)](https://img.shields.io/github/downloads/MrCraftTeamMC/TubeNekoPlugin/total)
![GitHub Release](https://img.shields.io/github/v/release/MrCraftTeamMC/TubeNekoPlugin)

[English](./Readme.md) | 中文

## Introduction
A Bukkit Plugin provides some mess features for Minecraft Servers. Used by TubeCraft.

| Loader type     | Minecraft version | Support release | Dependencies                       | Status |
|-----------------|-------------------|-----------------|------------------------------------|--------|
| Fabric / Quilt  | 1.16+             | 1.0.0-02+       | Architectury Api, Fabric Api / QSL | ✅      |
| Forge           | 1.16+             | 1.0.0-02+       | Architectury Api                   | ✅      |
| NeoForge        | 1.20.2+           | 1.0.0-02+       | Architectury Api                   | ✅      |
| Bukkit (Spigot) | 1.8+              | 1.0.0-01+       | -                                  | ✅      |
| Sponge          | 1.12+             | 1.0.0-02 Only   | -                                  | ❌      |
| BungeeCord      | -                 | 1.0.0-02+       | -                                  | 🛠️    |
| Velocity        | -                 | 1.0.0-02+       | -                                  | 🛠️    |

For more details, please see the wiki page.

## Download
Check the `Release` page in the repository.

## Contribution
If you are player, you can commit issues for bugs, enhancements and so on.

For developers, forking this repository and committing PR are welcome.

### Compilation
Please use [Intellij IDEA](https://www.jetbrains.com/idea) and Java 17+ to build.

1. Download the Zip of the repository.
2. Unzip it.
3. Execute the commands here in project root directory:
```shell
# For OSX / Linux

./gradlew clean build --stacktrace --no-daemon
```

```bat
rem For Windows

.\gradlew.bat clean build --stacktrace --no-daemon
```

Then you can find the jar in `build/libs` dir.

## License
This project is under [GNU General Public License v3](./LICENSE).
