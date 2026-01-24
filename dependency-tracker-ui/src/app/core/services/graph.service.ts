import { Injectable } from "@angular/core";
import { GraphApi } from "../api/graph.api";
import { BehaviorSubject } from "rxjs";
import { Bean } from "../../shared/models/bean";


@Injectable({providedIn: 'root'})
export class GraphService {

    constructor(private graphApi: GraphApi){
        
    }

    private readonly graphSubject = new BehaviorSubject<Bean[]>([]);

    readonly graph$ = this.graphSubject.asObservable();

    loadGraphData(){
        if(this.graphSubject.value.length === 0){
            this.graphApi.getGraphData().subscribe({
                next: (data) => {
                    this.graphSubject.next(data);
                },
                error: (err) => {
                    console.error('Failed to load graph data', err);
                }
            });
    }

    }
}