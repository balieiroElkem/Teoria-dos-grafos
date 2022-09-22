package src.main.java.aplicacao;

import java.util.List;
import src.main.java.grafo.core.Grafo;
import src.main.java.grafo.core.Vertice;
import src.main.java.grafo.search.BuscaEmLargura;
import src.main.java.grafo.search.BuscaEmProfundidade;

public class Main {
   public static void main(String[] args) throws Exception {
      Grafo grafo = new Grafo();

      grafo.adicionarVertice("A");
      grafo.adicionarVertice("B");
      grafo.adicionarVertice("C");
      grafo.adicionarVertice("D");
      grafo.adicionarVertice("E");
      grafo.adicionarVertice("F");
      grafo.adicionarVertice("G");
      grafo.adicionarVertice("H");
      grafo.adicionarVertice("I");

      grafo.conectarVertices("A", "B");
      grafo.conectarVertices("A", "C");
      grafo.conectarVertices("A", "D");
      grafo.conectarVertices("B", "F");
      grafo.conectarVertices("B", "I");
      grafo.conectarVertices("D", "E");
      grafo.conectarVertices("D", "I");
      grafo.conectarVertices("D", "G");
      grafo.conectarVertices("I", "A");
      grafo.conectarVertices("I", "D");
      grafo.conectarVertices("I", "C");
      grafo.conectarVertices("I", "H");
      grafo.conectarVertices("E", "A");

      List<String> caminho = BuscaEmProfundidade.getInstance().buscar(grafo, "D", "H");

      System.out.print("Caminho feito por uma busca em profundidade: ");
      for (String passo : caminho) {
         System.out.print(passo + " ");
      }

      System.out.println("\n");

      caminho = BuscaEmLargura.getInstance().buscar(grafo, "B", "G");
      System.out.println();
      System.out.print("Caminho feito por uma busca em largura: ");
      for (String passo : caminho) {
         System.out.print(passo + " ");
      }

      System.out.println();
   }
}
