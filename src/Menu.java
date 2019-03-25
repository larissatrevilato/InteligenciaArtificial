import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	
	public static void main(String[] args) throws IOException {
		
		Funcoes f = new Funcoes();
		
		Grafo G = f.recuperaGrafo();
		ArrayList<Vertice> cidades = f.consultaVertices();
		ArrayList<Vertice> caminho;
		ArrayList<String> cidadesVizinhas;
		ArrayList<Aresta> arestasDoVertice;
		
		Vertice origem, destino;
		
		Scanner in = new Scanner(System.in);
		final String os = System.getProperty("os.name");
		int opcao, cidade1, cidade2;
		
		while(true) {
		
			System.out.println("\n------ Opcoes ------\n");
			System.out.println("1 - Mostrar todas as cidades");
			System.out.println("2 - Busca em superfície");
			System.out.println("3 - Busca de custo uniforme");
			System.out.println("4 - Busca em profundidade");
			System.out.println("5 - Busca com aprofundamento iterativo");
			System.out.println("6 - Lista Arestas de um Vertice");
			System.out.println("7 - Lista Vertices vizinhos de um Vertice");

			opcao = in.nextInt();
			Runtime.getRuntime().exec("clear");  
			
			switch(opcao)
			{
				case 1:
					
					System.out.println("\n------ Mostrar todas as cidades ------\n");
					

					for (int i = 1; i < cidades.size()+1; i++){
						System.out.println(i + " - " + cidades.get(i-1).cidade);
						
					}
					
					break;
					
				case 2:
					
					System.out.println("\n------ Busca em superfície ------\n");
					System.out.println("Para consultar os numeros das cidades, volte para a opcao 1 do menu");
					System.out.println("Digite o numero da cidade origem:");
					cidade1 = in.nextInt();
					System.out.println("Digite o numero da cidade destino:");
					cidade2 = in.nextInt();
					
					BuscaSuperficie buscaSup = new BuscaSuperficie ();
					
					origem = cidades.get(cidade1-1);
					destino = cidades.get(cidade2-1);
					
					if(buscaSup.Busca(origem, destino))
					{
						caminho = buscaSup.caminho;
						
						System.out.println("\n------ O caminho para busca em superficie é: ------\n");
						
						for (int i = 1; i < caminho.size(); i++){
							System.out.println(caminho.get(i).cidade);
						}
					}
					else
					{
						System.out.println("\nErro na busca!\n");
					}
					
					
					break;
					
				case 3: 
					
					System.out.println("\n------ Busca de custo uniforme ------\n");
					System.out.println("Para consultar os numeros das cidades, volte para a opcao 1 do menu");
					System.out.println("Digite o numero da cidade origem:");
					cidade1 = in.nextInt();
					System.out.println("Digite o numero da cidade destino:");
					cidade2 = in.nextInt();
					
					origem = cidades.get(cidade1-1);
					destino = cidades.get(cidade2-1);
					
					BuscaCustoUniforme buscaCusto = new BuscaCustoUniforme ();
					
					if(buscaCusto.Busca(origem, destino))
					{
						caminho = buscaCusto.caminho;
						
						System.out.println("\n------ O caminho para busca em Custo Uniforme é: ------\n");
						
						for (int i = 1; i < caminho.size(); i++){
							System.out.println(caminho.get(i).cidade);
						}
					}
					else
					{
						System.out.println("\nErro na busca!\n");
					}
					
					break;
					
				case 4:
					
					System.out.println("\n------ Busca em profundidade ------\n");
					System.out.println("Para consultar os numeros das cidades, volte para a opcao 1 do menu");
					System.out.println("Digite o numero da cidade origem:");
					cidade1 = in.nextInt();
					System.out.println("Digite o numero da cidade destino:");
					cidade2 = in.nextInt();
					
					BuscaProfundidade buscaProf = new BuscaProfundidade();
					origem = cidades.get(cidade1-1);
					destino = cidades.get(cidade2-1);
					
					if(buscaProf.Busca(origem, destino))
					{
						caminho = buscaProf.caminho;
						System.out.println("\n------ O caminho para busca em Profundidade é: ------\n");
						
						for (int i = 1; i < caminho.size(); i++){
							System.out.println(caminho.get(i).cidade);
						}
					}
					else
					{
						System.out.println("\nErro na busca!\n");
					}
					
					
					break;
					
				case 5:
					
					System.out.println("\n------ Busca com aprofundamento iterativo ------\n");
					System.out.println("Para consultar os numeros das cidades, volte para a opcao 1 do menu");
					System.out.println("Digite o numero da cidade origem:");
					cidade1 = in.nextInt();
					System.out.println("Digite o numero da cidade destino:");
					cidade2 = in.nextInt();
					
					BuscaAprofundamentoIterativo buscaItera = new BuscaAprofundamentoIterativo();
					origem = cidades.get(cidade1-1);
					destino = cidades.get(cidade2-1);
					
					if(buscaItera.Busca(origem, destino))
					{
						caminho = buscaItera.caminho;
					}
					
					break;
					
				case 6:
					
					System.out.println("\n------ Lista Arestas de um Vertice ------\n");
					System.out.println("Para consultar os numeros das cidades, volte para a opcao 1 do menu");
					System.out.println("Digite o numero da cidade (Vertice):");
					cidade1 = in.nextInt();
					
					System.out.println("\n------ As arestas que partem do vertice " + cidades.get(cidade1-1).cidade + " são: ------\n");
					
					arestasDoVertice = f.listaArestasdoVertice(cidades.get(cidade1-1));
					
					for(int i=0;i<arestasDoVertice.size();i++)
					{
						System.out.println(arestasDoVertice.get(i).v1.cidade + ", " + arestasDoVertice.get(i).v2.cidade + ", Peso: " + arestasDoVertice.get(i).peso);
					}
					
					break;
					
				case 7:

					System.out.println("\n------ Lista Vertices vizinhos de um Vertice ------\n");
					System.out.println("Para consultar os numeros das cidades, volte para a opcao 1 do menu");
					System.out.println("Digite o numero da cidade (Vertice):");
					cidade1 = in.nextInt();
					
					System.out.println("\n------ Os vertices vizinhos do vertice " + cidades.get(cidade1-1).cidade + " são: ------\n");
					
					cidadesVizinhas = f.listaVerticesVizinhos(cidades.get(cidade1-1));
					
					for(int i=0;i<cidadesVizinhas.size();i++)
					{
						System.out.println(cidadesVizinhas.get(i));
					}
					break;
					
				default:
					
					System.out.println("\n------ Opcao invalida! Tente novamente ------\n");
					break;
						
			}
		}
		
		
	
		
		
	}

}
