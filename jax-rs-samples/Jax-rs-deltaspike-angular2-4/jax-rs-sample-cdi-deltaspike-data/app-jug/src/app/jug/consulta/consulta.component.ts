import { Component, OnInit } from '@angular/core';

import {Router} from '@angular/router';

import {JUGService} from '../../services/jug.service';

import {JUG} from '../../services/jug';

import {Response} from '../../services/response';

@Component({
   selector: 'app-consulta-pessoa',
   templateUrl: './consulta.component.html',
   styleUrls: ['./consulta.component.css']
 })
 export class ConsultaComponent implements OnInit {

   jugs: JUG[] = new Array();
   titulo: string;

   constructor(private jugService: JUGService,
               private router: Router) {}

   ngOnInit() {

     /*SETA O TÍTULO */
     this.titulo = 'Registros Cadastrados';

     /*CHAMA O SERVIÇO E RETORNA TODAS AS PESSOAS CADASTRADAS */
     this.jugService.getPessoas().subscribe(res => this.jugs = res);
   }

   /**EXCLUI UM REGISTRO QUANDO CLICAMOS NA OPÇÃO EXCLUIR DE UMA
    * LINHA DA TABELA*/
   excluir(codigo: number, index: number): void {

     if ( confirm('Deseja realmente excluir esse registro?')) {

       /*CHAMA O SERVIÇO PARA REALIZAR A EXCLUSÃO */
       this.jugService.excluirPessoa(codigo).subscribe(response => {

             /**PEGA O RESPONSE DO SERVIÇO */
             let res: Response = <Response>response;

             /*1 = SUCESSO
             * MOSTRAMOS A MENSAGEM RETORNADA PELO SERVIÇO E DEPOIS REMOVEMOS
             O REGISTRO DA TABELA HTML*/
             if ( res.codigo == 1 ) {
               alert(res.mensagem);
               this.jugs.splice(index, 1 );
             } else {
               /*0 = EXCEPTION GERADA NO SERVIÇO JAVA */
               alert(res.mensagem);
             }
         },
         (erro) => {
              /*MOSTRA ERROS NÃO TRATADOS */
              alert(erro);
         });
     }

   }

   editar(codigo: number): void {

     this.router.navigate(['/cadastro-jug', codigo]);

   }

 }
