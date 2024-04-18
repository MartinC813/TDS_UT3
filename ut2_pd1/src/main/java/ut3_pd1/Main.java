package ut3_pd1;

public class Main {
    public static void main(String[] args) {
        ManejadorArchivosGenerico nuevo = new ManejadorArchivosGenerico();
        String[] array = nuevo.leerArchivo("src\\main\\java\\ut3_pd1\\numeros.txt");
        funcion(array);
    }
    private static void funcion(String[] numeros){
        int contador = 0;
        for (int i = 1; i < numeros.length - 1; i++) {
            for (int j = numeros.length - 1; j > i; j--) {
                if(Integer.parseInt(numeros[j]) < Integer.parseInt(numeros[j-1])){
                    String aux = numeros[j - 1];
                    numeros[j - 1] = numeros[j];
                    numeros[j] = aux;
                    contador++;
                }
            }
        }
        //Utilizo el indice 1 ya que el 0 son la cantidad de numeros(100)
        System.out.println(numeros[1] + " " + numeros[numeros.length -1 ]);
        System.out.println("Contador = " + contador);
        System.out.println(numeros[0]);
    }
}