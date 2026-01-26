import { Bean } from "../../shared/models/bean";
import { GraphElement } from "../../shared/models/cytoscape-element.model";

export function markMissingDependencies(elements: GraphElement[], data: Bean[]): GraphElement[] {

  const existingNodes = new Set<string>(data.map(d => d.name));

  return elements.map(element => {
    if (element.data && element.data.id) {
      if (!existingNodes.has(element.data.id)) {
        return addClassToElement(element, "missing")
      }
    }
    if(element.data?.source && element.data?.target){
        if(!existingNodes.has(element.data.target)){
            return addClassToElement(element, "missing");
        }
    }
    return element;
  });
}

function addClassToElement(element: GraphElement, className: string): GraphElement {
    return {
        ...element,
        classes: element.classes ? `${element.classes} ${className}` : className
    }
}