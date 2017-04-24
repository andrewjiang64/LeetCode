import java.util.*;

class Order {
	String order = "";
	public Order(String order) {
		this.order = order;
	}
}
class OrderDependency {
	Order current;
	Order depend;
	public OrderDependency(Order current, Order depend) {
		this.current = current;
		this.depend = depend;
	}
}

public class OrderDependencySolution {
	public HashMap<Order, Integer> Indegree;
	public OrderDependencySolution ()
	{
		this.Indegree = new HashMap<Order, Integer>();
	}
	public List<Order> getOrderList(List<OrderDependency> orders) {
		// write your code here
		this.Indegree = new HashMap<Order, Integer>();
		Queue<Order> queue = new LinkedList<Order>();
		HashMap<Order,List<Order>> orderTree = BuildTree(orders);
		List<Order> ret = new ArrayList<Order>();
		for(Map.Entry<Order, Integer> entry : this.Indegree.entrySet())
		{
			if(entry.getValue() == 0)
			{
				queue.offer(entry.getKey());
			}
		}
		while(!queue.isEmpty())
		{
			int size = queue.size();
			for(int i = 0; i < size; i++)
			{
				Order a = queue.poll();
				ret.add(a);
				List<Order> orderList = orderTree.get(a);
				for(int j = 0; j < orderList.size(); j++)
				{
					Indegree.put(orderList.get(j),Indegree.get(orderList.get(j)) - 1 );
					if(Indegree.get(orderList.get(j)) == 0)
						queue.offer(orderList.get(j));
				}
			}
		}
		return ret;
		
	}
	public HashMap<Order,List<Order>> BuildTree(List<OrderDependency> orders)
	{
		HashMap<Order, List<Order>> map = new HashMap<Order, List<Order>>();
		for(int i = 0; i < orders.size(); i++)
		{
			OrderDependency order = orders.get(i);
			Order Current = order.current;
			Order depency = order.depend;
			if(map.containsKey(depency))
			{
				List<Order> orderList = map.get(depency);
				orderList.add(Current);
				map.put(depency, orderList);
			}
			else
			{
				List<Order> orderList = new ArrayList<Order>();
				orderList.add(Current);
				map.put(depency , orderList);
			}
			if(!map.containsKey(Current))
			{
				map.put(Current, new ArrayList<Order>());
			}
			if(!Indegree.containsKey(depency))
				Indegree.put(depency, 0);
			Indegree.put(Current, Indegree.getOrDefault(Current, 0) + 1);
		}
		return map;
	}
	
	public static void main(String[] argc) {
		OrderDependencySolution solution = new OrderDependencySolution();
		Order a = new Order("A");
		Order b = new Order("B");
		Order c = new Order("C");
		Order d = new Order("D");
		Order e = new Order("E");
		Order f = new Order("F");
		Order g = new Order("G");
		Order h = new Order("H");
		
		// Test case 1
		List<OrderDependency> test1 = new ArrayList<>();
		OrderDependency ab = new OrderDependency(b, a);
		OrderDependency ac = new OrderDependency(c, a);
		OrderDependency be = new OrderDependency(e, b);
		OrderDependency ce = new OrderDependency(e, c);
		OrderDependency bd = new OrderDependency(d, b);
		OrderDependency ef = new OrderDependency(f, e);
		OrderDependency df = new OrderDependency(f, d);
		OrderDependency gh = new OrderDependency(h, g);
		test1.addAll(Arrays.asList(ab, ac, be, ce, bd, ef, df, gh));
		List<Order> result = solution.getOrderList(test1);
		System.out.println("Test case 1: ");
		print(result);

		// Test case 2
		List<OrderDependency> test2 = new ArrayList<>();
		OrderDependency bc = new OrderDependency(c, b);
		OrderDependency af = new OrderDependency(f, a);
		OrderDependency dh = new OrderDependency(h, d);
		OrderDependency eg = new OrderDependency(g, e);
		OrderDependency cd = new OrderDependency(d, c);
		OrderDependency fc = new OrderDependency(c, f);
		test2.addAll(Arrays.asList(ab, af, bc, be, fc, eg, cd, gh, dh));
		result = solution.getOrderList(test2);
		System.out.println("Test case 2: ");
		print(result);

		// Test case 3
		List<OrderDependency> test3 = new ArrayList<>();
		OrderDependency eh = new OrderDependency(h, e);
		test3.addAll(Arrays.asList(ab, eh, cd));
		result = solution.getOrderList(test3);
		System.out.println("Test case 3: ");
		print(result);
		
		// Test case 4
		List<OrderDependency> test4 = new ArrayList<>();
		OrderDependency fg = new OrderDependency(g, f);
		OrderDependency cf = new OrderDependency(f, c);
		OrderDependency hg = new OrderDependency(g, h);
		test4.addAll(Arrays.asList(eg, fg, cd, cf, ab, bc, ce, dh, hg));
		result = solution.getOrderList(test4);
		System.out.println("Test case 4: ");
		print(result);
				
		// Test case 5 (with circle)
		List<OrderDependency> test5 = new ArrayList<>();
		OrderDependency ca = new OrderDependency(a, c);
		test5.addAll(Arrays.asList(ab, bc, ca, ce));
		result = solution.getOrderList(test5);
		System.out.println("Test case 5: ");
		print(result);
				
		// Test case 6
		result = solution.getOrderList(new ArrayList<OrderDependency>());
		System.out.println("Test case 6: ");
		print(result);
				
		// Test case 7
		result = solution.getOrderList(Arrays.asList(ab, bc, cd, df));
		System.out.println("Test case 7: ");
		print(result);
				
		// Test case 8
		result = solution.getOrderList(Arrays.asList(ab, bc, bd, df, ce, fg, eh ));
		System.out.println("Test case 8: ");
		print(result);
	}
	
	private static void print(List<Order> orders) {
		for(Order i : orders) {
			System.out.print(i.order + " ");
		}
		System.out.println();
	}
}
