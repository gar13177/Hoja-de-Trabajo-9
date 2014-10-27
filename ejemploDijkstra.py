# Definicion de un grafo y uso del algoritmo de Dijkstra
# para encontrar la ruta mas corta entre un origen y todos
# los demas vertices

# Import pygraph
from pygraph.classes.graph import *
from pygraph.classes.digraph import *
from pygraph.algorithms.minmax import shortest_path
import unittest 
from pygraph.algorithms.pagerank import pagerank
# Graph creation
gr = digraph()

# Add nodes and edges
gr.add_nodes(["a","b","c","d","e","f"])


# notar que los vertices o edge, ahora tienen definido un peso
gr.add_edge(("a", "b"),3)
gr.add_edge(("a", "f"),5)
gr.add_edge(("a", "d"),4)
gr.add_edge(("b", "f"),1)
gr.add_edge(("b", "c"),1)
gr.add_edge(("f", "d"),2)
gr.add_edge(("c", "d"),2)
gr.add_edge(("d", "b"),3)
gr.add_edge(("e","f"),2)
gr.add_edge(("e","d"),3)


#mostrar el grafo
print "\nEl grafo: \n"
print gr


#### ruta mas corta, iniciando en Anchorage
st, dist = shortest_path(gr,"a")
# mostrar la ruta, indicada en el spanning tree
print "\nRuta:\n"
print st
# mostrar los valores de las rutas:
print "\nValores de la ruta mas corta, a cada vertice:\n"
print dist


print "\nPAGE RANK:\n"
r = pagerank(gr, damping_factor=0.85, max_iterations=100, min_delta=1e-05)
print r





