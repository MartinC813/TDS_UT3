package uy.edu.ucu.aed;

/**
 *
 * @author abadie
 */
public class Main {
    
    public static void main(String[] args){
        Almacen almacen = new Almacen();
        System.out.println(almacen.obtenerValorStock());
        almacen.nuevoStock("altas.txt");
        System.out.println(almacen.obtenerValorStock());
        almacen.ventaStock("ventas.txt");
        System.out.println(almacen.obtenerValorStock());
    }
    
}
