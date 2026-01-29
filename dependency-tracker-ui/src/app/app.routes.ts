import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: 'dependencyTracker',
        loadChildren: ()=> import('./pages/graph/graph.routes').then(m=> m.GRAPH_ROUTES)
    },

    {
        pathMatch: 'full',
        path: '',
        redirectTo: '/dashboard'
    },

    {
        path: 'dashboard',
        loadComponent: ()=>import('./pages/dashboard/dashboard.component').then(m=> m.DashBoardComponent)
    }

];
