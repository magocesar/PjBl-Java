package excep;

public class NoCpfInDatabaseException extends Exception{
    public NoCpfInDatabaseException(){
        System.out.println("CPF não encontrado no banco de dados!");
    }
}
