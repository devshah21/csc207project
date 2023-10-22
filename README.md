# Fantasy Basketball League Management System

Welcome to the Fantasy Basketball League Management System! This Java-based application is designed to help you create and manage your very own fantasy basketball leagues. Whether you're a seasoned fantasy basketball enthusiast or a newcomer to the game, this system is here to simplify the league administration process and make it a fun and engaging experience for all users.

## Table of Contents
- [Software Overview](#software-overview)
- [Entities in the Domain](#entities-in-the-domain)
- [Getting Started](#getting-started)
- [Features](#features)
- [Future Enhancements](#future-enhancements)

## Software Overview

The Fantasy Basketball League Management System is a comprehensive platform built entirely in Java. It provides the following features:

- **User Authentication**: Users can securely register and log in, ensuring that only authorized individuals have access to league management.

- **Profile Customization**: Personalize your profile to let other users know who you are and showcase your fantasy basketball expertise.

- **League Creation**: Initiate leagues with customizable settings, including league size, trading options, and roster management.

- **Player Drafts**: Facilitate player drafts with a real-time draft board to make player selection a breeze.

- **Team Management**: Throughout the season, users can manage their teams by adding, dropping, and closely monitoring player statistics.

- **Scoring System**: An adaptable scoring system calculates points based on player performance metrics.

- **Real-time Standings and Leaderboards**: Keep users engaged with up-to-the-minute standings and leaderboards to see how your team is doing.

- **Trade Proposals and Transaction History**: Users can propose trades and view a transaction history to track team changes over time.

- **Game Scheduling and Winner Determination**: The system schedules regular season games and determines winners based on accumulated points.

- **User-Friendly Interface**: The user interface is designed to be intuitive and user-friendly, making it easy for users to navigate and utilize all the features.

- **Clear User Documentation**: Detailed user documentation is provided to guide users through the system's functionalities.

## Entities in the Domain

The software is designed around several key entities in the domain, including:

### Team
- `HashMap players`: Stores the players on the team.
- `Player getPlayer`: Retrieves a player from the team.

### Daily View
- `ArrayList currentGames`: Tracks the games being played on a given day.
- `HashMap playerStats`: Stores player statistics.
- `ArrayList fantasyLeaders`: Keeps track of the fantasy basketball leaders for the day.

### User
- `String name`: User's name.
- `Team team`: User's team.
- `ArrayList transactionHistory`: Records the user's transaction history.
- `int totalFantasyPoints`: The total fantasy points the user has accumulated.
- `boolean hasPlayer`: Indicates if the user has a specific player on their team.

### Player
- `String name`: Player's name.
- `int pts`: Points scored by the player.
- `int rebounds`: Number of rebounds.
- `int assists`: Assists made.
- `int steals`: Steals by the player.
- `int blocks`: Blocks made.
- `int shotsMade`: Successful shots made.
- `int shotsAttempted`: Total shots attempted.
- `int gamesPlayed`: Number of games played.

### Game
- `Player players`: Players participating in the game.
- `User users`: Users associated with the game.
- `String score`: The game's score.

## Getting Started

To get started with the Fantasy Basketball League Management System, follow these steps:

1. **Installation**: Download the application and follow the installation instructions in the user documentation.

2. **User Registration**: Register as a user to get started.

3. **League Creation**: Create your own fantasy basketball league with customized settings.

4. **Player Drafts**: Participate in the player draft and build your dream team.

5. **Team Management**: Add, drop, and manage your players throughout the season.

6. **Enjoy the Game**: Follow the games, see how your players perform, and enjoy the competitive experience.

## Features

Explore the various features and functionalities of the Fantasy Basketball League Management System:

- **User Authentication**
- **Profile Customization**
- **League Creation**
- **Player Drafts**
- **Team Management**
- **Scoring System**
- **Real-time Standings and Leaderboards**
- **Trade Proposals and Transaction History**
- **Game Scheduling and Winner Determination**
- **User-Friendly Interface**
- **Clear User Documentation**



