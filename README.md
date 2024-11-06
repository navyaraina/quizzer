# TriviaApp 📚🎉

TriviaApp is an Android quiz application designed to make learning fun and interactive! Featuring multiple categories—History, Geography, and Math—this app allows users to test their knowledge, track their scores, and revisit questions.

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Code Structure](#code-structure)
- [Technologies Used](#technologies-used)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)

## Features
- 📜 **Multiple Categories**: Choose from History, Geography, and Math quizzes.
- ✅ **Real-Time Scoring**: Get instant feedback and track your score.
- 🕒 **Timed Transitions**: Delays between questions to enhance user experience.
- 🔄 **Restart Quiz**: Option to restart the quiz and improve your score.

## Getting Started
To get a local copy up and running, follow these steps.

### Prerequisites
- Android Studio Arctic Fox or later
- Minimum SDK: 21 (Android 5.0)
- Kotlin 1.4+

### Installation
1. **Clone the repository**:
   ```bash
   git clone https://github.com/navyaraina/TriviaApp.git
   cd TriviaApp
    ```
2. **Open in Android Studio**:
- Open Android Studio, click on "Open an existing project," and select the cloned repository.
3. **Build the project**:
- Sync Gradle and run the app on an emulator or physical device.

### Usage
- Select a quiz category (History, Geography, or Maths).
- Answer each question by selecting an option.
- At the end of the quiz, view your score and choose to restart if desired.

### Code Structure
## Project Files
- **MainActivity.kt**: Hosts the navigation controller for handling fragment transitions.
- **SelectionPageFragment.kt**: Lets the player choose a category to answer questions in, transitions to the selected category.
- **HisFragment.kt**: Displays history questions, handles answer selection, and transitions to the score screen.
- **GeoFragment.kt**: Displays geography questions, handles answer selection, and transitions to the score screen.
- **MathsFragment.kt**: Displays mathematics questions, handles answer selection, and transitions to the score screen.
- **ScoreFragment.kt**: Displays the user's score and provides a restart button.

## JSON Structure (questions.json)
`{
  "historyQuestions": [
    {
      "id": 1,
      "questionText": "Who was the first president of the United States?",
      "answerArray": ["George Washington", "John Adams", "Thomas Jefferson", "Abraham Lincoln"],
      "correctAnswerIndex": 0
    }
  ],
  "geoQuestions": [
    {
      "id": 1,
      "questionText": "What is the largest continent by area?",
      "answerArray": ["Asia", "Africa", "Europe", "Antarctica"],
      "correctAnswerIndex": 0
    }
  ],
  "mathQuestions": [
    {
      "id": 1,
      "questionText": "What is 2 + 2?",
      "answerArray": ["3", "4", "5", "6"],
      "correctAnswerIndex": 1
    }
  ]
}
`

## Navigation
Uses Jetpack Navigation Component for navigating between fragments (HisFragment, SelectionFragment, GeographyFragment, MathsFragment, and ScoreFragment).

### Technologies Used
- **Kotlin**: Primary language for Android development.
- **Android Jetpack**: Navigation Component for seamless fragment transitions.
- **JSON**: For storing questions and answers.
- **XML**: Layout design for UI.

### Future Enhancements
- 📈 **Additional Categories**: Expand quiz categories.
- 🌎 **Multilingual Support**: Add localization for different languages.
- 🎨 **Improved UI/UX**: Enhance visual design and add animations.
- 🌐 **Leaderboard**: Store scores in Firebase to display a global leaderboard.

### Contributing
- Fork the project.
- Create your feature branch (`git checkout -b feature/AmazingFeature`).
- Commit your changes (`git commit -m 'Add some AmazingFeature'`).
- Push to the branch (`git push origin feature/AmazingFeature`).
- Open a pull request.