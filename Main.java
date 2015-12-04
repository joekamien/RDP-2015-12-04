import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int height = scanner.nextInt();
		int width = scanner.nextInt();
		int start = Graph.chartoint(scanner.next().charAt(0));
		
		Graph g = new Graph(width * height);
		
		height = height * 2 - 1;
		width = width * 2 - 1;
		
		scanner.nextLine();
		
		String[] input = new String[height];
		for(int i = 0; i < height; i++){
			input[i] = scanner.nextLine();
		}
		
		scanner.close();
		
		//have the input as an array of strings
		boolean inbetween = false;
		for(int i = 0; i < input.length; i++){
			String line = input[i];

			for(int j = inbetween ? 0 : 2; j < line.length(); j+= 4){
				
				char currentEdge = line.charAt(j);
				
				if(!inbetween){
					//there will only be left/right connections
					char left = line.charAt(j - 2);
					char right = line.charAt(j + 2);
					if(currentEdge == '-'){
						g.addEdge(left, right, true);
					} else if (currentEdge == '>'){
						g.addEdge(left, right);
					} else if (currentEdge == '<'){
						g.addEdge(right, left);
					}
				} else{
					//there will only be top to bottom connections
					char top = input[i-1].charAt(j);
					char bottom = input[i+1].charAt(j);
					if(currentEdge == '|'){
						g.addEdge(top, bottom, true);
					} else if (currentEdge == 'v'){
						g.addEdge(top, bottom);
					} else if (currentEdge == '^'){
						g.addEdge(bottom, top);
					}
				}
				
			}
			
			inbetween = !inbetween;
		}
		
		
		//here is where actual code starts (after input)
		Solution s = new Solution(g, start);
		
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		solutions = s.generateSubsolutions();
		
		while(!anyAreValid(solutions)){
			ArrayList<Solution> newSolutions = new ArrayList<Solution>();
			for(Solution currentSolution : solutions){
				newSolutions.addAll(currentSolution.generateSubsolutions());
			}
			solutions = newSolutions;
		}
		
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
