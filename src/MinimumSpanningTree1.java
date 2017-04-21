import java.util.*;

class Connection {
	String node1;
	String node2;
	int cost;
	public Connection(String node1, String node2, int cost) {
		this.node1 = node1;
		this.node2 = node2;
		this.cost = cost;
	}
}

public class MinimumSpanningTree1 {
	public String GetMinumIndex(HashMap<String, Integer> costs, HashMap<String, Boolean> visited)
	{
		int min = Integer.MAX_VALUE;
		String node = "";
		for(Map.Entry<String, Integer> entry : costs.entrySet())
		{
			String key = entry.getKey();
			Integer value = entry.getValue();
			if(visited.get(key) == false && value < min)
			{
				min = value;
				node = key;
			}
		}
		return node;
	}
	public ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
		if(connections == null || connections.size() == 0)
			return new ArrayList<Connection>();
		HashSet<String> set = new HashSet<String>();
		ArrayList<Connection> arrayList = new ArrayList<Connection>();
		HashMap<String, Connection> result = new HashMap<String, Connection>();
		for(int i =0 ; i < connections.size(); i++)
		{
			set.add(connections.get(i).node1);
			set.add(connections.get(i).node2);
		}
		HashMap<String, List<Connection>> map = new HashMap<String, List<Connection>>();
		for(int i =0 ; i < connections.size(); i++)
		{
		   if(map.containsKey(connections.get(i).node1))
		   {
			   List<Connection> list = map.get(connections.get(i).node1);
			   list.add(connections.get(i));
			   map.put(connections.get(i).node1, list);
		   }
		   else
		   {
			   List<Connection> list = new ArrayList<Connection>();
			   list.add(connections.get(i));
			   map.put(connections.get(i).node1, list);
		   }
		   if(map.containsKey(connections.get(i).node2))
		   {
			   List<Connection> list = map.get(connections.get(i).node2);
			   list.add(new Connection(connections.get(i).node2,connections.get(i).node1,connections.get(i).cost));
			   map.put(connections.get(i).node2, list);
		   }
		   else
		   {
			   List<Connection> list = new ArrayList<Connection>();
			   list.add(new Connection(connections.get(i).node2,connections.get(i).node1,connections.get(i).cost));
			   map.put(connections.get(i).node2, list);
		   }
		}
		HashMap<String, Integer> cost = new HashMap<String, Integer>();
		HashMap<String,Boolean> visited = new HashMap<String, Boolean>();
		for (String temp : set) {
	        cost.put(temp, Integer.MAX_VALUE);
	        visited.put(temp, false);
	     }
		cost.put(set.iterator().next(), 0);
		
