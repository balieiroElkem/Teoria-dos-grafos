package src.main.java.grafo.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
   private List<Vertice> vertices = new ArrayList<Vertice>();
   private int qtdMaximaVertices;
   private int qtdAtualVertices;
   private boolean isQtdMaximaDefinida;
   private Map<String, Integer> rotulosEmIndices = new HashMap<String, Integer>();


   public Grafo() {
      qtdMaximaVertices = 10;
   }

   public Grafo(int qtdVertices) {
      if (qtdVertices <= 0) {
         throw new IllegalArgumentException("A quantidade máxima de vértices deve ser maior ou igual à 1.");
      }

      qtdMaximaVertices = qtdVertices;
      isQtdMaximaDefinida = true;
   }


   public void adicionarVertice(String rotulo) throws Exception {
      if (qtdAtualVertices <= qtdMaximaVertices - 1) {
         Vertice novoVertice = new Vertice(rotulo);
         this.vertices.add(novoVertice);
         this.rotulosEmIndices.put(rotulo, qtdAtualVertices);
         qtdAtualVertices++;
      } else {
         throw new Exception("A quantidade de vétices permitida (" + qtdMaximaVertices + ") foi excedida");
      }
   }

   public List<Vertice> getVertices() {
      return this.vertices;
   }

}
