import java.util.ArrayList;
import java.util.Queue;

public class BuscaSuperficie {
	
	private Queue<Vertice> fila;
	private Funcoes f = new Funcoes();
	ArrayList<Vertice> caminho = new ArrayList<Vertice> ();
	
	
	public boolean Busca(Vertice origem, Vertice destino)
	{
		if(isResultado(origem,destino))
		{
			Resultado();
			return true;
		}
		else
		{
			ArrayList<Aresta> arestasParaBuscar = f.listaArestasdoVertice(origem);
			for(int i = 0; i < arestasParaBuscar.size(); i++)
    		{
				if(origem.cidade.equals(arestasParaBuscar.get(i).v1))
    			{
					this.fila.add(arestasParaBuscar.get(i).v2);
    			}
				else
				{
					this.fila.add(arestasParaBuscar.get(i).v1);
				}
    		}
			
			Vertice verticePonta = this.fila.poll();
			if(verticePonta != null && Busca(this.fila.poll(), destino))
			{
				return true;
			}
    			
		}
		
		return false;
	}
	
	private boolean isResultado(Vertice vertice, Vertice destino) {
    	return(vertice.cidade.equals(destino.cidade));	
    }
	
	private void Resultado ()
    {
    		
    	
    	
    }

}
