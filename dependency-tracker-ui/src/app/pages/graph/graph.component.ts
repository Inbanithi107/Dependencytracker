import { AfterViewInit, Component, ElementRef, OnDestroy, OnInit, ViewChild } from "@angular/core";
import { GraphService } from "../../core/services/graph.service";
import { map, Observable } from "rxjs";
import { Bean } from "../../shared/models/bean";
import cytoscape from "cytoscape";
import { GraphInitializerService } from "../../core/services/graph-initializer.service";

@Component({
    selector: 'app-graph',
    templateUrl: './graph.component.html',
    standalone: true
})
export class GraphComponent implements AfterViewInit, OnInit, OnDestroy {

    @ViewChild('graphContainer', { static: true })
    graphContainer!: ElementRef<HTMLDivElement>;

    private cy!: cytoscape.Core;

    constructor(private graphService: GraphService, private graphInitializerService: GraphInitializerService) {
        this.data$ = graphService.graph$
    }

    data$: Observable<Bean[]>;

    

    ngAfterViewInit(): void {
        this.cy = cytoscape({
            container: this.graphContainer.nativeElement
        });
        this.graphInitializerService.initializeGraphContainer(this.data$, this.cy);
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