# MvpSample
<h2>This project illustrates how MVP arhitecture on android works.</h2>

Here we have communication with server via http, using Json. All HTTP work done by Retrofit, local database powered by
Active Android orm, binding views - Butterknife.

<h3>MVP description</h3>
Basic idea - we have activity (view in mvp),
interactor (model in mvp) and presenter.
We use interfaces (in proj - StationsView, StationsPresenter and StationsInteractor) wich
defines the methods would be implemented in certain realizations.

Our View (Activity) is responsible only for displaying items, through callbacks of presenter. All interactivity ( view clicks)
 should as well be transferred to presenter.
 
 Our Model (Interactor) is responsible for fetching/saving data
 
 Our presenter is a controller. Main idea - Presenter does not have any android spec classes, so we can test it with unit tests.
 Also, presenter does not die when activity recreates - we use methods setView and removeView in View (Activity) and pass
 presenter instance when saveInstanceState gets fired (Look in StationsListActivity class) 
