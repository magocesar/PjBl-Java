package excep;

public class NoCpfInDatabaseException extends Exception{
    public NoCpfInDatabaseException(String message, String cpf){
        super("CPF " + cpf + " não encontrado no banco de dados.");
    }

}
