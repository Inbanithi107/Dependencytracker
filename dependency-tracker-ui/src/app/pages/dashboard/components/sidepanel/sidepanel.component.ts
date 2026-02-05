import { Component } from "@angular/core";
import { SidePanelState } from "./sidepanel.state";
import { AsyncPipe, CommonModule } from "@angular/common";


@Component({
    selector: 'app-side-panel',
    templateUrl: './sidepanel.component.html',
    standalone: true,
    imports: [AsyncPipe, CommonModule]
})
export class SidePanelComponent {

    constructor(private sidePanelState: SidePanelState) {
        this.selectedNode$ = this.sidePanelState.selectedNode$;
    }

    selectedNode$;

}