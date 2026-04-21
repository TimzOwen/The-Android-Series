# The Android Series: Business Card App

A simple, beginner-friendly Jetpack Compose application that displays a professional digital business card. This project is designed to help newcomers understand the core fundamentals of Android development and modern UI design with Jetpack Compose.

## 📱 Features

- **Responsive Layout**: Uses `weight` and `Arrangement` to ensure the card looks great on any screen size.
- **Material 3 Theming**: Implements a consistent color palette using semantic names.
- **Resource Management**: Demonstrates best practices by extracting text to `strings.xml` and colors to `Color.kt`.
- **Modern UI Components**: Utilizes `Scaffold`, `Column`, `Row`, `Icon`, and `Text` with Material 3 typography.

## 🖼️ Screenshot

![Business Card Screenshot](app/src/main/res/drawable-nodpi/screenshot.png)

## 🎓 Beginner Concepts Covered

This project is built to be a learning resource. Key concepts include:

1.  **Composable Functions**: Breaking down the UI into small, reusable components like `CardProfile`, `ContactInformationList`, and `ContactRow`.
2.  **Layout Management**:
    - `Column`: Stacking elements vertically (Profile vs. Contact Info).
    - `Row`: Arranging elements horizontally (Icons next to text).
    - `Spacer`: Adding flexible or fixed space between elements.
3.  **Modifiers**:
    - `Modifier.weight(1f)`: Evenly distributing space.
    - `Modifier.padding()`: Adding spacing around elements.
    - `Modifier.fillMaxSize()`: Ensuring the app uses the full screen.
4.  **Theming & Styling**:
    - Using `MaterialTheme` for consistent typography.
    - Defining custom colors in `Color.kt`.
    - Applying `FontWeight` and `TextAlign` for better readability.
5.  **Resource Handling**:
    - `stringResource(R.string...)`: Loading text from XML for localization support.
    - `painterResource(R.drawable...)`: Displaying images and logos.

## 🛠️ Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Design System**: Material Design 3 (M3)
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 36 (Android 15+)

## 🚀 Getting Started

1.  **Clone the Repository**:
    ```bash
    git clone https://github.com/yourusername/TheAndroidSeries.git
    ```
2.  **Open in Android Studio**:
    - Select **File > Open** and choose the project directory.
3.  **Build & Run**:
    - Select your device/emulator and click the **Run** button (green arrow) in the toolbar.

---

*Part of "The Android Series" — a collection of projects for learning Android development from 0 to Hero.*
