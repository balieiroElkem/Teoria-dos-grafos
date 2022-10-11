package src.main.java.grafo.search;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Stack;

import src.main.java.grafo.core.Grafo;
import src.main.java.grafo.core.Vertice;

public class BuscaEmProfundidade {
   private static BuscaEmProfundidade instance;

   private BuscaEmProfundidade() {}

   public static BuscaEmProfundidade getInstance() {
      if (instance == null) {
         return new BuscaEmProfundidade();
      }

      return instance;
   }

   public List<String> buscar(Grafo grafo, String origem, String destino) {
      Stack<String> roloDeBarbante = new Stack<String>();
      LinkedHashSet<String> verticesVisitados = new LinkedHashSet<>();
      Caminho caminho = new Caminho();

      roloDeBarbante.push(origem);

      while (!roloDeBarbante.empty()) {
         String v = roloDeBarbante.pop();
         
         if (v.equals(destino)) {
            break;
         }

         for (Vertice u : grafo.getAdjacencias(v)) {
            String rotulo = u.getRotulo();
           
            if (!verticesVisitados.contains(rotulo)) {
               verticesVisitados.add(rotulo);
               caminho.ligar(rotulo, v);
               roloDeBarbante.push(rotulo);
            }
         }
      }

      return caminho.gerar(origem, destino);
   }

   
   public List<String> buscar(Grafo grafo) {
      Stack<String> roloDeBarbante = new Stack<>();
      List<String> marcados = new ArrayList<>();
      List<String> resultado = new ArrayList<>();

      roloDeBarbante.add(grafo.getVertices().get(0).getRotulo());
      marcados.add(grafo.getVertices().get(0).getRotulo());
      
      while (roloDeBarbante.size() > 0) {
         String verticeAtual = roloDeBarbante.pop();
         resultado.add(verticeAtual);

         for (Vertice u : grafo.getAdjacencias(verticeAtual)) {
            if (!marcados.contains(u.getRotulo())) {
               marcados.add(u.getRotulo());
               roloDeBarbante.add(u.getRotulo());
            }
         }
      }

      return resultado;
   }
}