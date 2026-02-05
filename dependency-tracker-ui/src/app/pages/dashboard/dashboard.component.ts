import { Component } from "@angular/core";
import { GraphComponent } from "../graph/graph.component";
import { SidePanelComponent } from "./components/sidepanel/sidepanel.component";

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    standalone: true,
    imports: [GraphComponent, SidePanelComponent]
})
export class DashBoardComponent {

}