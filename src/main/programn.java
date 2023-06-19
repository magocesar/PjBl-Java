package main;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;

import padaria.*;

public class programn {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        Padaria padaria = new Padaria("Padaria do Zé", "123456789");
        padaria.exibirMenuPadaria();
    }
}
