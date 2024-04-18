package uy.edu.ucu.aed;

public class Producto implements IProducto{

    public Comparable codProducto;
    public String nombre;
    public Integer precio;
    public Integer stock;

    public Producto(Comparable CodProducto, String Nombre, Integer Precio, Integer Stock) {
        this.codProducto = CodProducto;
        this.nombre = Nombre;
        this.precio = Precio;
        this.stock = Stock;
    }
     /**
     * Retorna el codigo del Producto.
     *
     * @return codigo del Producto.
     */
    public Comparable getCodProducto(){
        return this.codProducto;
    }

    /**
     * Retorna el precio unitario del Producto.
     *
     * @return precio del Producto.
     */
    public Integer getPrecio(){
        return this.precio;
    }

    public void setPrecio(Integer Precio){
        this.precio = Precio;
    }

    /**
     * Retorna el stock del Producto.
     *
     * @return stock del Producto.
     */
    public Integer getStock(){
        return this.stock;
    }

    public void agregarCantidadStock(Integer Stock){
        this.stock += Stock;
    }

    public void restarCantidadStock(Integer Stock){
        this.stock -= Stock;
    }

    /**
     * Retorna la descripcion/nombre del Producto.
     *
     * @return descripci�n del Producto.
     */
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String Nombre){
        this.nombre = Nombre;
    }

}
