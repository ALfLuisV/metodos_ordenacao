public class App {
    public static void main(String[] args) throws Exception {
        int[] array = { 13, 89, 22, 34, 4, 56 }; //array a ser ordenado
        int[] arrayAux = new int[array.length]; //array auxiliar

        mergeSort(array, arrayAux, 0, array.length - 1); 
    }

    private static void mergeSort(int[] v, int[] w, int ini, int fim) { 
        //metodo que realiza recursivamente a "fragmentação" do array (lembrando, que essa fragmentação é apenas conceitual,
        //pois a fragmentação é executada pela manipulação dos indices (ex: para pegar metade inicial do array, se utiliza 
        //os indices 0 (inicio) e (inicio + fim)/2, que é o meio)).

        //a recursividade neste metódo é utilizada para se fragmentar as subdivisões do array, ate se alcançar um unico elemento em cada subdivisão 
        if (ini < fim) {
            int meio = (ini + fim) / 2;
            mergeSort(v, w, ini, meio); // ex: este metodo so vai parar de chamar ele mesmo novamente, quando sua subdivisão possuir 1 unico elemento, e será retornado
            mergeSort(v, w, meio + 1, fim); //após o metodo anterior ser retornado, esta segunda call que abrange a segunda subdivisão do array que chegou, será executada, e novamente, retornara apenas quando alcançar um unico elemento
            intercalar(v, w, ini, meio, fim); //após as duas subdivisões possuirem 1 elemento, ou estarem ordenadas, este metodo irá fundir as duas subdivisões na ordem correta
         //lembrete: o metodo mergeSort só irá avançar para a proxima chamada de metodo, quando este retornar um array ordenado, ou um unico elemento, assim, chamando a proxima recursão
         //do mergeSort, ou o metodo intercalar
        }
    }

    private static void intercalar(int[] v, int[] w, int ini, int meio, int fim) {

        //este método esta responsavel por organizar os dois arrays subjacentes em um só, deixando os items na ordem pré determinada

        for (int k = ini; k <= fim; k++) {
            w[k] = v[k];
        }//cria uma copia do array original, para a manipulação dos elemetos nas posições do array, para se evitar perdas de valores

        //LEMBRETE: este metodo acessa apenas os elementos pelas posições do array original passadas, não sendo necessários copias previamente estabelecidas

        int i = ini;
        int j = meio + 1;

        for (int k = ini; k <= fim; k++) {
            if (i > meio) {
                v[k] = w[j++];
            } else if (j > fim) {
                v[k] = w[i++];
            } else if (w[i] < w[j]) {
                v[k] = w[i++];
            } else {
                v[k] = w[j++];
            }
        }
    }
}
