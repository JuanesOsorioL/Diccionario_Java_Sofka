package com.sofka.Diccionario.Control;
import com.sofka.Diccionario.Modelo.Modelo;
import java.io.*;

public class Texto {

    private BufferedReader br = null;
    private FileReader fr = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;

    public void escribir(File archivo, Modelo m) throws IOException {
        try {
            fw = new FileWriter(archivo,true);
            bw = new BufferedWriter(fw);
            String plantilla=m.getEspanol()+"="+m.getIngles();
            bw.write(plantilla);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bw.close();
            fw.close();
        }
    }

    public void leer(File archivo,String palabra) throws IOException {
        try {
            Boolean control=false;
            fr = new FileReader(archivo);
            br=new BufferedReader(fr);
            String temp="";
            if (palabra.equals("")){
                while (temp!=null){
                    temp = br.readLine();
                    if (temp==null)
                        break;
                    System.out.println(temp);
                }
            }else{
                while (temp!=null){
                    temp = br.readLine();
                    if (temp==null)
                        break;
                    String[] valor= temp.split("=");
                    if (valor[0].equals(palabra)) {
                        control=true;
                        System.out.println("la traduccion de "+valor[0]+" es : "+valor[1]);
                        break;
                    }
                }
                if (!control)
                    System.out.println("no se encontro traduccion");
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            br.close();
            fr.close();
        }
    }
}
