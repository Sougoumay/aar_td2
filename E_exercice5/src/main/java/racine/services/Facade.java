package racine.services;

public interface Facade {
    boolean checkLP(String login,String password);

    int getCounter();

    void incrementCounter();
}
