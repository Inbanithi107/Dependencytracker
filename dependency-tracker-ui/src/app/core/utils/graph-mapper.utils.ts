import { Bean } from "../../shared/models/bean";
import { CircularEdge } from "../../shared/models/circular-edge.model";
import { GraphElement } from "../../shared/models/cytoscape-element.model";

export function mapDependenciesToGraphElements(data: Bean[]): GraphElement[] {

    const elements: GraphElement[] = [];

    const addedNodes = new Set<string>();

    const circularEdges = findCycles(data);

    data.forEach((item) => {
      if (!addedNodes.has(item.name)) {
        elements.push({
          data: { id: item.name, label: item.name.split(".").pop() },
        });
        addedNodes.add(item.name);
      }
      item.dependencies.forEach((dep) => {
        if (!addedNodes.has(dep)) {
          elements.push({ data: { id: dep, label: dep.split(".").pop() } });
          addedNodes.add(dep);
        }
        const isCircular = circularEdges.some((e)=> e.source===item.name && e.target===dep);
        elements.push({ data: { source: item.name, target: dep },
          classes: isCircular ? "circular" : ""
        });
      });
    });

    return elements;

}

export function findCycles(data: Bean[]): CircularEdge[] {
    const graph: Record<string, string[]> = {};

  data.forEach(item => {
    graph[item.name] = item.dependencies;
  });

  const visited = new Set<string>();
  const stack: string[] = [];
  const circularEdges: CircularEdge[] = [];

  function dfs(node: string): void {
    if (!graph[node]) return;

    
    if (stack.includes(node)) {
      const cycleStart = stack.indexOf(node);
      const cyclePath = stack.slice(cycleStart).concat(node);

      for (let i = 0; i < cyclePath.length - 1; i++) {
        circularEdges.push({
          source: cyclePath[i],
          target: cyclePath[i+1],
        });
      }
      return;
    }

    if (visited.has(node)) return;

    stack.push(node);

    for (const dep of graph[node]) {
      dfs(dep);
    }

    stack.pop();
    visited.add(node);
  }

  Object.keys(graph).forEach(node => {
    if (!visited.has(node)) {
      dfs(node);
    }
  });

  return circularEdges;
}