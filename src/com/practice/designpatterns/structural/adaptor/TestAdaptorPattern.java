package com.practice.designpatterns.structural.adaptor;
/*
In design, adapters are used when we have a class (Client) expecting some type of object and we have an object (
Adaptee) offering the same features but exposing a different interface.

To use an adapter:

-The client makes a request to the adapter by calling a method on it using the target interface.
--The adapter translates that request on the adaptee using the adaptee interface.
Client receive the results of the call and is unaware of adapter’s presence.

Definition:

The adapter pattern convert the interface of a class into another interface clients expect. Adapter lets classes work together that couldn’t
otherwise because of incompatible interfaces.

Adapter Design Pattern Example in JDK

-java.util.Arrays#asList()
-java.io.InputStreamReader(InputStream) (returns a Reader)
-java.io.OutputStreamWriter(OutputStream) (returns a Writer)
 */
public class TestAdaptorPattern {
}
