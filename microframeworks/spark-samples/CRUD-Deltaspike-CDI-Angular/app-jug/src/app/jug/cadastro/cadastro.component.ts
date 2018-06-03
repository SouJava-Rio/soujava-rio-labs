import { JUG } from './../../services/jug';
import { Component, OnInit } from '@angular/core';

import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import {JUGService} from '../../services/jug.service';

import {Response} from '../../services/response';

import { Observable } from 'rxjs/Observable';

import swal from 'sweetalert2';

@Component({
   selector: 'app-cadastro-pessoa',
   templateUrl: './cadastro.component.html',
   styleUrls: ['./cadastro.component.css']
 })
 export class CadastroComponent implements OnInit {

    titulo: string;
    acao: string;
    botao: string;
    jug: JUG = new JUG();

   constructor(private jugService: JUGService,
               private router: Router,
               private activatedRoute: ActivatedRoute) {}

   /*CARREGADO NA INICIALIZAÇÃO DO COMPONENTE */
   ngOnInit() {

     this.activatedRoute.params.subscribe(parametro => {

       if ( parametro['codigo'] == undefined ) {

         this.titulo = 'Novo Cadastro de JUG';
         this.acao = 'Salvar';
         this.botao = 'btn btn-primary btn-block';
       } else {

         this.titulo = 'Editar Cadastro de JUG';
         this.acao = 'Alterar';
         this.botao = 'btn btn-warning btn-block';
         this.jugService.getPessoa(Number(parametro['codigo'])).subscribe(res => this.jug = res);
       }


     });
   }

   /*FUNÇÃO PARA SALVAR UM NOVO REGISTRO OU ALTERAÇÃO EM UM REGISTRO EXISTENTE */
   salvar(): void {

     /*SE NÃO TIVER CÓDIGO VAMOS INSERIR UM NOVO REGISTRO */
     if ( this.jug.id == undefined ) {

       /*CHAMA O SERVIÇO PARA ADICIONAR UMA NOVA PESSOA */
       this.jugService.addPessoa(this.jug).subscribe(response => {

          // PEGA O RESPONSE DO RETORNO DO SERVIÇO
          let res: Response = <Response>response;

          /*SE RETORNOU 1 DEVEMOS MOSTRAR A MENSAGEM DE SUCESSO
          // E LIMPAR O FORMULÁRIO PARA INSERIR UM NOVO REGISTRO*/
          if (res.codigo == 1) {
            swal(
              res.mensagem,
              '',
              'success'
            ) ;
           this.jug = new JUG();
           this.router.navigate(['/consulta-jug']);
          } else {
            /*
            ESSA MENSAGEM VAI SER MOSTRADA CASO OCORRA ALGUMA EXCEPTION
            NO SERVIDOR (CODIGO = 0)*/
            swal(
              res.mensagem,
              '',
              'error'
            ) ;
          }
        },
        (erro) => {
          /**AQUI VAMOS MOSTRAR OS ERROS NÃO TRATADOS
            EXEMPLO: SE APLICAÇÃO NÃO CONSEGUIR FAZER UMA REQUEST NA API                        */
            swal(
              erro,
              '',
              'error'
            ) ;
        });

     } else {

       /* AQUI VAMOS ATUALIZAR AS INFORMAÇÕES DE UM REGISTRO EXISTENTE */
       this.jugService.atualizarPessoa(this.jug).subscribe(response => {

       // PEGA O RESPONSE DO RETORNO DO SERVIÇO
       let res: Response = <Response>response;

        /*SE RETORNOU 1 DEVEMOS MOSTRAR A MENSAGEM DE SUCESSO
          E REDIRECIONAR O USUÁRIO PARA A PÁGINA DE CONSULTA*/
       if ( res.codigo == 1 ) {
        swal(
          res.mensagem,
          '',
          'success'
        ) ;
         this.router.navigate(['/consulta-jug']);
       } else {
         /*ESSA MENSAGEM VAI SER MOSTRADA CASO OCORRA ALGUMA EXCEPTION
         NO SERVIDOR (CODIGO = 0)*/
         swal(
          res.mensagem,
          '',
          'error'
        ) ;
        }
      },
      (erro) => {
        /**AQUI VAMOS MOSTRAR OS ERROS NÃO TRATADOS
         EXEMPLO: SE APLICAÇÃO NÃO CONSEGUIR FAZER UMA REQUEST NA API                        */
         swal(
          erro,
          '',
          'error'
        ) ;
      });
     }

   }

 }
