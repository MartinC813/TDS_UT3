package ut3_pd6;
import java.util.LinkedList;

import java.lang.Iterable;

public class Sucursales {

    private Lista<Sucursal> lista = new Lista<Sucursal>();

    public Sucursales(String path) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(path);

        for (String linea : lineas) {
            Sucursal sucursal = new Sucursal(linea);
            lista.insertar(linea, sucursal);
        }
    }

    public boolean agregarSucursal(String stringSucursal) { // O(1)
        Sucursal sucursal = new Sucursal(stringSucursal);
        return lista.insertar(stringSucursal, sucursal);
    }

    public Sucursal buscarSucursal(String stringSucursal) { // O(n)
        return lista.buscar(stringSucursal);
    }


    /*
     * Este método quita la primera instancia encontrada de la sucursal con el nombre del parámetro
     * No asegura que no haya elementos duplicados luego de ejecutarse
     */
    public boolean quitarSucursal(String stringSucursal) { // O(n)
        return lista.eliminar(stringSucursal);
    }

    public String listarSucursales() { // O(n)
        return this.lista.imprimir();
    }

    public String listarSucursales(String str) { // O(n)
        return this.lista.imprimir(str);
    }

    public int cantidadDeSucursales() { // O(N)
        return this.lista.cantElementos();
    }

    public boolean estaVacia() { // O(1)
        return this.lista.cantElementos()== 0;
    }
}
