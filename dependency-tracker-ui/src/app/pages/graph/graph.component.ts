import { AfterViewInit, Component, ElementRef, inject, OnDestroy, OnInit, ViewChild } from "@angular/core";
import { GraphService } from "../../core/services/graph.service";
import { map, Observable } from "rxjs";
import { Bean } from "../../shared/models/bean";
import cytoscape from "cytoscape";
import { mapDependenciesToGraphElements } from "../../core/utils/graph-mapper.utils";
import { CYTOSCAPE_STYLES } from "../../shared/graph/cytoscape.config";

@Component({
    selector: 'app-graph',
    templateUrl: './graph.component.html',
    standalone: true
})
export class GraphComponent implements AfterViewInit, OnInit, OnDestroy {

    @ViewChild('graphContainer', { static: true })
    graphContainer!: ElementRef<HTMLDivElement>;

    private cy!: cytoscape.Core;

    constructor(private graphService: GraphService){
        this.data$ = graphService.graph$
    }

    data$: Observable<Bean[]>;

    

    ngAfterViewInit(): void {
        this.data$.pipe(map(mapDependenciesToGraphElements)
        ).subscribe({
            next: (elements)=>{
                this.cy = cytoscape({
                    container: this.graphContainer.nativeElement,
                    elements: elements,
                    style: CYTOSCAPE_STYLES,
                    layout: {
                        name: 'cose',
                        animate: true
                    }
                })
            },
            error: (err)=>{
                console.error("Error resolving graph data:", err);
            }    
        });
    }

    ngOnInit(): void {
        this.graphService.loadGraphData();
    }

    ngOnDestroy(): void {
        if (this.cy) {
            this.cy.destroy();
        }
    }


}