### REACTIVE PROGRAMMING

### What problems solve

- Application performance, because it's a non-blocking model.

- Threads hanging on the application server. These threads takes up a lot of memory 
in non-reactive applications.

###  Design patterns related to reactive programming

- **Iterator** and **Observer** patterns are so close that the same programming paradigm 
can be used for both.

### Core Features

- Asynchronous and non-blocking. Publisher-Subscriber model.
  Concurrent requests can be easily handled.
  The same request will probable be handled by multiple threads under the hood.

- Functional style.

- Data Flow as event driven stream.

- Backpressure on data streams.
  The application can tell the database how fast it can handle data.

- Bonus ---> Schedulers are used insted of threads.

### Three abstractions

- Publisher. APIs provided by ProjectReactor.

- Subscriber. APIs provided by ProjectReactor.

- Subscription


### Interfaces we will use

- **Flux** ---> Asynchronous sequence of 0 to n items.

- **Mono** ---> Asynchronous sequence of 0 or 1 item.

### Operators or higher-order functions

- map, filter,....
- flatMap, concatMap, switchMap, flatMapSequential,.....

### How to debug

- Use **checkpoint()** to mark reactive milestones.
- Read about **Hooks.onOperatorDebug()**, but ...
- ... use reactor-tools' **ReactorDebugAgent**, because it works in production too.

### Reactive Programming in Spring

Spring does the subscription for you.

