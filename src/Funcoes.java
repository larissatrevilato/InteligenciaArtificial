
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Funcoes {
	
	private Grafo G = new Grafo(new ArrayList<Vertice>(),new ArrayList<Aresta>());
	
	public Grafo recuperaGrafo()
	{
		Vertice v1,v2;
		try {
		  
		  System.out.println("\nIniciando processo de leitura do grafo ... \n");
	      FileReader arq = new FileReader("/home/larissa/eclipse-workspace/GrafoIA/src/romenia.txt");
	      BufferedReader lerArq = new BufferedReader(arq);
	      
	      String linha = lerArq.readLine(); 
	      
	      while (linha != null) {
		    	
	    	  	String [] infos = linha.split(" ");
		    	String vertice1 = infos[0];
		    	String vertice2 = infos[1];
		    	int peso = Integer.parseInt(infos[2]);
		    	
		    	Adiciona_Vertice(vertice1);
		    	Adiciona_Vertice(vertice2);
		    	
		    	Adiciona_Aresta(new Vertice(vertice1), new Vertice(vertice2),peso);
		    	
		        linha = lerArq.readLine();
	      }
	 
	      arq.close();
	    } catch (IOException e) {
	        System.err.printf("\nErro na abertura do arquivo: %s.\n",
	        e.getMessage());
	    }
	 
	    System.out.println("\nGrafo da romenia lido com sucesso!");
		
		return null;
	
	}
	
	public ArrayList<Vertice> consultaVertices()
	{
		return this.G.vertices;
	}
	
	
	
    public boolean Adiciona_Vertice(String cidade){
    	if (existeVertice(cidade))
    			return false;
    	else
    	{
    			Vertice v = new Vertice(cidade);
    			this.G.vertices.add(v);	
    			return true;
    	}	
	}
    
    public boolean existeVertice(String cidade){
    		
    	for (int i = 0; i < G.vertices.size(); i++){
    			Vertice obj = (Vertice) G.vertices.get(i);
    			if (obj.cidade.equals(cidade))
    				return true;
    	}

		return false;
	}
    
    public boolean Adiciona_Aresta(Vertice vertice1,Vertice vertice2,int peso){
    	
		if (existeVertice(vertice1.cidade) & existeVertice(vertice2.cidade)){
		
			Aresta verifica = this.G.getAresta(vertice1.cidade,vertice2.cidade);
			if(verifica == null)
			{
				Aresta nova = new Aresta();
				nova.peso = peso;
				nova.v1 = vertice1;
				nova.v2 = vertice2;
				this.G.arestas.add(nova);
				return true;
			}		
		}
    	
		return false;		
	}
    
    public boolean existeAresta(String nomeVertice1, String nomeVertice2){

    	for (int i = 0; i < this.G.arestas.size(); i++)
    	{
				Aresta obj = (Aresta) this.G.arestas.get(i);
				
				if((nomeVertice1.equals(obj.v1.cidade) && nomeVertice2.equals(obj.v2.cidade)) || (nomeVertice1.equals(obj.v2.cidade) && nomeVertice2.equals(obj.v1.cidade)))
						return true;
				
		}

		return false;
		
	}
    
    public  ArrayList<String> listaVerticesVizinhos(Vertice vertice){
		
		ArrayList<String> listaVertice = new ArrayList<String>();
	
		for (int i = 0; i < this.G.arestas.size(); i++){
				
				Aresta obj = (Aresta) this.G.arestas.get(i);
				
				if(vertice.cidade.equals(obj.getV1().cidade))
				{
					listaVertice.add(obj.getV2().cidade);
				}
				else if(vertice.cidade.equals(obj.getV2().cidade)){
					listaVertice.add(obj.getV1().cidade);
				}
		}
		
		return listaVertice;
	}
    
    public  ArrayList<Vertice> listaVerticedaAresta(Aresta aresta){
		ArrayList<Vertice> listaVertice = new ArrayList<Vertice>();
		for (int i = 0; i < G.vertices.size(); i++){
			Vertice obj = (Vertice) G.vertices.get(i);
			if(aresta.v1.cidade.equals(obj.cidade) || aresta.v2.cidade.equals(obj.cidade))
				listaVertice.add(obj);
		}
		return listaVertice;
	}
	
    public  ArrayList<Aresta> listaArestasdoVertice(Vertice vertice){
		ArrayList<Aresta> listaArestas = new ArrayList<Aresta>();
		
		for (int i = 0; i < G.arestas.size(); i++){
				Aresta obj = (Aresta) G.arestas.get(i);
				if(vertice.cidade.equals(obj.v1.cidade) || vertice.cidade.equals(obj.v2.cidade))
					listaArestas.add(obj);
		}

		
		return listaArestas;
	}

}
