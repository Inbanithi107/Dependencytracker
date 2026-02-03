import { map, Observable, tap } from "rxjs";
import { Bean } from "../../shared/models/bean";
import { GraphElement } from "../../shared/models/cytoscape-element.model";
import { mapDependenciesToGraphElements } from "../utils/graph-mapper.utils";
import { markMissingDependencies } from "../utils/graph-missing-dependency.utils";
import cytoscape from "cytoscape";
import { CYTOSCAPE_STYLES } from "../../shared/graph/cytoscape.config";
import { Injectable } from "@angular/core";
import { SidePanelState } from "../../pages/dashboard/components/sidepanel/sidepanel.state";

@Injectable({providedIn: 'root'})
export class GraphInitializerService {

    constructor(private sidePanelState: SidePanelState){}


    initializeGraph(data$: Observable<Bean[]>): Observable<GraphElement[]> {

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

    initializeGraphContainer(data$: Observable<Bean[]>, cy: cytoscape.Core): void {
        this.initializeGraph(data$)
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
                    this.initializeGraphEvents(cy);
                },
                error: (err)=> {
                    console.error("Error resolving graph data:", err);
                }
            });
}

    initializeGraphEvents(cy: cytoscape.Core){
        cy.on("tap", "node", (event)=>{
            const node: cytoscape.NodeSingular = event.target;
            this.sidePanelState.setSelectedNode({
                id: node.id(),
                label: node.data('label'),
                annotations: node.data('annotations'),
                outgoingEdges: node.outgoers('edge').targets().map(n=> n.id()),
                incomingEdges: node.incomers('edge').sources().map(n=> n.id())
            })
        });

        cy.on("tap", (event)=>{
            if (event.target === cy){
                this.sidePanelState.setSelectedNode(null);
            }
        });

    }
}