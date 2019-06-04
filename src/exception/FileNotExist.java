package exception;



public class FileNotExist extends Exception {
    public FileNotExist(String errorMessage,Throwable err){
        super(errorMessage,err);
    }
}
