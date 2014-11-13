RESTInjection
=============

REST, Hystryx, Angular test/demonstration project

This is a small web app based on Jersey 2.x and Resteasy. The app tends to implement matrix operations such as transpose,
multiply, etc.<br>
It also provides clients with compile time types. Special interest is in Jersey Application configuration which includes
Json marshller & Injection. WebApplicationException is used for error signalling.
/<provider>/ops will show available operations.
Matrix has dummy implementation as far as math is not the goal of this project.

Run the app by mvn jetty:run.
Angular UI is available on http://localhost:8080/matrixREST-jersey
