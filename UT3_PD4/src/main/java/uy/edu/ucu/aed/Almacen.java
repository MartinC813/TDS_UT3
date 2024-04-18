package uy.edu.ucu.aed;

public class Almacen implements IAlmacen {
    private String direccion;
    private String telefono;
    private String nombre;


    Lista<IProducto> listaAlmacen = new Lista<IProducto> ();
    public String getDireccion(){
        return this.direccion;
    }

    public void setDireccion(String Direccion){
        this.direccion = Direccion;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public void setTelefono(String Telefono){
        this.telefono = Telefono;
    }

    public String getNombre(){
        return this.nombre;
    }

    public Lista<IProducto> getListaProductos(){
        return listaAlmacen;
    }
    
    public long nuevoStock(String url){
        ManejadorArchivosGenerico lector = new ManejadorArchivosGenerico();
        String [] lineasArchivo = lector.leerArchivo(url);
        long contador = 0;
        for(String linea : lineasArchivo){
            String [] lineas = linea.split(",");
            contador += Long.parseLong(lineas[2]) * Long.parseLong(lineas[3]);
            if (listaAlmacen.buscar(lineas[0]) != null){
                agregarStock(lineas[0],Integer.parseInt(lineas[3]));
            }
            else{
                Producto productoNuevo = new Producto(lineas[0], lineas[1], Integer.parseInt(lineas[2]), Integer.parseInt(lineas[3]));
                insertarProducto(productoNuevo);
            }
        }
        return contador;
    }
    public boolean ventaStock(String url){
        ManejadorArchivosGenerico lector = new ManejadorArchivosGenerico();
        String [] lineasArchivo = lector.leerArchivo(url);
        long contador = 0;
        for(String linea : lineasArchivo){
            String [] lineas = linea.split(",");
            if (listaAlmacen.buscar(lineas[0]) != null){
                listaAlmacen.buscar(lineas[0]).restarCantidadStock(Integer.parseInt(lineas[1]));
            }
        }
        return true;
    }

    public long obtenerValorStock(){
        Nodo<IProducto> actual = listaAlmacen.getPrimero();
        long total = 0;
        while(actual != null){
            IProducto producto = actual.getDato();
            total += producto.getPrecio() * producto.getStock();
            actual = actual.getSiguiente();
        }
        return total;
    }
    

    /**
     * Incorporar un nuevo producto al supermercado.
     *
     * @param unProducto
     */
    public void insertarProducto(IProducto unProducto){
        listaAlmacen.insertar(unProducto.getCodProducto(), unProducto);
    }

    /**
     * Eliminar productos que ya no se venden (por no ser comercializados m�s).
     *
     * @param clave
     * @return
     */
    public boolean eliminarProducto(Comparable codProducto){
        return listaAlmacen.eliminar(codProducto);
    }

    /**
     * Imprime la lista de productos
     *
     * @return
     */
    public String imprimirProductos(){
        return listaAlmacen.imprimir();
    }

    /**
     * Dado un separador ej.:",", ";", imprime los productos separados por tal
     * caracter
     *
     * @param separador
     * @return
     */
    public String imprimirSeparador(String separador){
        return listaAlmacen.imprimir(separador);
    }

    /**
     * Agregar stock a un producto existente.
     *
     * @param clave
     * @param cantidad
     * @return
     */
    public Boolean agregarStock(Comparable codProducto, Integer cantidad){
        IProducto prd = listaAlmacen.buscar(codProducto);
        if(prd != null){
            prd .agregarCantidadStock(cantidad);
            return true;
        }
        return false;
    }

    /**
     * Simular la venta de un producto (reducir el stock de un producto
     * existente
     *
     * @param clave
     * @param cantidad
     * @return
     */
    public Integer restarStock(Comparable codProducto, Integer cantidad){
        IProducto prd = listaAlmacen.buscar(codProducto);
        if(prd != null){
            prd.restarCantidadStock(cantidad);
            return 0;
        }
        return -1;
    }

    /**
     * Dado un código de producto, indicar las existencias del mismo en el
     * almac�n.
     *
     * @param clave
     * @return
     */
    public IProducto buscarPorCodigo(Comparable codProducto){
        return listaAlmacen.buscar(codProducto);
    }

    /**
     * Listar todos los productos registrados, ordenados por nombre, presentando
     * adem�s su stock. Imprime por consola la lista de todos los productos
     * registrados y su stock actual.
     */
    //No llegue a implementar la lista ordenada
    public void listarOrdenadoPorNombre(){
        
    }

    /**
     * Busca un producto por su descripci�n.
     *
     * @param descripcion
     * @return
     */
    public IProducto buscarPorDescripcion(String descripcion){
        return null;
    }

    /**
     * Retorna el tama�o del almacen: cantidad de productos. No es lo mismo que
     * el total de stock, sino que ser�a en definitiva el tama�o de la lista.
     *
     * @return
     */
    public int cantidadProductos(){
        return listaAlmacen.cantElementos();
    }

}
