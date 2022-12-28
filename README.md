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

### Performance 

Extracted from the Spring documentation:
```
Performance has many characteristics and meanings. Reactive and non-blocking generally do not make applications run faster. They can, in some cases. 
For example, if using the WebClient to run remote calls in parallel. On the whole, it requires more work to do things the non-blocking way 
and that can slightly increase the required processing time.

The key expected benefit of reactive and non-blocking is the ability to scale with a small, fixed number of threads and less memory.
That makes applications more resilient under load, because they scale in a more predictable way. In order to observe those benefits, however, 
you need to have some latency (including a mix of slow and unpredictable network I/O). That is where the reactive stack begins to show its strengths, and the differences can be dramatic.
```

