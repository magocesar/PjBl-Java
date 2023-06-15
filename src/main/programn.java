package main;
import padaria.*;

public class programn {
    public static void main(String[] args){
        //Atualmente, não busca nada em banco / txt
        Padaria padaria = new Padaria("Padaria do Zé", "123456789");
        padaria.getNome();
        padaria.getCnpj();
    }
}
