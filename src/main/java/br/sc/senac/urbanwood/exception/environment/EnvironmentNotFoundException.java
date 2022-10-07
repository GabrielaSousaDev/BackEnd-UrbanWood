package br.sc.senac.urbanwood.exception.environment;

public class EnvironmentNotFoundException extends RuntimeException{

    public EnvironmentNotFoundException(String message) {
        super(message);
    }
}
