package com.sample.ecomm.others.dpattern;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(String message);
}

// Concrete Observer
class User implements Observer {
    private final String name;

    User(String name) { this.name = name; }

    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

// Subject (Publisher)
class Channel {
    private final List<Observer> observers = new ArrayList<>();

    void subscribe(Observer observer) { observers.add(observer); }
    void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Usage
public class ObserverExample {
    public static void main(String[] args) {
        Channel channel = new Channel();
        Observer user1 = new User("Alice");
        Observer user2 = new User("Bob");

        channel.subscribe(user1);
        channel.subscribe(user2);
        channel.notifyObservers("New video uploaded!");
    }
}

