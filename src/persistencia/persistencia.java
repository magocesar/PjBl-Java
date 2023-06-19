package persistencia;

import java.io.*;
import java.util.ArrayList;

import estoque.*;
import personas.*;
import produtos.*;

public class persistencia implements Serializable {

    public static File ListaFuncionarios = new File("ListaFuncionarios.txt");

    public static File produtoIndustrializados = new File("produtoIndustrializados.txt");

    private static ObjectOutputStream oos = null;
    private static ObjectInputStream ois = null;

    public static void SalvaFuncionarios(ArrayList<Funcionario> ListaFuncionario) throws FileNotFoundException, IOException{
        oos = new ObjectOutputStream(new FileOutputStream(ListaFuncionarios));
        oos.writeObject(ListaFuncionarios);
        oos.close();
    }

    public static ArrayList<Funcionario> lerFuncionarios() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<Funcionario> ListaFuncionario = new ArrayList<Funcionario>();
        if(ListaFuncionarios.isFile()){
            ois = new ObjectInputStream(new FileInputStream(ListaFuncionarios)); 
            ListaFuncionario = (ArrayList<Funcionario>)ois.readObject();
            ois.close();
        }
        return ListaFuncionario;
    }

    public static void SalvaIndustrializados(ArrayList<produtoIndustrializado> ListaIndustrializados) throws FileNotFoundException, IOException{
        oos = new ObjectOutputStream(new FileOutputStream(produtoIndustrializados));
        oos.writeObject(ListaIndustrializados);
        oos.close();
    }

    public static ArrayList<produtoIndustrializado> LerIndustrializados() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<produtoIndustrializado> ListaIndustrializados = new ArrayList<produtoIndustrializado>();
        if(produtoIndustrializados.isFile()){
            ois = new ObjectInputStream(new FileInputStream(produtoIndustrializados)); 
            ListaIndustrializados = (ArrayList<produtoIndustrializado>)ois.readObject();
            ois.close();
        }
        return ListaIndustrializados;
    }

    public static void SalvaUltimoID(int id){

    }

    public int LerUltimoID(){
 //       int id = ler a string, trasformar em int

 //       return id; retornar a int
    }
    

}
