import { map, Observable, tap } from "rxjs";
import { Bean } from "../../shared/models/bean";
import { GraphElement } from "../../shared/models/cytoscape-element.model";
import { mapDependenciesToGraphElements } from "../utils/graph-mapper.utils";
import { markMissingDependencies } from "../utils/graph-missing-dependency.utils";
import cytoscape from "cytoscape";
import { CYTOSCAPE_STYLES } from "../../shared/graph/cytoscape.config";

export function initializeGraph(data$: Observable<Bean[]>): Observable<GraphElement[]> {

    return data$.pipe(
        map(data=>{
            const elements = mapDependenciesToGraphElements(data);
            return {elements, data}
        }),
        map(({elements, data})=> {
            return markMissingDependencies(elements, data);
        })
    );
}

export function initializeGraphContainer(data$: Observable<Bean[]>, cy: cytoscape.Core): void {
    initializeGraph(data$)
            .subscribe({
                next: (elements)=>{
                    cy = cytoscape({
                        container: cy.container(),
                        elements: elements,
                        style: CYTOSCAPE_STYLES,
                        layout: {
                            name: 'cose',
                            animate: true
                        }
                    });
                },
                error: (err)=> {
                    console.error("Error resolving graph data:", err);
                }
            });
}