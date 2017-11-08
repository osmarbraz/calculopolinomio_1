/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplinas: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 * Baseado nos slides 85 da aula do dia 25/08/2017 
 * Cálculo de Polinômio - Exemplo 1
 *
 * Dada uma sequêencia de núumeros reais an, an−1, . . . , a1, a0, e um 
 * número real x, calcular o valor do polinôomio 
 *   Pn(x) = a(n)x^(n) + a(n−1)x^(n−1) + . . . + a1x + a0.
 */
public class Principal {

    /**
     * Cálcula o resultado do polinômio recursivamente.
     * Primeira solução indutiva, Hipótese de indução:
     * slides 85
     * 
     * @param A Coeficientes A = an, an−1,..., a1, a0 
     * @param x Um real x.
     * @return O resultado do cálculo do polinômio
     */
    public static float calcularPolinomio(float[] A, float x) {
        
        //Tamanho do vetor, quantidade de termos do polinomio
        int n = A.length;
        //Variável de retorno
        float P;

        // Quando restar apenas o último coeficiente, 
        // APENAS RETORNA (não é necessário multiplicar - grau de x = 0)
        if (n == 1) {
            P = A[0];
        } else {
            // Elimina recursivamente o primeiro coeficiente da matriz 
            // até que reste apenas um
            float[] ALinha = new float[n - 1];

            // n termos, grau do polinômio n-1
            // Meio de eliminar o elemento de grau n-1
            for (int i = 0; i < ALinha.length; i++) {
                ALinha[i] = A[i + 1];
            }
            float PLinha = calcularPolinomio(ALinha, x);
            float xn = 1;
            //Calcula o exponencial
            for (int i = 1; i <= ALinha.length; i++) {
                xn = xn * x;
            }
            //O elemento A[n] fica na posicao A[0]
            System.out.println("A[n-1]=" + A[0] + " xn=" + xn);
            //Acumula o resultado
            P = PLinha + A[0] * xn;
        }
        return P;
    }

    public static void main(String args[]) {
        //Vetor dos dados    

        float[] A = {2, 3, 1}; 
        int x = 2;
        // 2 * x^ + 3 * x + 1 * x
        
        System.out.println(">>> Cálculo de Polinômio - Exemplo 1 <<<");
        
        float resultado = calcularPolinomio(A, x);

        System.out.println("Resultado : " + resultado);      

    }
}
