import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean[][] edges; 
		
		Scanner scanner = new Scanner(System.in);
		
		int height = scanner.nextInt();
		int width = scanner.nextInt();
		int start = Graph.chartoint(scanner.next().charAt(0));
		
		edges = new boolean[width * height][width * height];
		
		height = height * 2 - 1;
		width = width * 2 - 1;
		
		scanner.nextLine();
		
		String[] input = new String[height];
		for(int i = 0; i < height; i++){
			input[i] = scanner.nextLine();
		}
		
		scanner.close();
		
		for(int i = 0; i < input.length; i++){
			System.out.println(input[i]);
		}
		
		/*
		edges = new boolean[9][9];
		
		edges[0][1] = true;
		edges[1][0] = true;
		edges[1][2] = true;
		edges[2][1] = true;
		edges[0][3] = true;
		edges[3][0] = true;
		edges[1][4] = true;
		edges[4][1] = true;
		edges[2][5] = true;
		edges[3][4] = true;
		edges[4][5] = true;
		edges[5][4] = true;
		edges[6][3] = true;
		edges[4][7] = true;
		edges[5][8] = true;
		edges[6][7] = true;
		edges[7][6] = true;
		edges[8][7] = true;
		
		*/
		
		/*
		//here is where actual code starts (after input)
		Graph g = new Graph(edges);
		Solution s = new Solution(g, 5);
		
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		solutions = s.generateSubsolutions();
		
		while(!anyAreValid(solutions)){
			ArrayList<Solution> newSolutions = new ArrayList<Solution>();
			for(Solution currentSolution : solutions){
				newSolutions.addAll(currentSolution.generateSubsolutions());
			}
			solutions = newSolutions;
		}
		
		*/
		
	}
	
	public static boolean anyAreValid(ArrayList<Solution> solutions){
		for(Solution s : solutions){
			if(s.isValid()){
				System.out.println(s.toString());
				return true;
			}
		}
		
		return false;
	}

}
