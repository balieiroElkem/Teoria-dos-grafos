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

      grafo.conectarVertices("A", "B");
      grafo.conectarVertices("A", "C");
      grafo.conectarVertices("A", "D");

      System.out.println("Grau do vértice A: " + grafo.getVertice("A").getGrau());
      System.out.println("Grau do vétice D: " + grafo.getVertice("D").getGrau());
      System.out.println("Grau do vétice C: " + grafo.getVertice("C").getGrau());

   }
}
