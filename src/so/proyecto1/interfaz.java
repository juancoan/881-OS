/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.proyecto1;

import java.util.Scanner;

/**
 *
 * @author Adolfo
 */
public class interfaz {
    
    memoria mem = new memoria(); //Inicializa la clase de memoria
    
    public void inicio(){
        mem.inicializar();
        mem.imprimirMemoria();
        
        //Los siguientes comentarios fueron alguna vez de ayuda para elaborar
        //El programa, da una idea de como se hacen las llamadas a los metodos.
        
        //mem.agregarProceso("P", 3, 2);
        //mem.agregarProceso("A", 6, 9);
        //mem.imprimirMemoria();
        //mem.encontrarEspacio(4);
        //mem.encontrarEspacio(3);
       // mem.encontrarEspacio(6);
       // mem.eliminarProceso("J");
        //mem.imprimirMemoria();
    }
    
    //Variable Global para manejar el input
    Scanner scan = new Scanner(System.in);
    String input = "";
    
    //Para manejar el titulo
    public void titulo(){
        System.out.println("Bienvenido al Gestor de Memoria 1.0\n\n");
     }
    
    public void menuprincipal(){
        System.out.println("Por Favor escoja una opción\n");
        System.out.println("a) Incluir Proceso");
        System.out.println("b) Eliminar Proceso");
        System.out.println("c) Salir");
        
        
        
        System.out.print("Digite la Opcion: ");
        input = scan.nextLine();
        
        
        while (!input.equals("a") && !input.equals("b") && !input.equals("c"))
        {            
            System.out.println(input);
            System.out.println("Opción Invalida");
            System.out.print("Digite la Opcion: ");
            input = scan.nextLine();
            
        }
        
        if(input.equals("a")){
            menuincluirProceso();
        }
         if(input.equals("b")){
            eliminarProceso();
        }
          if(input.equals("c")){
            salir();
        }
        
    }
    
    public void menuincluirProceso(){
        titulo();
        System.out.println("Indique con una Letra el nombre del Proceso");
        System.out.print("Digite la Letra: ");
        input = scan.nextLine();
        
        //El siguiente ciclo valida que sean solo letras, y solo una
        while(!input.matches("[a-zA-Z]") || input.length() != 1){
            System.out.println("Error, debe ser una Letra intente de nuevo");
            System.out.print("Digite la Letra: ");
            
            input = scan.next();
        }
        
        String nombreProceso = input; //Una vez validado por fin obtenemos el nombre
       

        System.out.println("Ahora indique el Tamaño de memoria igual o menor a 20");
        System.out.print("Digite El Tamaño: ");
        input = scan.nextLine();
       
        //Solo cuando se cumplan las dos condiciones puede salir del ciclo.
        // Solo numeros y que sea menor o igual a 20
        while(true){
            
            if(!input.matches("[0-9]+")){
            
            System.out.println("Error, No es un numero, ");
            System.out.println(input);
            System.out.print("Digite el Tamaño <20: ");
            input = scan.nextLine();
            }
            
            if(input.matches("[0-9]+")){
                if(Integer.parseInt(input)<21 && Integer.parseInt(input)>0){
                    break; //Nos salimos del ciclo porque ya todo es perfecto
                }else{
                    System.out.println("Error, el tamaño en bytes menor o igual a 20 y Mayor a 0");
                    System.out.print("Digite el Tamaño <20: ");
                    input = scan.nextLine();
                }
            }
            
        } //Fin del ciclo while
        int tamano = Integer.parseInt(input);
        //Vamos a redondear al multiplo de 5.
        
        if(tamano % 5 != 0){
                    //System.out.println("No es multiplo voy a redondear");
                    tamano = tamano + (5 - tamano % 5);
        }
        tamano = (tamano / 5); //Cada unidad representa 5 bytes
      
        //Vamos a verificar que el proceso no exista
         
        if (mem.existeProceso(nombreProceso) == true){
            System.out.println("Error ya ese proceso existe, Empiece de nuevo");
            menuprincipal(); //Lo Devolvemos al menu principal.
        }else{
            if(mem.encontrarEspacio(tamano) == true){
                int inicio = mem.encontrarInicio(tamano);
                mem.agregarProceso(nombreProceso, inicio, tamano);
            }
        }
        
        //Llamamos al menu principal
        mem.imprimirMemoria(); //Vamos a imprimir la memoria para verificar
        menuprincipal();
        
    }//Fin del menu incluir proceso
    
    public void eliminarProceso(){
        titulo();
        System.out.println("Indique con una Letra el nombre del Proceso a Eliminar");
        System.out.print("Digite la Letra: ");
        input = scan.nextLine();
        
        //El siguiente ciclo valida que sean solo letras, y solo una
        while(!input.matches("[a-zA-Z]") || input.length() != 1){
            System.out.println("Error, debe ser una Letra intente de nuevo");
            System.out.print("Digite la Letra: ");
            
            input = scan.next();
        }
        
        String nombreProceso = input; //Una vez validado por fin obtenemos el nombre
        
        if(mem.eliminarProceso(nombreProceso) == true){
            System.out.println("Proceso Eliminado");
            mem.imprimirMemoria();
            menuprincipal();
        }else{
            System.out.println("No Encontre Dicho Proceso");
            menuprincipal();
        }
        
    }
        
    public void salir(){
        System.out.println("Gracias por Utilizar el Gestor de Memoria");
        System.exit(0);
        
    }
    
    
    
}
