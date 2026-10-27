# 📚 My Library — Library Management System

An Android application built with **Java** that helps manage a library's book collection and lets users request books from the available list. The app includes separate admin and user flows, Firebase Authentication, and local SQLite storage for book and request data.

## ✨ Features

### Admin
- Register and sign in with email and password.
- View the book collection.
- Add new books with title, author, and page count.
- Update book details or delete individual books.
- Delete all book records when required.
- Access the user/request management screens included in the project.

### User
- Register and sign in with email and password.
- View the book list.
- Submit a book request with a username, book name, number of days, and status.
- View the request list.
- Log out through Firebase Authentication.

## 🛠️ Tech Stack

- **Language:** Java
- **Platform:** Android
- **IDE:** Android Studio
- **Build system:** Gradle (Kotlin DSL)
- **UI:** XML layouts, AndroidX, Material Components, RecyclerView
- **Authentication:** Firebase Authentication
- **Local database:** SQLite via `SQLiteOpenHelper`
- **Minimum Android SDK:** API 24 (Android 7.0)
- **Compile / target SDK:** API 34

## 🗂️ Project Structure

```text
Library-Management-System/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/mylibrary/
│   │   │   ├── MainActivity.java
│   │   │   ├── AddActivity.java
│   │   │   ├── UpdateActivity.java
│   │   │   ├── Login.java
│   │   │   ├── Registration.java
│   │   │   ├── login_user.java
│   │   │   ├── Registration_user.java
│   │   │   ├── UserDashboardActivity.java
│   │   │   ├── BookRequestActivity.java
│   │   │   ├── MyDatabaseHelper.java
│   │   │   └── MyDatabaseHelper2.java
│   │   ├── res/
│   │   │   ├── layout/       # Screen layouts
│   │   │   ├── drawable/     # UI drawable resources
│   │   │   ├── menu/         # App menus
│   │   │   └── values/       # Strings, colors, and themes
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── gradlew.bat
```

## 🚀 Getting Started

### Prerequisites

- Android Studio
- Android SDK API 34
- A JDK compatible with your installed Android Gradle Plugin
- An Android device or emulator running Android 7.0 (API 24) or later
- A Firebase project with **Email/Password Authentication** enabled

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/SanikaVeer-tech/Library-Management-System.git
   ```

2. **Open the project**  
   In Android Studio, choose **Open** and select the cloned `Library-Management-System` folder.

3. **Configure Firebase**  
   In the Firebase console, create or select a project and register an Android app using the application ID `com.example.mylibrary`. Download its `google-services.json` configuration file and place it in the `app/` directory. Make sure Email/Password sign-in is enabled in Firebase Authentication.

4. **Sync Gradle**  
   Allow Android Studio to sync the project and download the required dependencies.

5. **Run the app**  
   Select an emulator or connect an Android device with USB debugging enabled, then click **Run** in Android Studio.

## 💾 Data Storage

- **Firebase Authentication** manages user sign-up and sign-in.
- **SQLite** stores book records locally on the device.
- A separate SQLite database helper stores book-request details.

> Book and request data are stored locally in SQLite; they are not automatically shared between devices.

## 🔐 Firebase Configuration Note

Do not commit private keys, service-account credentials, passwords, or other secrets. The Firebase client configuration file (`app/google-services.json`) is present in this repository. Review Firebase's recommended security settings, restrict API keys where applicable, and configure appropriate authentication and data-access rules for any Firebase services you enable. If this file was not intended to be public, remove it from version control and rotate or restrict credentials as appropriate.

## 🧭 Possible Improvements

- Implement and verify book-request approval/rejection workflows.
- Enable and test book search and filtering.
- Add input validation and clearer error messages.
- Add tests for book CRUD operations and request handling.
- Improve data synchronization if multi-device access is required.

## 👩‍💻 Author

**Sanika Veer**  
GitHub: [SanikaVeer-tech](https://github.com/SanikaVeer-tech)

---

If you find this project useful, feel free to explore the code and suggest improvements.
