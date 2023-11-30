# Contacts Kotlin Multiplatform

Simple example of a Contact App built in a few hours to show how to get access to Android and iOS gallery images using Kotlin Multiplatform.


 ### ⚙️ Preview Android - IOS
 - ["Camera | Gallery | KMM" - 
Kamlesh Lakhani](https://medium.com/@kamal.lakhani56/camera-gallery-kmm-4d4e111b72ee) - Access native gallery flow inspiration
- [Kotlin Multiplatform Wizard](https://kmp.jetbrains.com/) - Official tool for creating the KMP / KMM project
- [Jetpack Compose][compose] - For the UI, Jetpack Compose was used

### 🎨 Preview Android - IOS


https://github.com/git-jr/Contacts-Kotlin-Multiplatform/assets/35709152/444fdb78-98c4-4189-9bb2-cb88ae574aca




### 😎 Did you like the app?
⭐ Click on the star ⭐ at the top to give it a boost!

🚀 Want to see a more complete project? [Take a look here](https://github.com/git-jr/KMPSensors/tree/main)

‎‎‎‎‎‎‎‎ㅤ
‎‎‎‎‎‎‎‎ㅤ
‎‎‎‎‎‎‎‎ㅤ

‎‎‎‎‎‎‎‎ㅤ
‎‎‎‎‎‎‎‎ㅤ
‎‎‎‎‎‎‎‎ㅤ
‎‎‎‎‎‎‎‎ㅤ


This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)





[compose]: https://developer.android.com/jetpack/compose
