import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Bean } from "../../shared/models/bean";

@Injectable({providedIn: 'root'})
export class GraphApi {

    constructor(private http: HttpClient){

    }

    getGraphData(){
        return this.http.get<Bean[]>('http://localhost:8080/graph');
    }

}