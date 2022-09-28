package src.main.java.aplicacao;

import java.util.List;
import src.main.java.grafo.core.Grafo;
// import src.main.java.grafo.core.Vertice;
import src.main.java.grafo.search.BuscaEmLargura;
import src.main.java.grafo.search.BuscaEmProfundidade;

public class Main {
   public static void main(String[] args) throws Exception {
      Grafo grafo1 = new Grafo(12);

      

      grafo1.adicionarVertice("A");
      grafo1.adicionarVertice("B");
      grafo1.adicionarVertice("C");
      grafo1.adicionarVertice("D");
      grafo1.adicionarVertice("E");
      grafo1.adicionarVertice("F");
      grafo1.adicionarVertice("G");
      grafo1.adicionarVertice("H");
      grafo1.adicionarVertice("I");
      grafo1.adicionarVertice("J");
      grafo1.adicionarVertice("K");

      grafo1.conectarVertices("A", "B");
      grafo1.conectarVertices("A", "C");
      grafo1.conectarVertices("B", "D");
      grafo1.conectarVertices("B", "E");
      grafo1.conectarVertices("D", "H");
      grafo1.conectarVertices("D", "I");
      grafo1.conectarVertices("C", "F");
      grafo1.conectarVertices("C", "G");
      grafo1.conectarVertices("F", "J");
      grafo1.conectarVertices("F", "K");


      System.out.println("Exemplo 1:");
      List<String> caminho = BuscaEmProfundidade.getInstance().buscar(grafo1);

      System.out.print("Caminho feito por uma busca em profundidade: ");
      for (String passo : caminho) {
         System.out.print(passo + " ");
      }

      System.out.printf("\n");

      caminho = BuscaEmLargura.getInstance().buscar(grafo1);
      System.out.print("Caminho feito por uma busca em largura: ");
      for (String passo : caminho) {
         System.out.print(passo + " ");
      }

      System.out.println();

      System.out.println("\nExemplo 2");
      Grafo grafo2 = new Grafo();

      grafo2.adicionarVertice("A");
      grafo2.adicionarVertice("B");
      grafo2.adicionarVertice("C");
      grafo2.adicionarVertice("D");
      grafo2.adicionarVertice("E");
      grafo2.adicionarVertice("F");
      grafo2.adicionarVertice("G");
      grafo2.adicionarVertice("H");
      grafo2.adicionarVertice("I");

      grafo2.conectarVertices("A", "B");
      grafo2.conectarVertices("A", "C");
      grafo2.conectarVertices("A", "D");
      grafo2.conectarVertices("B", "F");
      grafo2.conectarVertices("B", "I");
      grafo2.conectarVertices("D", "E");
      grafo2.conectarVertices("D", "I");
      grafo2.conectarVertices("D", "G");
      grafo2.conectarVertices("I", "A");
      grafo2.conectarVertices("I", "D");
      grafo2.conectarVertices("I", "C");
      grafo2.conectarVertices("I", "H");
      grafo2.conectarVertices("E", "A");

      caminho = BuscaEmProfundidade.getInstance().buscar(grafo2);

      System.out.print("Caminho feito por uma busca em profundidade: ");
      for (String passo : caminho) {
         System.out.print(passo + " ");
      }

      caminho = BuscaEmLargura.getInstance().buscar(grafo2);
      System.out.println();
      System.out.print("Caminho feito por uma busca em largura: ");
      for (String passo : caminho) {
         System.out.print(passo + " ");
      }

      System.out.println("\n\nExemplo 3");
      Grafo grafo3 = new Grafo();

      grafo3.adicionarVertice("A");
      grafo3.adicionarVertice("B");
      grafo3.adicionarVertice("C");
      grafo3.adicionarVertice("D");
      grafo3.adicionarVertice("E");

      grafo3.conectarVertices("A", "B");
      grafo3.conectarVertices("B", "E");
      grafo3.conectarVertices("B", "C");
      grafo3.conectarVertices("B", "D");
      grafo3.conectarVertices("D", "E");

      caminho = BuscaEmProfundidade.getInstance().buscar(grafo3);

      System.out.print("Caminho feito por uma busca em profundidade: ");
      for (String passo : caminho) {
         System.out.print(passo + " ");
      }

      caminho = BuscaEmLargura.getInstance().buscar(grafo3);
      System.out.println();
      System.out.print("Caminho feito por uma busca em largura: ");
      for (String passo : caminho) {
         System.out.print(passo + " ");
      }

      System.out.println("\n\nExemplo 4");
      Grafo grafo4 = new Grafo();

      grafo4.adicionarVertice("A");
      grafo4.adicionarVertice("B");
      grafo4.adicionarVertice("C");
      grafo4.adicionarVertice("D");
      grafo4.adicionarVertice("E");
      grafo4.adicionarVertice("F");

      grafo4.conectarVertices("A", "B");
      grafo4.conectarVertices("B", "C");
      grafo4.conectarVertices("C", "D");
      grafo4.conectarVertices("D", "E");
      grafo4.conectarVertices("D", "F");
      grafo4.conectarVertices("E", "F");

      caminho = BuscaEmProfundidade.getInstance().buscar(grafo4);

      System.out.print("Caminho feito por uma busca em profundidade: ");
      for (String passo : caminho) {
         System.out.print(passo + " ");
      }

      caminho = BuscaEmLargura.getInstance().buscar(grafo4);
      System.out.println();
      System.out.print("Caminho feito por uma busca em largura: ");
      for (String passo : caminho) {
         System.out.print(passo + " ");
      }


      System.out.println("\n\nExemplo 5");
      Grafo grafo5 = new Grafo();

      grafo5.adicionarVertice("A");
      grafo5.adicionarVertice("B");
      grafo5.adicionarVertice("C");
      grafo5.adicionarVertice("D");
      grafo5.adicionarVertice("E");
      grafo5.adicionarVertice("F");
      grafo5.adicionarVertice("G");
      grafo5.adicionarVertice("H");

      grafo5.conectarVertices("A", "B");
      grafo5.conectarVertices("A", "C");
      grafo5.conectarVertices("A", "E");
      grafo5.conectarVertices("B", "C");
      grafo5.conectarVertices("B", "D");
      grafo5.conectarVertices("C", "D");
      grafo5.conectarVertices("C", "G");
      grafo5.conectarVertices("C", "F");
      grafo5.conectarVertices("D", "H");
      grafo5.conectarVertices("E", "F");
      grafo5.conectarVertices("G", "H");

      caminho = BuscaEmProfundidade.getInstance().buscar(grafo5);

      System.out.print("Caminho feito por uma busca em profundidade: ");
      for (String passo : caminho) {
         System.out.print(passo + " ");
      }

      caminho = BuscaEmLargura.getInstance().buscar(grafo5);
      System.out.println();
      System.out.print("Caminho feito por uma busca em largura: ");
      for (String passo : caminho) {
         System.out.print(passo + " ");
      }
   }
}
