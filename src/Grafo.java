import java.util.ArrayList;

public class Grafo {
	
	ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	ArrayList<Aresta> arestas = new ArrayList<Aresta>();	
	
	public Grafo(ArrayList<Vertice> arrayList, ArrayList<Aresta> arrayList2) {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Vertice> getVertices() {
		return (ArrayList<Vertice>) vertices;
	}
	
	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}
	
	public ArrayList<Aresta> getArestas() {
		return (ArrayList<Aresta>) arestas;
	}
	
	public void setArestas(ArrayList<Aresta> arestas) {
		this.arestas = arestas;
	}

	public Aresta getAresta(String vertice1, String vertice2) {
		
		
		for (int i = 0; i < this.arestas.size(); i++)
		{
			Aresta a = this.arestas.get(i);
			
			if ((a.v1.cidade == vertice1 && a.v2.cidade == vertice2) || (a.v2.cidade == vertice1 && a.v1.cidade == vertice2))
			{
				return a;
			}
		}
		return null;
	}
	

}
