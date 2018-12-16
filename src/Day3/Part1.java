package Day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Part1 {
	
	static int resultado = 0;
	static int[][] tela = new int[1000][1000];

	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\Pablo\\VIEWNEXT\\AdventCode2018_Part_Java\\src\\Day3\\input.txt");
		
		int resultado = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			int[] coordenadaxY = new int[2654];
			int[] sizexY = new int[2654];
			int indice = 0;
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
				
				indice+=2;
			}
			
			
			
			poneraCero(tela);
			for(int i=0;i<coordenadaxY.length;i+=2) {
				pintarTela(coordenadaxY[i],coordenadaxY[i+1],sizexY[i],sizexY[i+1]);
			}
			
			resultadoTelad(tela);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	private static void resultadoTelad(int[][] tela) {
		for(int i=0;i<tela.length;i++) {
			for(int j=0;j<tela.length;j++) {
				System.out.println(tela[i][j]);
			}
		}
		
	}

	private static void poneraCero(int[][] tela) {
		for(int i=0;i<tela.length;i++) {
			for(int j=0;j<tela.length;j++) {
				tela[i][j] = 0;
			}
		}
	}
	
	private static void pintarTela(int x,int y, int sizeX, int sizeY) {
		
		for(int i=x;i<sizeY;i++) {
			for(int j=y;j<sizeX;i++) {
				if(tela[i][j]==1) {
					resultado++;
					tela[i][j]=2;
				}
				else {
					tela[i][j]=1;
				}
			}
		}
		
	}
	
	
}
