package ut3_pd8;
import java.util.ArrayList;
import java.util.LinkedList;

import java.lang.Iterable;

public class Sucursales {

    private ArrayList<Sucursal> lista = new ArrayList<Sucursal>();

    public Sucursales(String path) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(path);

        for (String linea : lineas) {
            Sucursal sucursal = new Sucursal(linea);
            lista.add(sucursal);
        }
    }

    public boolean agregarSucursal(String stringSucursal) { // O(1)
        Sucursal sucursal = new Sucursal(stringSucursal);
        return lista.add(sucursal);
    }

    public Sucursal buscarSucursal(String stringSucursal) { // O(n)
        for(Sucursal sucursal : lista){
            if(sucursal.Ciudad.equals(stringSucursal)){
                return sucursal;
            }
        }
        return null;
    }
    /*
     * Este método quita la primera instancia encontrada de la sucursal con el nombre del parámetro
     * No asegura que no haya elementos duplicados luego de ejecutarse
     */
    public boolean quitarSucursal(String stringSucursal) { // O(n)
        Sucursal sucursal = buscarSucursal(stringSucursal);
        if(sucursal!= null){
            return lista.remove(sucursal);
        }
        return false;
    }

    public String listarSucursales() { // O(n)

        return lista.toArray().toString();
    }

    public String[] listarSucursales(String str) { // O(n)
        String[] lis = new String[lista.size()];
        for(int i = 0; i<lista.size();i++){
            if(i != lista.size() -1){
                lis[i] = lista.get(i).Ciudad + str;
            }
            else{
                lis[i] = lista.get(i).Ciudad;
            }
        }
        return lis;
    }

    public int cantidadDeSucursales() { // O(N)
        return lista.size();
    }

    public boolean estaVacia() { // O(1)
        return lista.isEmpty();
    }
}
