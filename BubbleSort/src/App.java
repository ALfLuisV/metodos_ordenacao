public class App {
    public static void main(String[] args) throws Exception {
        int[] array = { 13, 89, 4, 56, 87, 98, 10, 2 };

        int raioBubble = array.length; //variavel auxiliar para nos mostrar o intervalo de comparação do metodo
        for (int i = 0; i < array.length - 1; i++) { //o primeiro for percorre cada item do array (cada item comparado, diminui em 1, o intervalo do metodo)
            for (int j = 0; j < raioBubble - 1; j++) { // p/ cada item, ele será comparado com todos os outros items do vetor, 
                                                        //que estão dentro do intervalo de comparação
                int comp1 = j; 
                int comp2 = j + 1;
                if (array[comp1] > array[comp2]) {
                    int auxVar = array[comp2];
                    array[comp2] = array[comp1];
                    array[comp1] = auxVar;
                }
            }
            raioBubble--;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
