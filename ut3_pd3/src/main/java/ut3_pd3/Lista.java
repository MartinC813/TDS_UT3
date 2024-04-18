package ut3_pd3;

//Estas implementaciones fueron subidas a webasignatura por los profesores, estando algunos metodos sin terminar. Decidi terminarlos e utilizar esta implementacion otorgada por ustedes. 
public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    /*
     * Si la lista esta vacia, el nuevo nodo a insertar pasara a ser el primer nodo de la lista, en caso de que contenga elementos, se recorre la lista hasta el ultimo elemento y
     * el siguiente del ultimo elemento sera el nuevo elemento a insertar. 
     * Precondiciones: Elementos validos para la creación del nodo.
     * Poscondiciones: Insertar correctamente al final de la lista. 
     */
   @Override 
    public boolean insertar (Comparable etiqueta, T dato ){
        Nodo<T> unNodo = new Nodo<T>(etiqueta,dato);
        if (esVacia()) {
            primero = unNodo;
        } else {
            Nodo<T> actual = primero;
           while(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
           }
           actual.setSiguiente(unNodo);
        }
        return true;
    }

    /*
     * Busca un nodo en la lista a partir de la etiqueta - "clave"
     * La etiqueta puede ser de cualquier tipo que implemente la interfaz "comparable"
     * Si la lista esta vacia retorna vacio. Sino, se recorre cada elemento de la lista y se compara su etiqueta con la clave, en caso de ser iguales se retorna el dato. Si no encuentra retorna null
     * Precondiciones: Pasar una clave valida
     * Poscondiciones: Recorrer la lista entera y comparar todos los datos de cada nodo hasta encontrar una coincidencia. Solo se trabaja con la primera coincidencia en caso de haber
     * mas de una.
     */
    @Override
    public T buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        }
        Nodo<T> aux = primero;
        while (aux != null) {
           if(aux.getEtiqueta() == clave){
            return aux.getDato();
           }
           aux = aux.getSiguiente();
        }

        return null;
    }

    /*
     * Si esta vacia automaticamente retornara false. En caso de que no, se hace un caso especial por si la lista solo tiene un elemento, en cuyo caso de comparara su dato y en caso de que de una coincidencia se elimina dicho nodo.
     * Sino, se recorre toda la lista, nodo por nodo comparando la etiqueta con la pasada por parametro, en caso de que encuentre al elemento, se busca que el anterior tenga la referencia del siguiente y el
     * elemento a eliminar pierda la referencia al siguiente, dejandolo completamente desvinculado de la lista.
     * Precondición: Pasar una clave valida
     * Poscondicion: No perder las referencias de los nodos de la lista y asi eliminar correctamente en caso de encontrar la clave pasada por parametro. En caso de haber más de una coincidencia
     * solo se trabaja con la primera. 
     */
    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        Nodo<T> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            Nodo<T> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if(aux.getSiguiente().getEtiqueta().equals(clave)){
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                aux.getSiguiente().setSiguiente(null);
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
    /*
     * Recorre la lista e imprime, con un metodo propio del nodo, su dato.
     */
    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            Nodo<T> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            Nodo<T> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo<T> aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }
}
