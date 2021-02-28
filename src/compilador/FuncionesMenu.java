/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Oscar Mora
 */
public class FuncionesMenu {
    private JFileChooser accion = null;
    private File archivo = null;
    public String ruta = "";
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void FuncionesMenu(){
        
        
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String AbrirArchivo(javax.swing.JEditorPane Codigo_txt){
        
        String datos = "";
        accion = new JFileChooser();
        accion.setFileSelectionMode(0);
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("TXT", "txt");
        accion.setFileFilter(filtroImagen);
        accion.setDialogTitle("Abrir archivo");
        if (accion.showOpenDialog(Codigo_txt) == JFileChooser.APPROVE_OPTION) {
            archivo = accion.getSelectedFile();
            
            ruta = accion.getSelectedFile().toString();
            try {
                /*Si existe el fichero*/
                if (archivo.exists()) {
                    /*Abre un flujo de lectura a el fichero*/
                    BufferedReader leeArchivo = new BufferedReader(new FileReader(archivo));
                    String Slinea;
                    /*Lee el fichero linea a linea hasta llegar a la ultima*/
                    while ((Slinea = leeArchivo.readLine()) != null) {
                        /*Imprime la linea leida*/
                        datos = datos + Slinea + "\n";
                    }
                    /*Cierra el flujo*/
                    leeArchivo.close();
                } else {
                    System.out.println("Fichero No Existe");
                    return "No se encontro el archivo";
                }
            } catch (Exception ex) {
                /*Captura un posible error y le imprime en pantalla*/
                System.out.println(ex.getMessage());
            }
        }
        ArchivoConfirguracion();
        return datos;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void GuardarArchivo(String contenido){
        System.out.println(ruta);
        archivo = new File(ruta);
        try {
            //Si Existe el fichero lo borra
            if (archivo.exists()) {
                archivo.delete();
            }
            BufferedWriter wr = new BufferedWriter(new FileWriter(archivo));
            FileWriter escribirArchivo = new FileWriter(archivo, true);
            BufferedWriter buffer = new BufferedWriter(escribirArchivo);
            buffer.write(contenido);
            buffer.newLine();
            buffer.close();
            wr.close();
            escribirArchivo.close();
        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }
        ArchivoConfirguracion();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void CrearArchivo(javax.swing.JEditorPane Codigo_txt, String Cont){
        accion = new JFileChooser();
        accion.setFileSelectionMode(0);
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("TXT", "txt");
        accion.setFileFilter(filtroImagen);
        accion.setDialogTitle("Guardar archivo " + ".txt");
        accion.setSelectedFile(new File(".txt"));
        if (accion.showSaveDialog(Codigo_txt) == JFileChooser.APPROVE_OPTION) {
            ruta = accion.getSelectedFile().toString();
            archivo = new File(ruta);
            try {
                //Si Existe el fichero lo borra
                if (archivo.exists()) {
                    archivo.delete();
                }
                BufferedWriter wr = new BufferedWriter(new FileWriter(archivo));
                FileWriter escribirArchivo = new FileWriter(archivo, true);
                BufferedWriter buffer = new BufferedWriter(escribirArchivo);
                buffer.write(Cont);
                buffer.newLine();
                buffer.close();
                wr.close();
                escribirArchivo.close();

            } catch (Exception ex) {
            }
        }
        ArchivoConfirguracion();
    }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void CerrarArchivo(){
        ruta="";
        ArchivoConfirguracion();
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void ArchivoConfirguracion(){
        File conf=new File ("config.txt");
        try{
            if (conf.exists()) {
                conf.delete();
            }
            BufferedWriter wr = new BufferedWriter(new FileWriter(conf));
                FileWriter escribirArchivo = new FileWriter(conf, true);
                BufferedWriter buffer = new BufferedWriter(escribirArchivo);
                buffer.write(ruta);
                //buffer.newLine();
                buffer.close();
                wr.close();
                escribirArchivo.close();
        }catch (Exception ex) {
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String LeerConfiguracion(){
        System.out.println("leer conf");
        String linea="";
        try{
        File conf = new File ("config.txt");
        FileReader fr = new FileReader(conf);
        BufferedReader br = new BufferedReader(fr);

            while((linea=br.readLine())!=null){
                System.out.println(linea);
                ruta=linea;
                return linea;
                
            }
            
            
        }catch (Exception ex) { 
        }
        return linea;
        
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String DatosConfiguracion(String url){
        String linea="",cont="";
        if(url!=null){
            System.out.println("datos conf");
            System.out.println(url);
            File datos= new File(url);

            try{

                FileReader fr = new FileReader(datos);
                BufferedReader br = new BufferedReader(fr);

                while((linea=br.readLine())!=null){
                    cont+=linea;
                    cont+="\n";
                    System.out.println(linea);
                }

            }catch (Exception ex) { 
            }
        }
        
        return cont;
        
    }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
