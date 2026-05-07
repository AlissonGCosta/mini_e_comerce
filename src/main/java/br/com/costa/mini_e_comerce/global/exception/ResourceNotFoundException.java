package br.com.costa.mini_e_comerce.global.exception;

public class ResourceNotFoundException  extends RuntimeException{
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
