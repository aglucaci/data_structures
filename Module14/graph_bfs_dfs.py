#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Dec 11 13:50:22 2019

@author: alex
"""
# =============================================================================
# Imports
# =============================================================================
# ~ inspired by Edd Mann ~ #
import networkx as nx
import matplotlib.pyplot as plt

# =============================================================================
# Helper functions
# =============================================================================

def bfs(graph, start):
    ## create empty list to add the nodes visited to
    visited = []

    ## create queue with the start node in it
    queue = [start]

    ## if the queue still has stuff in it
    while not len(queue) == 0:

        ## figure out which vertex is in the front of the list and remove it
        nodeFrontQueue = queue.pop(0)

        ## if it has not been visited yet
        if nodeFrontQueue not in visited:
            ## add it to the visited list
            visited.append(nodeFrontQueue)
            ## add all its neighbors to queue in numerical order
            queue.extend(sorted(nx.all_neighbors(graph, nodeFrontQueue)))

    ## return list of nodes in visited order
    return visited

def dfs(graph, start):
    ## create empty list for visited nodes
    visited = []

    ## make stack for the next to visit
    stack = [start]

    ##
    while not len(stack) == 0:
        vertex = stack.pop()
        if vertex not in visited:
            visited.append(vertex)
            stack.extend(reversed(sorted(nx.all_neighbors(graph, vertex))))
    return visited

# =============================================================================
# Main subroutine.
# =============================================================================
print("Setting up graph.")

G = nx.Graph()
G.add_nodes_from([1, 2, 3, 4, 5, 6, 7,8, 9, 10])
G.add_edges_from([(1, 2), (2, 3), (1, 5), (1,4), (2, 6), (2, 7), (8, 9), (9,10), (6, 10)])


#BFS
print("Doing bfs..")
bfslist = bfs(G, 1)

print(bfslist)

nx.draw(G, with_labels=True, font_weight='bold')
plt.show()

#DFS
print("Doing dfs..")
dfslist = dfs(G, 1)

print(dfslist)
   
nx.draw(G, with_labels=True, font_weight='bold')
plt.show()
# =============================================================================
# End of file.
# =============================================================================
