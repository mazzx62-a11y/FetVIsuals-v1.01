# FetVisuals — Minecraft Java 1.21.4

Independent Fabric client framework inspired only by the *visual language* of the supplied reference: near-black UI, restrained purple accents, rounded panels, compact typography and soft alpha transitions. No proprietary code/assets/reverse engineering are used.

## Verified target
- Minecraft 1.21.4
- Java 21
- Yarn 1.21.4+build.8
- Fabric Loader 0.16.10
- Fabric API 0.119.4+1.21.4
- Fabric Loom 1.9.1

Fabric's 1.21.4 documentation recommends updating Minecraft, mappings, Loader and Loom together; the project follows that model. `runClient` is the standard Loom client launch task.

## Implemented in this drop
- Custom FetVisuals title screen with functional SinglePlayer, MultiPlayer, Accounts, Settings and Exit.
- Right Shift ClickGUI.
- Category navigation, module toggles, search field, scroll and draggable panel position.
- Module/setting architecture: Boolean, Number, Mode, Color, Keybind.
- JSON config save/load/delete/list + default config creation.
- `/fet config save|load|delete|list`, `/fet toggle|on|off`.
- Theme manager with Fet Purple, Dark, Black, Red, Blue, Green.
- Animation/easing primitives.
- FPS, Coordinates, Keystrokes and TargetHUD.
- CustomCrosshair and DynamicCrosshair.
- LowHealthVignette, DamageVignette and attack-triggered ScreenPulse.
- Performance-oriented simple rendering utilities and bounded notifications.

## Deliberately not claimed as complete
The supplied specification is much larger than this first build. Advanced 3D trajectory projection, full particle renderer, entity glow/highlight pipeline, armor/potion HUD, damage-number world projection, full HUD editor, custom TTF rasterizer and all requested combat/visual modules are not falsely marked as implemented here. They should be added as subsequent compilation-tested stages rather than hidden TODO/placeholder methods.

## Build
Use a JDK 21 environment:

`gradlew.bat runClient`

or

`gradlew.bat build`

If the Gradle wrapper is not present in your environment, generate/import the project with a local Gradle installation or IntelliJ IDEA. Loom will download Minecraft/Fabric dependencies.
