/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.proyecto1;

/**
 *
 * @author Adolfo
 */
public class memoria {
 
        //La memoria es un array de 20 espacios se utiliza como variable global.
        public String memoria[] = new String[20];
        
        //Toda la memoria queda vacia con Huecos
        public void inicializar(){
                
                
                for (int i=0; i<20; i++){
                        memoria[i]= "0";
                }
                
        }
        
        public void imprimirMemoria(){
                for (int i=0; i<20; i++){
                        System.out.print("[" + memoria[i] + "]");
                        
                }
                System.out.println("");
        }
        
        //Ahora se agregar un proceso en un espacio vacio
        //Se debe indicar donde esta el inicio y que tamaño tiene
        public void agregarProceso(String nombre, int inicio, int tamano){
                
                        //Aqui le damos forma para recorrer el array
                        tamano=(inicio+tamano)-1;
                
                        for (int i=inicio; i<=tamano; i++){
                                memoria[i] = nombre;
                        }
                System.out.println("Proceso Agregado");
                }
        
        //Este metodo tiene la finalidad de borrar un proceso de la memoria
        
        public boolean eliminarProceso(String nombre){
            
            int sentinela = 0; //Va a indicar si borro algo
            for (int i=0; i<20; i++){
                if (memoria[i].equals(nombre)){
                    memoria[i] = "0"; //Entre comillas para que sea tipo String
                    sentinela++;
                }
                }
                if (sentinela==0){
                    System.out.println("No encontre nada con el nombre de " + nombre);
                    return false;
                }else{
                    System.out.println("El Proceso " + nombre + " Fue encontrado y eliminado!");
                    return true;
                }
          
        }
        
        //Este metodo verifica si existe un Proceso en memoria para no repetirlo
        
        public boolean existeProceso(String nombre){
            int contador=0;
            for(int i=0; i<20; i++){
                if(memoria[i].equals(nombre)){
                    contador++;
                }
            }
            if(contador>0){
                return true;
            }else{
                return false;
            }
        }
 
        //Encuentra un espacio en la primera ocurrencia
        public boolean encontrarEspacio(int tamano){
                int counter=0;
                int i=0;
                while(counter<tamano && i<20){
                        if (memoria[i] == "0"){
                                counter++;
                                
                        }else{
                                counter=0;
                        }
                        i++;
                        
                        }
                
                if (counter==tamano){
                        //System.out.println("Se puede acomodar desde: " + (i-tamano) + " Hasta " + (i-1));
                        return true;
                }else{
                        //System.out.println("No encontre Espacio Disponible en Memoria");
                        return false;
                }
                
        }
        
        //Igual al anterior pero para devolver el numero de inicio.
        public int encontrarInicio(int tamano){
                int counter=0;
                int i=0;
                while(counter<tamano && i<20){
                        if (memoria[i] == "0"){
                                counter++;
                                
                        }else{
                                counter=0;
                        }
                        i++;
                        
                        }
                
                if (counter==tamano){
                        return (i-tamano);
                }else{
                        
                        return 0;
                }
                
        }
        
        
        
}
