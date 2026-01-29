import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class SidePanelState {

    private selectedNodeSubject = new BehaviorSubject<SelectedNode | null>(null);

    readonly selectedNode$ = this.selectedNodeSubject.asObservable();

    setSelectedNode(node: SelectedNode | null) {
        this.selectedNodeSubject.next(node);
    }

}

export type SelectedNode = {
    id: string;
    label: string;
    incomingEdges: string[];
    outgoingEdges: string[];
}