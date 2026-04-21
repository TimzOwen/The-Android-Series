# Compose Quadrant App

A simple Android application built with Jetpack Compose that demonstrates a 2x2 grid layout using `Row`, `Column`, and `Modifier.weight`.

## Features
- **Jetpack Compose**: Built entirely using modern declarative UI.
- **Quadrant Layout**: Displays four different Compose components in a balanced 2x2 grid.
- **Material Design**: Uses Material 3 components and themes.
- **Adaptive Layout**: Uses weights to ensure each quadrant occupies equal space regardless of screen size.

## Screenshots
![Compose Quadrant](app/src/main/res/drawable/screenshot.png)

## Composables Explained
The app showcases four fundamental Compose concepts using modern Android best practices:
- **Separation of Concerns**: Data is modeled using `QuadrantInfo` data classes.
- **Theming**: Colors and styles are managed via the Material 3 theme system.
- **Composable Reuse**: A generic `QuadrantComponent` handles rendering logic.

## Tech Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Design System**: Material 3

## Getting Started
1. Clone the repository.
2. Open the project in Android Studio (Ladybug or newer recommended).
3. Run the app on an emulator or a physical device.

## License
This project is for educational purposes.
