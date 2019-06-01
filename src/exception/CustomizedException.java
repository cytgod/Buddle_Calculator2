package exception;

import java.io.IOException;

public class CustomizedException extends Exception {
    private String error="this file is not exist";
    public void fileNotExist(){
        System.out.println(error);
    }
}
