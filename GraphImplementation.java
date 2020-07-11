package graphs;
import java.util.ArrayList;
import java.util.*;

public class GraphImplementation {
	
// class containing vertexes and edges of a graph
	class Graph
	{
		Object vertex;
		ArrayList<Object> adjNodes=new ArrayList<Object>();
	}
	
	
// ArrayList To Store Vertexes and Edges.
	ArrayList<Graph> nodeList = new ArrayList<Graph>(); 
	
	
// Using Node Class to Create Nodes For The Graph 
	public void addNode(Object vertex)
	{
		Graph node = new Graph();
		if(getVertex(vertex) == null)
		{
			node.vertex = vertex;
			nodeList.add(node);
		}
		else
		{
			System.out.println("Node Already Exists");
		}
	}
	
	
// Using checkAndAddEdge method to add directed edge and creating vertex if it does not exists 	
	public void addDirectedEdge(Object source, Object destination)
	{
		if(!isVertex(source))
		{
			addNode(source);
		}
		else if(!isVertex(destination))
		{
			addNode(destination);
		}
		
		checkAndAddEdge(source,destination);
	}
	
	
// Using checkAndAddEdge method to add Undirected edge and creating vertex if it does not exists 		
	public void addUnDirectedEdge(Object source, Object destination)
	{
		if(!isVertex(source))
		{
			addNode(source);
		}
		else if(!isVertex(destination))
		{
			addNode(destination);
		}
		
		checkAndAddEdge(source,destination);
		
		checkAndAddEdge(destination,source);
	}
	
	
/* Deleting Vertex from NodeList and removing it from all paths by using 
removeNodeFromPaths method. */

	public void deleteNode(Object nodeToBeDeleted)
	{
		if(nodeList != null)
		{
			for(int i=0;i<nodeList.size();i++)
			{
				if(nodeList.get(i).vertex == nodeToBeDeleted)
				{
					nodeList.remove(i);
					removeNodeFromPaths(nodeToBeDeleted);
				}
			}
		}
		else
		{
			System.out.println("No Nodes Exists");
		}
	}

	
// Deleting an edge if it exists by checking the adjNodes list	
	public void deleteEdge(Object source,Object destination)
	{
		if(nodeList != null)
		{
			for(int i=0;i<nodeList.size();i++)
			{
				if(nodeList.get(i).vertex == source && nodeList.get(i).adjNodes.contains(destination))
				{
					nodeList.get(i).adjNodes.remove(destination);
				}
			}
		}
		else
		{
			System.out.println("No Nodes Exists");
		}
	}

	
// After Deleting a Vertex it is also to be deletes from any paths if it exists in them.	
	private void removeNodeFromPaths(Object vertex)
	{
		if(nodeList != null)
		{
			for(int i=0;i<nodeList.size();i++)
			{
				if(nodeList.get(i).adjNodes.contains(vertex))
				{
					nodeList.get(i).adjNodes.remove(vertex);
				}
			}
		}
		else
		{
			System.out.println("No Nodes Exists");
		}

	}

	
// Iterating over nodeList to return vertex if it exists.		
	public Graph getVertex(Object vertex)
	{
		for(int i=0;i<nodeList.size();i++)
		{
			if(nodeList.get(i).vertex == vertex)
			{
				return nodeList.get(i);
			}
		}
		return null;
	}

	
// Iterating over nodeList to check if a vertex exists.	
	public boolean isVertex(Object vertex)
	{
		for(int i=0;i<nodeList.size();i++)
		{
			if(nodeList.get(i).vertex == vertex)
			{
				return true;
			}
		}
		return false;
	}
	
	
// Using for loop to iterate over adjNodes list to check if edge already exists 
	public boolean isEdge(ArrayList<Object> adjNodes,Object destination)
	{
		for(int i=0;i<adjNodes.size();i++)
		{
			if(adjNodes.get(i) == destination)
			{
				return true;
			}
		}
		return false;
	}
	
	
// Adding an Edge if it already does not exists by checking the Node List	
	public void checkAndAddEdge(Object source,Object destination)
	{
		if(!isEdge(getVertex(source).adjNodes,destination))
		{
			getVertex(source).adjNodes.add(destination);
		}
		
		else
		{
			System.out.println("Edge Already Exists");
		}
	}

	
// Updating value of a vertex by using for loops to check where is exists and then updating it.	
	public void updateNode(Object vertexToBeUpdated, Object newVertexValue)
	{
		for(int i=0;i<nodeList.size();i++)
		{
			if(nodeList.get(i).vertex == vertexToBeUpdated)
			{
				nodeList.get(i).vertex=newVertexValue;
			}
			for(int y=0;y<nodeList.get(i).adjNodes.size();y++)
			{
				if(nodeList.get(i).adjNodes.get(y) == vertexToBeUpdated)
				{
					nodeList.get(i).adjNodes.get(y);
				}
			}
		}		
	}
	
	
// Using for Loop To only display vertexes in a graph	
	public void printNodes()
	{
		if(nodeList!=null)
		{
			System.out.println("Nodes : ");
			for(int i=0;i<nodeList.size();i++)
			{
				System.out.println(nodeList.get(i).vertex);
			}
		}
	}
		
	
//Using for loops to Display the graph
	public void printGraph()
	{
		if(nodeList!=null)
		{
			System.out.println("Graph : ");
			for(int i=0;i<nodeList.size();i++)
			{
				System.out.print(nodeList.get(i).vertex+" -----> ");
				for(int y=0;y<nodeList.get(i).adjNodes.size();y++)
				{
					System.out.print(nodeList.get(i).adjNodes.get(y)+"  ");
				}
				System.out.println("");
			}
		}
	
	}
}