		for(int i = 0; i < set.size() - 1; i++)
		{
			String u = GetMinumIndex(cost,visited);
			visited.put(u, true);
			List<Connection> connectionList = map.get(u);
			if(connectionList == null)
				return new ArrayList<Connection>();
			for(int j = 0; j < connectionList.size(); j++)
			{
				Connection tmp = connectionList.get(j);
				String node2 = tmp.node2;
				if(visited.get(node2) == false && tmp.cost < cost.get(node2))
				{
					cost.put(node2, tmp.cost);
					result.put(node2, tmp);
				}
			}
		}
		for(Map.Entry<String, Connection> entry : result.entrySet())
		{
			arrayList.add(entry.getValue());
		}
		return arrayList;
	}
	
	public static void main(String[] args) {
		MinimumSpanningTree1 solution = new MinimumSpanningTree1();
	    
	    // test case 1
	    ArrayList<Connection> connections = new ArrayList<>();
	    connections.add(new Connection("A", "B", 1));
	    connections.add(new Connection("B", "C", 3));
	    connections.add(new Connection("B", "E", 2));
	    connections.add(new Connection("C", "E", 7));
	    connections.add(new Connection("E", "A", 6));
	    connections.add(new Connection("D", "E", 5));
	    ArrayList<Connection> res = solution.getLowCost(connections);
	    System.out.println("test case 1: ");
	    for (Connection c : res){
	        System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
	    }
	    
	    // test case 2
	    connections = new ArrayList<>();
	    connections.add(new Connection("A", "B", 2));
	    connections.add(new Connection("B", "C", 2));
	    connections.add(new Connection("B", "D", 2));
	    connections.add(new Connection("C", "D", 2));
	    connections.add(new Connection("D", "A", 2));
	    connections.add(new Connection("A", "C", 2));
	    res = solution.getLowCost(connections);
	    System.out.println("test case 2: ");
	    for (Connection c : res){
	        System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
	    }
	    
	    // test case 3
	    connections = new ArrayList<>();
	    connections.add(new Connection("A", "B", 2));
	    connections.add(new Connection("B", "C", 2));
	    connections.add(new Connection("C", "D", 2));
	    connections.add(new Connection("D", "E", 2));
	    connections.add(new Connection("E", "F", 2));
	    connections.add(new Connection("G", "F", 1));
	    connections.add(new Connection("G", "E", 1));
	    connections.add(new Connection("G", "E", 1));
	    connections.add(new Connection("G", "D", 1));
	    connections.add(new Connection("G", "C", 1));
	    connections.add(new Connection("G", "B", 1));
	    connections.add(new Connection("G", "A", 1));
	    connections.add(new Connection("A", "F", 2));
	    res = solution.getLowCost(connections);
	    System.out.println("test case 3: ");
	    for (Connection c : res){
	        System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
	    }
	    
	    // test case 4
	    res = solution.getLowCost(null);
	    if(res == null) {
	    	System.out.println("test case 4 correct!");
	    } else {
	    	System.out.println("test case 4 fail!");
	    }
	    
	    // test case 5
	    res = solution.getLowCost(new ArrayList<Connection>());
	    if(res == null) {
	    	System.out.println("test case 5 correct!");
	    } else {
	    	System.out.println("test case 5 fail!");
	    }
	    
	    // test case 6
	    connections = new ArrayList<>();
	    connections.add(new Connection("A", "B", 1));
	    connections.add(new Connection("A", "C", 9));
	    connections.add(new Connection("A", "D", 4));
	    connections.add(new Connection("A", "E", 6));
	    connections.add(new Connection("B", "C", 1));
	    connections.add(new Connection("B", "D", 2));
	    connections.add(new Connection("B", "E", 8));
	    connections.add(new Connection("C", "D", 5));
	    connections.add(new Connection("D", "C", 7));
	    connections.add(new Connection("C", "E", 2));
	    connections.add(new Connection("D", "E", 3));
	    connections.add(new Connection("D", "F", 97));

	    res = solution.getLowCost(connections);
	    System.out.println("test case 6: ");
	    for (Connection c : res){
	        System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
	    }
	    
	    // test case 7
	    connections = new ArrayList<>();
	    connections.add(new Connection("A", "B", 1));
	    connections.add(new Connection("A", "C", 2));
	    connections.add(new Connection("C", "B", 7));
	    connections.add(new Connection("D", "E", 1));
	    connections.add(new Connection("F", "E", 8));
	    res = solution.getLowCost(connections);
	    if(res == null) {
	    	System.out.println("test case 7 correct!");
	    } else {
	    	System.out.println("test case 7 fail!");
	    }

	    // test case 8
	    connections = new ArrayList<>();
	    connections.add(new Connection("C", "E", 1));
	    connections.add(new Connection("F", "B", 2));
	    connections.add(new Connection("C", "A", 3));
	    connections.add(new Connection("C", "D", 4));
	    connections.add(new Connection("D", "E", 5));
	    connections.add(new Connection("G", "E", 6));
	    connections.add(new Connection("D" ,"I", 7));
	    connections.add(new Connection("I" ,"E", 8));
	    connections.add(new Connection("A", "K", 9));
	    connections.add(new Connection("A", "B", 10));
	    connections.add(new Connection("A", "H", 11));
	    connections.add(new Connection("K", "J", 12));
	    connections.add(new Connection("I", "G", 13));
	    connections.add(new Connection("F", "G", 14));
	    connections.add(new Connection("A", "J", 15));
	    connections.add(new Connection("J", "B", 16));
	    connections.add(new Connection("E", "H", 17));
	    res = solution.getLowCost(connections);
	    System.out.println("test case 8: ");
	    for (Connection c : res){
	        System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
	    }
	}
}

