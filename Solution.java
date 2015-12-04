import java.util.ArrayList;

public class Solution {
	private Graph g;
	private ArrayList<Pair> path;
	private int current, start;
	
	public Solution (Graph g, int start){
		this.g = g;
		this.current = start;
		this.start = start;
		this.path = new ArrayList<Pair>();
	}
	
	public Solution (Graph g, ArrayList<Pair> path, int current, int start){
		this.g = g;
		this.current = current;
		this.path = path;
		this.start = start;
	}
	
	public boolean isValid(){
		if(current != start) return false;
		
		int numNodes = g.getNumNodes();
		
		for(int i = 0; i < numNodes; i++){
			for(int j = 0; j < numNodes; j++){
				if(g.getEdge(i, j)){
					//check if the current path contains this edge,
					// if it doesn't then return false
					if(!pathContains(i, j)) return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean pathContains(int x, int y){
		for(Pair p : path){
			if(p.getX() == x && p.getY() == y) return true;
			//can work in either direction...
			if(p.getX() == y && p.getY() == x) return true;
		}
		
		return false;
	}
	
	public ArrayList<Solution> generateSubsolutions(){
		ArrayList<Solution> ret = new ArrayList<Solution>(4);
		
		int numNodes = g.getNumNodes();
		
		for(int j = 0; j < numNodes; j++){
			if(g.getEdge(current, j)){
				//there's a connection, need to build a solution
				Pair newEdge = new Pair(current, j);
				ArrayList<Pair> newPath = new ArrayList<Pair>(path);
				newPath.add(newEdge);
				ret.add(new Solution(g, newPath, j, start));
			}
		}
		
		return ret;
	}
	
	public String toString(){
		if (path == null || path.isEmpty()) return "";
		
		int sizeOfArray = 1 + 2 * path.size();
		char[] chars = new char[sizeOfArray];
		chars[0] = Graph.inttochar(path.get(0).getX());
		int place = 1;
		
		for(int i = 0; i < path.size(); i++){
			chars[place++] = '-';
			chars[place++] = Graph.inttochar(path.get(i).getY());
		}
		
		return new String(chars);
	}
	
}
