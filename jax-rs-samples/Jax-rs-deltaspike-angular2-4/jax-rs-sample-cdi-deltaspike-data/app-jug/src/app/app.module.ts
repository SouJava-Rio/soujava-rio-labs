import { MenuComponent } from './menu/menu.component';
import { JUGService } from './services/jug.service';
import { ConfigService } from './services/config.service';
import { Http, HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import {routing} from './../app.routes';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { CadastroComponent } from './jug/cadastro/cadastro.component';
import { ConsultaComponent } from './jug/consulta/consulta.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CadastroComponent,
    ConsultaComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    routing
  ],
  providers: [ConfigService, JUGService],
  bootstrap: [AppComponent]
})
export class AppModule { }
