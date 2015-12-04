
public class Graph {
	private boolean[][] edges;
	
	public Graph(int numNodes){
		edges = new boolean[numNodes][numNodes];
	}
	
	public Graph(boolean[][] edges){
		this.edges = edges;
	}
	
	public void addEdge(char x, char y){
		edges[chartoint(x)][chartoint(y)] = true;
	}
	
	public void addEdge(char x, char y, boolean bothWays){
		addEdge(x,y);
		if (bothWays) addEdge(y,x); 
	}
	
	public static int chartoint (char c){
		return (int) c - 65;
	}
	
	public static char inttochar (int i){
		return (char) (65 + i);
	}
	
	public boolean getEdge(int x, int y){
		return edges[x][y];
	}
	
	public int getNumNodes(){
		return edges.length;
	}
}
