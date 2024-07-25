# TicTacToe

This repository contains an implementation of the classic Tic Tac Toe game developed for Android. The project includes game logic, user interface components, and various resources needed to run the game.

## Contents

- **app/**: Contains the main application code and resources.
  - **src/main/java/com/example/tictactoe/**: Java and Kotlin source files organized by functionality.
    - **ui/theme**: Theming resources for the app.
      - `Color.kt`
      - `Shape.kt`
      - `Theme.kt`
      - `Type.kt`
    - **MainActivity.kt**: Main activity for the application.
    - **TTTViewModel.kt**: ViewModel for managing game state and logic.
  - **src/main/res/**: Application resources such as layouts, drawables, and values.
    - **layout**: XML layout files.
    - **drawable**: Image resources.
    - **mipmap**: Launcher icons.
    - **values**: Resource values (strings, colors, themes).
- **gradle/**: Gradle wrapper and properties for building the project.
- **.idea/**: IDE configuration files.

## Project Structure

- **src/**: Contains the source code organized into different packages.
- **data/**: Contains datasets for testing.
- **lib/**: Contains external libraries.
- **wykresy/**: Contains result charts.
- **Sprawozdanie.pdf**: Detailed report and analysis of the project.

## Algorithms and Techniques Used

### ViewModel

- **TTTViewModel.kt**: Manages the game state, player turns, and game logic. Implements functions to reset the game, check for wins, and handle player moves.

### User Interface

- **MainActivity.kt**: The main entry point of the application, setting up the UI components and linking them with the ViewModel.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

