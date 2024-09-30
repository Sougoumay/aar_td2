package racine.services;

import org.springframework.stereotype.Service;

@Service
public class CompteurImpl implements Compteur{

    private int counter = 0;

    @Override
    public int getCounter() {
        return this.counter;
    }

    @Override
    public void incrementCounter() {
        this.counter++;
    }
}
