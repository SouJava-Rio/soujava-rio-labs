import { Component} from '@angular/core';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
  })
  export class HomeComponent {
        mensagem:string = 'Sejam Bem Vindos!';
        rodape:string = 'SouJava  Rio  2017 - por Daniel Dias .';
  }
