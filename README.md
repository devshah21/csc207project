# QuizIt - Java-based Interactive Quiz Game

Welcome to QuizIt! This Java-based game offers an engaging and interactive gaming experience, challenging your knowledge with a variety of questions. Compete against others to claim the top spot on our leaderboards!

## Table of Contents
- [Software Overview](#software-overview)
- [Entities in the Domain](#entities-in-the-domain)
- [Getting Started](#getting-started)
- [Features](#features)
- [Future Enhancements](#future-enhancements)

## Software Overview

QuizIt is a comprehensive Java platform designed for an enjoyable gaming experience. It boasts the following features:

- **User Authentication**: Securely register and log in to ensure that only authorized individuals have access to leaderboards and scores.

- **Interactive Game Design**: Engage in the game with interactive elements and an intuitive, fun design.

- **User-Friendly Interface**: The interface is designed to be intuitive and user-friendly, making navigation easy for all users.

- **Clear User Documentation**: Detailed user documentation is provided to guide users through the game's functionalities.

## Entities in the Domain

QuizIt is structured around key entities in the domain, enhancing the overall gaming experience:

### Common User
- `String name`: User's name.
- `String password`: User's password.
- `int highScore`: User's highest score.

### Question
- `String category`: The category in which the question is placed (e.g., Gaming, Music, General Knowledge).
- `String type`: The type of question, either MCQ or True/False.
- `String question`: The actual question being asked.
- `String difficulty`: The difficulty level of the question.
- `String rightAnswer`: The correct answer to the question.
- `ArrayList<String> wrongAnswers`: A list of all the wrong answers.

### QuizAPI Wrapper Class
- `ArrayList<Question> questions`: A list of questions received from the API call.

## Getting Started

Ready to embark on your QuizIt adventure? Follow these steps:

1. **Installation**: Download the application and follow the installation instructions in the user documentation.

2. **User Registration**: Register as a user to kickstart your QuizIt journey.

3. **Game Setup**: Customize your gaming experience by selecting the number of questions and difficulty level. Let the game setup begin!

4. **Enjoy the Game**: Follow the games, observe how your players perform, and immerse yourself in the competitive experience.

## Features

- **Personalized Gaming Experience**: Tailor your game by selecting the number of questions and difficulty level.

- **Competitive Leaderboards**: Compete against others to claim the top spot on our leaderboards.

- **Intuitive Interface**: Navigate seamlessly through the user-friendly interface.

## Future Enhancements

Stay tuned for future updates and enhancements, including:

- **Expanded Question Categories**: Diversify your quiz experience with additional question categories.

- **Real-time Multiplayer Mode**: Challenge friends and other users in real-time.

- **Enhanced Game Statistics**: Explore detailed statistics for a deeper understanding of your gaming performance.

We hope you enjoy your QuizIt experience, where knowledge meets competition!
