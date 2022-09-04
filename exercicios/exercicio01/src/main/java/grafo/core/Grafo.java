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
   private MatrizAdjacencia matrizAdjacencia;


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

   private boolean existeVerticeOrThrow(String vertice) {
      if (!existeVertice(vertice)) {
         throw new IllegalArgumentException("O vértice não existe.");
      }

      return true;
   }

   private boolean existeVertice(String rotuloVertice) {
      int indice = this.rotulosEmIndices.get(rotuloVertice);

      return this.vertices.get(indice) != null ? true : false;
   }

   public Vertice getVertice(String rotulo) {
      this.existeVerticeOrThrow(rotulo);
      int indice = this.rotulosEmIndices.get(rotulo);

      return this.vertices.get(indice);
   }


   public void conectarVertices(String rotuloVerticeInicial, String rotuloVerticeFinal) throws Exception {
      if (!this.existeVertice(rotuloVerticeInicial) || !this.existeVertice(rotuloVerticeFinal)) {
         throw new Exception("Para adicionar uma aresta ambos os vértices devem existir.");
      }

      criarMatrizAdjacencia();

      int indiceVerticeFinal = this.rotulosEmIndices.get(rotuloVerticeInicial);
      int indiceVerticeInicial = this.rotulosEmIndices.get(rotuloVerticeFinal);

      this.matrizAdjacencia.adicionarAresta(indiceVerticeInicial, indiceVerticeFinal);
   }

   public List<Vertice> getAdjacencias(String vertice) {
      this.existeVerticeOrThrow(vertice);
      int indiceVertice = this.rotulosEmIndices.get(vertice);
      
      return this.matrizAdjacencia.getAdjacencias(indiceVertice);
   }

   private void criarMatrizAdjacencia() {
      if (this.matrizAdjacencia == null) {
         this.matrizAdjacencia = new MatrizAdjacencia(new ArrayList<Vertice>(this.vertices));
      }
   }


   public boolean graphCheckTrail(String seq) {
      Map<String, Integer> passos = new HashMap<>();
      boolean isTrail = true;

      for (int i = 0; i < seq.length()-1; ++i) {
         char c1 = seq.charAt(i);
         char c2 = seq.charAt(i+1);
         this.existeVerticeOrThrow("" + c1);
         this.existeVerticeOrThrow("" + c2);
         
         if (!this.getAdjacencias("" + c1).contains(this.getVertice("" + c2))) {
            System.err.println("Não são arestas");
            isTrail = false;
            break;
         } else if (passos.containsKey("" + c1 + c2) || passos.containsKey("" + c2 + c1)) {
            isTrail = false;
            break;
         } else {
            passos.put("" + c1 + c2, 1);
         }
      }

      
      return isTrail;
   }
}
