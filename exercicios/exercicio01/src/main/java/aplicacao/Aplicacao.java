package src.main.java.aplicacao;

import java.util.List;
import src.main.java.grafo.core.Grafo;
import src.main.java.grafo.core.Vertice;

public class Aplicacao {
   public static void main(String[] args) throws Exception {
      Grafo grafo = new Grafo();

      grafo.adicionarVertice("A");
      grafo.adicionarVertice("B");
      grafo.adicionarVertice("C");
      grafo.adicionarVertice("D");
      grafo.adicionarVertice("E");
      grafo.adicionarVertice("F");
      grafo.adicionarVertice("G");

      grafo.conectarVertices("A", "B");
      grafo.conectarVertices("A", "E");
      grafo.conectarVertices("B", "C");
      grafo.conectarVertices("B", "D");
      grafo.conectarVertices("C", "D");
      grafo.conectarVertices("C", "G");
      grafo.conectarVertices("D", "E");
      grafo.conectarVertices("D", "F");
      grafo.conectarVertices("E", "F");
      grafo.conectarVertices("F", "G");

      System.out.println("Grau do vértice A: " + grafo.getVertice("A").getGrau());
      System.out.println("Grau do vértice B: " + grafo.getVertice("B").getGrau());
      System.out.println("Grau do vértice C: " + grafo.getVertice("C").getGrau());
      System.out.println("Grau do vértice D: " + grafo.getVertice("D").getGrau());
      System.out.println("Grau do vértice E: " + grafo.getVertice("E").getGrau());
      System.out.println("Grau do vértice F: " + grafo.getVertice("F").getGrau());
      System.out.println("Grau do vértice G: " + grafo.getVertice("G").getGrau());


      // Seção de testes
      if (grafo.graphCheckTrail("AD")) {
         System.out.println("É uma trilha");
      } else {
         System.out.println("Não é uma trilha");
      }

   }
}
