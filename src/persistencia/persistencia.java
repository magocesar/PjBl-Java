package persistencia;

import java.io.*;
import java.util.ArrayList;

import estoque.*;
import personas.*;
import produtos.*;

public class persistencia implements Serializable {

    public static File ListaFuncionarios = new File("ListaFuncionarios.txt");
    public static File ListaClientes = new File("ListaClientes.txt");
    public static File produtoIndustrializados = new File("produtoIndustrializados.txt");
    public static File ProdutosProduzidos = new File("ProdutosProduzidos.txt");
    public static File ListaPedidos = new File("pedidos.txt");
    public static File ultimoIDFile = new File("ultimoID.txt");

    private static ObjectOutputStream oos = null;
    private static ObjectInputStream ois = null;

    //funcio
    public static void SalvaFuncionarios(ArrayList<Funcionario> ListaFuncionario) throws FileNotFoundException, IOException{
        oos = new ObjectOutputStream(new FileOutputStream(ListaFuncionarios));
        oos.writeObject(ListaFuncionario);
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

    //clien
    public static void SalvaClientes(ArrayList<Cliente> ListaCliente) throws FileNotFoundException, IOException{
        oos = new ObjectOutputStream(new FileOutputStream(ListaClientes));
        oos.writeObject(ListaCliente);
        oos.close();
    }

    public static ArrayList<Cliente> lerClientes() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<Cliente> ListaCliente = new ArrayList<Cliente>();
        if(ListaFuncionarios.isFile()){
            ois = new ObjectInputStream(new FileInputStream(ListaFuncionarios)); 
            ListaCliente = (ArrayList<Cliente>)ois.readObject();
            ois.close();
        }
        return ListaCliente;
    }

    //prod industri
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

    //prod produ
    public static void SalvaProduzidos(ArrayList<produtoProduzido> ProdutosProduzido) throws FileNotFoundException, IOException{
        oos = new ObjectOutputStream(new FileOutputStream(ProdutosProduzidos));
        oos.writeObject(ProdutosProduzido);
        oos.close();
    }

    public static ArrayList<produtoProduzido> LerProduzidos() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<produtoProduzido> ProdutosProduzido = new ArrayList<produtoProduzido>();
        if(ProdutosProduzidos.isFile()){
            ois = new ObjectInputStream(new FileInputStream(ProdutosProduzidos)); 
            ProdutosProduzido = (ArrayList<produtoProduzido>)ois.readObject();
            ois.close();
        }
        return ProdutosProduzido;
    }

    //pedidos
    public static void SalvaPedidos(ArrayList<Produto> ListaPedido) throws FileNotFoundException, IOException{
        oos = new ObjectOutputStream(new FileOutputStream(ListaPedidos));
        oos.writeObject(ListaPedido);
        oos.close();
    }

    public static ArrayList<Produto> LerPedidos() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<Produto> ListaPedido = new ArrayList<Produto>();
        if(produtoIndustrializados.isFile()){
            ois = new ObjectInputStream(new FileInputStream(ListaPedidos)); 
            ListaPedido = (ArrayList<Produto>)ois.readObject();
            ois.close();
        }
        return ListaPedido;
    }

        private static BufferedWriter bufferedWriter;
        private static BufferedReader bufferedReader;

      public static void SalvaUltimoID(int id) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(ultimoIDFile));
            bufferedWriter.write(String.valueOf(id));
            bufferedWriter.close();
            System.out.println("Último ID salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o último ID: " + e.getMessage());
        }
    }

    public static int LerUltimoID() {
        int ultimoID = 0;
        try {
            bufferedReader = new BufferedReader(new FileReader(ultimoIDFile));
            String linha = bufferedReader.readLine();
            if (linha != null) {
                ultimoID = Integer.parseInt(linha);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o último ID: " + e.getMessage());
        }
        return ultimoID;
    }
}
