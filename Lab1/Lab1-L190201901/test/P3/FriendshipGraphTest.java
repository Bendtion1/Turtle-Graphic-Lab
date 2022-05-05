package P3;

import static org.junit.Assert.*;

import org.junit.Test;

public class FriendshipGraphTest {
	@Test
	public void testAddVertex() {
	//	fail("Not yet implemented");
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		assertEquals(true,graph.pername.contains(rachel));
	    assertEquals(true,graph.pername.contains(ross));
	    assertEquals(true,graph.pername.contains(ben));
	    assertEquals(true,graph.pername.contains(kramer));
	}

	@Test
	public void testAddEdge() {
		//fail("Not yet implemented");
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		assertEquals(1,graph.people[graph.pername.indexOf(rachel)][graph.pername.indexOf(ross)]);
	    assertEquals(1,graph.people[graph.pername.indexOf(ross)][graph.pername.indexOf(rachel)]);
	    assertEquals(1,graph.people[graph.pername.indexOf(ross)][graph.pername.indexOf(ben)]);
	    assertEquals(1,graph.people[graph.pername.indexOf(ben)][graph.pername.indexOf(ross)]);
	}

	@Test
	public void testGetDistance() {
	//	fail("Not yet implemented");
		FriendshipGraph graph = new FriendshipGraph();
		Person senela = new Person("Senela");
		Person blair = new Person("Blair");
		Person chunk = new Person("Chunk");
		Person nate = new Person("Nate");
		Person dan = new Person("Dan");
		Person jenny = new Person("Jenny");
		graph.addVertex(senela);
		graph.addVertex(blair);
		graph.addVertex(chunk);
		graph.addVertex(nate);
		graph.addVertex(dan);
		graph.addVertex(jenny);
		graph.addEdge(senela, blair);
		graph.addEdge( blair,senela);
		graph.addEdge(blair, chunk);
		graph.addEdge( chunk,blair);
		graph.addEdge(chunk, nate);
		graph.addEdge(nate,chunk);
		graph.addEdge(nate, dan);
		graph.addEdge(dan,nate);
		graph.addEdge(dan, jenny);
		graph.addEdge(jenny,dan);
		graph.addEdge(jenny, senela);
		graph.addEdge(senela,jenny);
		assertEquals(0, graph.getDistance(senela,senela));  
		assertEquals(1, graph.getDistance(senela,blair));  
		assertEquals(2, graph.getDistance(senela, chunk));  
		assertEquals(3, graph.getDistance(senela, nate));  
		assertEquals(2, graph.getDistance(senela, dan));  
		assertEquals(1, graph.getDistance(senela, jenny)); 



	}

}
