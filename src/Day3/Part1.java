package Day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Part1 {
	
	static int resultado = 0;
	static int[][] tela = new int[1000][1000];

	public static void main(String[] args) {
		
		URL path = Part1.class.getResource("input.txt");
		File file = new File(path.getFile());
		
		int resultado = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			int[] coordenadaxY = new int[2654];
			int[] sizexY = new int[2654];
			int indice = 0;
			poneraCero();
			while((line = br.readLine()) != null) {
				String[] words = line.split(" ");
				String coordenadas = words[2];
				String[] xY = coordenadas.split(",");
				coordenadaxY[indice]=Integer.parseInt(xY[0]);
				coordenadaxY[indice+1]=Integer.parseInt(xY[1].replace(":", ""));
				
				String cantidad = words[3];
				String[] cantidades = cantidad.split("x");
				sizexY[indice]=Integer.parseInt(cantidades[0]);
				sizexY[indice+1]=Integer.parseInt(cantidades[1]);
				
				pintarTela(coordenadaxY[indice], coordenadaxY[indice+1], sizexY[indice], sizexY[indice+1]);
				
				indice+=2;
			}
			
			resultadoTela();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	private static void poneraCero() {
		for(int i=0;i<tela.length;i++) {
			for(int j=0;j<tela.length;j++) {
				tela[i][j] = 0;
			}
		}
	}
	
	private static void pintarTela(int x,int y, int sizeX, int sizeY) {
		
		for(int i=y;i<y+sizeY;i++) {
			for(int j=x;j<x+sizeX;j++) {
				if(tela[i][j]==1) {
					resultado++;
					tela[i][j]=2;
				}
				else if(tela[i][j]==2) {
					tela[i][j]=2;
				}
				else {
					tela[i][j]=1;
				}
			}
		}	
		
		
	}

	private static void resultadoTela() {
		for(int i=0;i<tela.length;i++) {
			for(int j=0;j<tela.length;j++) {
				System.out.print(" "+tela[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("Resultado: "+resultado);
		
	}
	
	
}
