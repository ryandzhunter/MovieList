# MovieList

This project is an example for implementation of Clean Architecture, Koin, Coroutine, Android Architecture Component(ViewModel, Lifecycle, LiveData).

Use Case Diagram
-----------------

![https://ibb.co/9g7jvQ6](https://i.ibb.co/7CqFzsP/Screen-Shot-2019-10-27-at-23-02-19.png)

Clean architecture
-----------------
![http://fernandocejas.com/2015/07/18/architecting-android-the-evolution/](https://github.com/android10/Sample-Data/blob/master/Android-CleanArchitecture/clean_architecture.png)

On clean architecture, we divide the application into 3 different layers

- Data : Provide data (remote and database), have dependencies to android framework. Retrofit has been introduced suspend function to combine with Coroutine, so we can simply return the result from retrofit api interface and call it by suspend function on repository class to make it asyncronous.
- Domain : Use case to connect between data and presentation.
- Presentation : Display the data. I used MVVM(Android Architecture Component) on this layer. Google introduce viewmodel lifecycle that let us to handle the lifecycle of coroutine scope based on viewmodel lifecycle. 

To Do
-----------------

- Unit Test
- Dynamic Features

This project based on https://github.com/cobeisfresh/CleanArchitecture-Android-Showcase
