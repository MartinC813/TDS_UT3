package ut3_pd6;

public class Main {
    public static void main(String[] args) {
        Sucursales listaDeSucursales = new Sucursales("sucursales.txt");
        //listaDeSucursales.listarSucursales();
            
        //System.out.println(listaDeSucursales.cantidadDeSucursales());
        System.out.println("-------------------");

        listaDeSucursales.agregarSucursal("Las Piedras");
        listaDeSucursales.agregarSucursal("Sauce");
        listaDeSucursales.agregarSucursal("Mercedes");
        //listaDeSucursales.listarSucursales();

        //System.out.println(listaDeSucursales.cantidadDeSucursales());
        //System.out.println("-------------------"); 

        Sucursales listaDeSucursales1 = new Sucursales("suc1.txt");
        System.out.println(listaDeSucursales1.cantidadDeSucursales());
        // 107



        listaDeSucursales1.quitarSucursal("Chicago");
        listaDeSucursales1.listarSucursales();
        System.out.println(listaDeSucursales1.cantidadDeSucursales());
        // Shenzhen

        Sucursales listaDeSucursales2 = new Sucursales("suc2.txt");
        listaDeSucursales2.quitarSucursal("Shenzen");
        listaDeSucursales2.quitarSucursal("ï»¿Tokio");
        System.out.println(listaDeSucursales2.cantidadDeSucursales());
        listaDeSucursales2.listarSucursales();
        // deberían quedar 0 (sin Tokio) pero no podemos sacar el carácter de inicio

        Sucursales listaDeSucursales3 = new Sucursales("suc3.txt");
        System.out.println(listaDeSucursales3.listarSucursales(";_"));

        // es la opción b), pero imprime con el caracter de inicio
        // ï»¿Montreal;_Caracas;_Tulsa;_Mobile;_Vancouver
        


    }
}