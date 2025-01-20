public class App {
    public static void main(String[] args) throws Exception {
        int[] array = { 13, 89, 4, 56, 87, 98, 10, 2 };
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length - 1; i++) { //for que percorre todos os itens do array original (desordenado)
 
            if (i == 0) { 
                sortedArray[i] = array[i]; //se for o primeiro item do array, ele é inserido sem necessidade de comparações, pois 
                                            //possui apenas um elemento
            } else { 
                int j = i - 1;
                while (j >= 0 && array[i] < sortedArray[j]) { // este for serve para ir arrastando para a direita os numeros maiores que o valor atual,
                                                                //no vetor ordenado (para de arrastar ate encontrar um numero menor ou igual ao valor atual)
                    sortedArray[j + 1] = sortedArray[j];
                    j--;
                }
                sortedArray[j + 1] = array[i]; //ao encontrar um valor menor que o atual o valor é inserido uma posição a direita dele, 
            }
        }

        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }
}
