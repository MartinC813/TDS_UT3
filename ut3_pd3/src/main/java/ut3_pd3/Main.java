package ut3_pd3;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
public class Main {
    public static void main(String[] args) {
        Lista<Integer> nuevaLista = new Lista<>();
        Nodo<Integer> nodo = new Nodo<Integer>("nodo1", 1);
        nuevaLista.insertar("nodo2", 2);
        nuevaLista.imprimir();
        nuevaLista.setPrimero(nodo);
        nuevaLista.imprimir();
        nuevaLista.insertar("nodo2", 2 );
        nuevaLista.imprimir();
        System.out.println(nuevaLista.buscar("nodo2"));
        System.out.println(nuevaLista.buscar("nodo1"));
    }
}