package excep;

public class NoIdInDatabaseException extends Exception{
    public NoIdInDatabaseException(String message, int id){
        super("Id " + id + " não encontrado no banco de dados.");
    }
    
}
