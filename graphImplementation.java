package graphs;
import java.util.ArrayList;
import java.util.*;

public class graphImplementation {
	
	class Node
	{
		Object vertex;
		ArrayList<Object> adjNodes=new ArrayList<Object>();
	}
	
	ArrayList<Node> nodeList = new ArrayList<Node>(); 
	
	// Using Node Class to Create Nodes For The Graph 
	public void addNode(Object vertex)
	{
		Node node = new Node();
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
	
	public Node getVertex(Object vertex)
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
	
	public boolean isEdge(ArrayList<Object> arrlist,Object destination)
	{
		for(int i=0;i<arrlist.size();i++)
		{
			if(arrlist.get(i) == destination)
			{
				return true;
			}
		}
		return false;
	}
	
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
