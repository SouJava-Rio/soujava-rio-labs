import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { ConsultaComponent } from './app/jug/consulta/consulta.component';

import {CadastroComponent} from './app/jug/cadastro/cadastro.component';

import { HomeComponent } from './app/home/home.component';

const appRoutes: Routes = [
    { path: 'home',                    component: HomeComponent },
    { path: '',                        component: HomeComponent },
    { path: 'consulta-jug',         component: ConsultaComponent },
    { path: 'cadastro-jug',         component: CadastroComponent },
    { path: 'cadastro-jug/:codigo', component: CadastroComponent }

];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
