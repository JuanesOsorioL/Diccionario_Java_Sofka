package com.sofka.Diccionario;

import com.sofka.Diccionario.Modelo.Modelo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    //variables
    Scanner input = new Scanner(System.in);
    private File archivo=null;
    private boolean control= true;

    String espanol,ingles,texto="****** Bienvenido ******** \n" +
            "1-INGRESAR NUEVA PALABRA \n" +
            "2-BUSCAR PALABRA \n" +
            "3-MOSTRAR TODO EL DICCIONARIO \n" +
            "4-SALIR \n" +
            "Ingrese una opcion: ";

    private int opcion=0;



    //Funciones
    public void Iniciar() throws IOException {
       System.out.println("Bienvenidos ingrese solo el nombre del archivo");
       archivo = new File((input.nextLine()+".txt").toLowerCase());
       // archivo = new File("diccionario.txt");
        if (!archivo.exists())
            archivo.createNewFile();
        Menu();
    }


    public void Menu ()  {
        do {
            System.out.flush();
            System.out.print(texto);
            opcion=input.nextInt();
            Opciones(opcion);
        }while (opcion!=4);{
            System.out.println("Muchas gracias");
        }
    }

    public void Opciones (int opcion)  {
        try {
            Modelo m=null;
            Texto t=new Texto();
            switch (opcion){
                case 1:

                    System.out.print("Ingrese la palabra en Español: ");
                    espanol = input.next();
                    System.out.print("Ingrese la palabra en Ingles: ");
                    ingles = input.next();
                    m=new Modelo(espanol,ingles);
                    t.escribir(archivo,m);
                    break;
                case 2:{
                    System.out.print("Ingrese la palabra en español: ");
                    espanol = input.next();
                    t.leer(archivo,espanol);;
                    break;}
                case 3:{
                    t.leer(archivo,"");;
                    break;}
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
