# FetVisuals implementation manifest

## Core
- `FetVisuals.java`: client bootstrap, Right Shift keybind, tick/HUD lifecycle, commands, autosave.
- `module/`: module/category/settings architecture.
- `config/`: JSON configuration storage under `.minecraft/config/fetvisuals/configs`.
- `theme/`: built-in theme palette.
- `animation/`: reusable easing + animation primitive.
- `render/`: low-cost rounded/rectangle/text helpers.

## UI
- `gui/MainMenuScreen.java`: custom title screen matching the supplied reference's composition without copying its branding/assets.
- `gui/ClickGuiScreen.java`: category sidebar, module toggles, search, scroll and draggable panel.
- `gui/AccountsScreen.java`: current Minecraft session view.

## Working visual/HUD modules
- FPS
- Coordinates
- Keystrokes
- TargetHUD
- CustomCrosshair
- DynamicCrosshair
- LowHealthVignette
- DamageVignette
- ScreenPulse

## Configuration modules
- HitColor
- TrajectoryPrediction settings model

The last two expose their settings but intentionally do not claim a complete rendering implementation. This is explicit so the project never presents an unimplemented feature as finished.
