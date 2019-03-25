import java.util.ArrayList;
import java.util.Stack;

public class BuscaProfundidade {
	
	private Stack<Vertice> pilha = new Stack();
	private Vertice atualVertice;
	private Funcoes f = new Funcoes();
	ArrayList<Vertice> caminho = new ArrayList<Vertice> ();
	
	public boolean Busca(Vertice origem, Vertice destino) 
    {
    	
    	this.pilha.add(origem);
    	ArrayList<Aresta> arestasParaBuscar = f.listaArestasdoVertice(origem);
    	
    	if (isResultado(origem,destino))
    	{
    		//retornar o caminho
    		Resultado();
    	}
    	else
    	{
    		//expandir os proximos nos
    		
    		if(arestasParaBuscar != null)
    		{
        		for(int i = 0; i < arestasParaBuscar.size(); i++)
        		{
        			if(origem.cidade.equals(arestasParaBuscar.get(i).v1))
        			{
        				Busca(arestasParaBuscar.get(i).v2,destino);
        			}
        			else
        			{
        				Busca(arestasParaBuscar.get(i).v1,destino);
        			}
        			
        		}	
    		}

    	}
    	
    	this.pilha.pop();
    	return false;
    }
    
    private boolean isResultado(Vertice vertice, Vertice destino) {
    	return(vertice.cidade.equals(destino.cidade));	
    }
    
    private void Resultado ()
    {
    		
    	while(this.pilha.size() > 0)
    	{
    		this.caminho.add(this.pilha.pop());
    	}
    	
    }
	
}
