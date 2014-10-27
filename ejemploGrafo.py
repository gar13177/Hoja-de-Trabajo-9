# Ejemplo de un grafo y sus recorridos
# emplea el modulo pygraph

# Import pygraph
from pygraph.classes.graph import graph
from pygraph.classes.digraph import digraph
from pygraph.algorithms.searching import breadth_first_search
from pygraph.algorithms.searching import depth_first_search


##from pygraph.readwrite.dot import write

# Graph creation (notar que se usa un grafo con direcciones)
gr = digraph()

# Add nodes and edges
gr.add_nodes(["a","b","c","d","e","f"])


gr.add_edge(("a", "b"))
gr.add_edge(("a", "d"))
gr.add_edge(("a", "f"))
gr.add_edge(("b", "c"))
gr.add_edge(("b", "f"))
gr.add_edge(("c", "d"))
gr.add_edge(("d", "b"))
gr.add_edge(("e","d"))
gr.add_edge(("e","f"))
gr.add_edge(("f", "d"))


print "\nEl grafo es: \n"
print gr

# recorrido breadth first
print "\nBreath first:\n"
st, order = breadth_first_search(gr, root="a")
print order


# recorrido depth first
print "\nDepth first: \n"
st, order, order2 = depth_first_search(gr, root="a")
print order

def pagerank(graph, damping_factor=0.85, max_iterations=100, min_delta=0.00001):
    nodes = graph.nodes()
    graph_size = len(nodes)
    if graph_size == 0:
        return {}
    min_value = (1.0-damping_factor)/graph_size #value for nodes without inbound links
    
    # itialize the page rank dict with 1/N for all nodes
    pagerank = dict.fromkeys("a", 1.0/graph_size)
        
    for i in range(max_iterations):
        diff = 0 #total difference compared to last iteraction
        # computes each node PageRank based on inbound links
        for node in nodes:
            rank = min_value
            for referring_page in graph.incidents("a"):
                rank += damping_factor * pagerank[referring_page] / len(graph.neighbors(referring_page))
                
            diff += abs(pagerank["a"] - rank)
            pagerank["a"] = rank
        
        #stop if PageRank has converged
        if diff < min_delta:
            break
    
    return pagerank
   
print pagerank
