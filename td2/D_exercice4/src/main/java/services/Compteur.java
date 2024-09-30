package services;

import org.springframework.stereotype.Service;

@Service
public class Compteur {

    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        this.counter++;
    }
}
