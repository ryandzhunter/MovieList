# MovieList

This project is an example for implementation of Clean Architecture, Koin, Coroutine, Android Architecture Component(ViewModel, Lifecycle, LiveData).

Clean architecture
-----------------
![http://fernandocejas.com/2015/07/18/architecting-android-the-evolution/](https://github.com/android10/Sample-Data/blob/master/Android-CleanArchitecture/clean_architecture.png)

On clean architecture, we divide the application to 3 different layers

- Data
  Provide data (remote and database), have dependencies to android framework
- Domain
  Use case to connect between data and presentation
- Presentation
  Display the data. I used MVVM on this layer.

To Do
-----------------

- Unit Test
- Dynamic Features
