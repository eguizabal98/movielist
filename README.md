# 🎬 Movie List

**Movie List** is an Android application written in Kotlin using Jetpack Compose for the UI. It lets
users browse currently playing movies using [The Movie Database (TMDb)](https://www.themoviedb.org/)
API. The app follows **Clean Architecture** principles and is organized into three core modules:
`app`, `domain`, and `data`.

Currently, it includes a single feature: a movie list screen with the ability to locally save
favorite movies using Room.

---

## 🚀 Features

- 🔍 Browse now-playing movies from TMDb
- ⭐ Mark movies as favorites and save them locally
- ⚙️ Modular, scalable Clean Architecture
- 🧪 Compose-based UI testing support

---

## 🛠️ Tech Stack

- **Language:** Kotlin
- **UI Framework:** Jetpack Compose
- **Architecture:** Clean Architecture (App, Domain, Data)
- **Networking:** Retrofit
- **Local Persistence:** Room
- **Dependency Injection:** Hilt
- **Testing:** Compose UI Testing

---

## 🏗️ Project Structure

- **app
  features
  movielist

- **data
  api, dto, database, repository

- **domain
  model, repository

---

## 🔐 Secrets Configuration

To run the project, make sure to add the following keys to your `local.properties` file or Gradle
properties:

```properties
BASE_URL=https://api.themoviedb.org/3/
API_READ_TOKEN=<<YOUR_API_READ_TOKEN>>
IMAGES_ORIGINAL_BASE_URL=https://image.tmdb.org/t/p/original

🧪 Testing
The app includes UI tests using Jetpack Compose. You can run them via Android Studio or with Gradle:

bash
./gradlew connectedAndroidTest


