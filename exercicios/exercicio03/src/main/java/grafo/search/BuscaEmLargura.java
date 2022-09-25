package src.main.java.grafo.search;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.main.java.grafo.core.Grafo;
import src.main.java.grafo.core.Vertice;

public class BuscaEmLargura {
   private static BuscaEmLargura instance;

   public static BuscaEmLargura getInstance() {
      if (instance == null) {
         return new BuscaEmLargura();
      }

      return instance;
   }

   public List<String> buscar(Grafo grafo, String origem, String destino) {
      Queue<String> roloDeBarbante = new LinkedList<String>();
      LinkedHashSet<String> verticesVisitados = new LinkedHashSet<String>();
      Caminho caminho = new Caminho();

      roloDeBarbante.add(origem);

      while (!roloDeBarbante.isEmpty()) {
         String v = roloDeBarbante.poll();

         if (v.equals(destino)) {
            break;
         }

         for (Vertice u : grafo.getAdjacencias(v)) {
            String rotulo = u.getRotulo();

            if (!verticesVisitados.contains(rotulo)) {
               verticesVisitados.add(rotulo);
               caminho.ligar(rotulo, v);
               roloDeBarbante.add(rotulo);
            }
         }
      }

      return caminho.gerar(origem, destino);
   }


   public List<String> buscar(Grafo grafo) {
      Queue<String> roloDeBarbante = new LinkedList<>();
      List<String> marcados = new ArrayList<>();

      marcados.add(grafo.getVertices().get(0).getRotulo());
      roloDeBarbante.add(grafo.getVertices().get(0).getRotulo());
      while (roloDeBarbante.size() > 0) {
         String verticeAtual = roloDeBarbante.poll();

         for (Vertice u : grafo.getAdjacencias(verticeAtual)) {
            if (!marcados.contains(u.getRotulo())) {
               marcados.add(u.getRotulo());
               roloDeBarbante.add(u.getRotulo());
            }
         }
      }
      
      return marcados;
   }
}
