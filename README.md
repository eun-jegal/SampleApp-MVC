<h1>MVC Sample App</h1>
<p>
This sample app demonstrates an Android architecture pattern - MVC(Model, View, Controller) using Coroutines and Retrofit. When the user presses the button on the main screen, the app requests for user datas and displays them in a recyclerView.
</p>
<p align="center">
  <img src="https://user-images.githubusercontent.com/57670625/227792457-50104c7b-b626-4e62-9769-26c3875040a3.gif" width="23%"/>
</p>
<h3>Sample app built with different architectures</h3>
<ul>
  <li><a href="https://github.com/eun-jegal/SampleApp-MVP">MVP Pattern</a></li>
  <li><a href="https://github.com/eun-jegal/SampleApp-MVVM">MVVM Pattern</a></li>
  <li><a href="https://github.com/eun-jegal/SampleApp-MVI">MVI Pattern</a></li>
</ul>
<br>
<br>

<!-- Tech Stack -->
<h2>Tech Stack</h2>
<ul>
<li>Minumum SDK Level: 21</li>
<li>100% Kotlin</li>
<li>Architecture
    <ul>
      <li>MVC Pattern: Traditional Android architectural pattern, currently not recommended due to high dependencies between modules</li>
    </ul>
 </li>
<li><a href="https://developer.android.com/kotlin/coroutines">Coroutines</a>: Concurrency design pattern provided by Kotlin</li>
<li><a href="https://square.github.io/retrofit/">Retrofit</a>: Type-safe REST client for Android, Java and Kotlin developed by Square.  </li>
<li><a href="https://square.github.io/okhttp/">OkHttp</a> : 3rd party library sending and receive HTTP-based network requests built on top of the Okio library</li>
<li><a href="https://github.com/google/gson">GSON</a>: Java library that can be used to convert Java Objects into their JSON representation</li>
<li><a href="https://github.com/bumptech/glide">Glide</a>: Fast and efficient open source media management and image loading framework </li>
</ul>
<br>

<!-- MVP Description -->
<h2>What is MVC pattern?</h2>
<p>MVP stands for Model-View-Controller.</p>
<p align="center">
   <img src="https://user-images.githubusercontent.com/57670625/231274116-b69dc00f-26a4-4754-b6bc-03c355bb7447.jpg" width="75%"/>
</p>
<ul>
<li><b>Model</b>: Model is a layer for storing data. It is responsible for all business logics and communication with the database and network layers.</li>
<li><b>View</b>: View represents UI layer including activity and fragments. View displays user interfaces and notifies Presenter to keep track of user interactions.</li>
<li><b>Controller</b>: Controller is a bridge between View and Model. It contains core application logics and request data to Model when View requests.</li>
</ul>
<br>

<!-- App Architecture -->
<h2>App Architecture</h2>
<p>This sample app was built with MVC pattern. Activities and fragments perform as both View and Controller. Model should be a separate module which does not extend Android class so that it's testable.</p>
<p align="center">
   <img src="https://user-images.githubusercontent.com/57670625/231835531-79dfc865-f3a0-499f-800a-5ab7eca202ae.jpg" width="85%"/>
</p>
    
<!-- References -->
<h2>References</h2>
<p>The purpose of this project was to understand the core principles of the MVC pattern. You can check out more information about MVC in following links.</p>
<li><a href="https://www.geeksforgeeks.org/mvc-model-view-controller-architecture-pattern-in-android-with-example/">MVC (Model View Controller) Architecture Pattern in Android with Example</a></li>
<li><a href="https://medium.com/upday-devs/android-architecture-patterns-part-1-model-view-controller-3baecef5f2b6/">Android Architecture Patterns Part 1: Model-View-Controller</a></li>
