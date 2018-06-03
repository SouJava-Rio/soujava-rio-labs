import { Component, OnInit } from '@angular/core';

import {Router} from '@angular/router';

import {JUGService} from '../../services/jug.service';

import {JUG} from '../../services/jug';

import {Response} from '../../services/response';
import swal from 'sweetalert2';

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

    swal({
      title: 'Você tem certeza que deseja excluir este registro ?',
      text: "Você não poderá recuperar este registro após excluir !",
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Sim, deleta isto!'
    }).then((result) => {
      if (result.value) {
        /*CHAMA O SERVIÇO PARA REALIZAR A EXCLUSÃO */
       this.jugService.excluirPessoa(codigo).subscribe(response => {

                     /**PEGA O RESPONSE DO SERVIÇO */
                     let res: Response = <Response>response;

                     /*1 = SUCESSO
                     * MOSTRAMOS A MENSAGEM RETORNADA PELO SERVIÇO E DEPOIS REMOVEMOS
                     O REGISTRO DA TABELA HTML*/
                     if ( res.codigo == 1 ) {
                      swal(
                        res.mensagem,
                        '',
                        'success'
                      );
                       this.jugs.splice(index, 1 );
                     } else {
                       /*0 = EXCEPTION GERADA NO SERVIÇO JAVA */
                       // alert(res.mensagem);
                       swal(
                        res.mensagem,
                        '',
                        'error'
                      );
                     }
                 },
                 (erro) => {
                      /*MOSTRA ERROS NÃO TRATADOS */
                     // alert(erro);
                     swal(
                      erro,
                      '',
                      'error'
                    );
                 });
      }
    });

   }

   editar(codigo: number): void {

     this.router.navigate(['/cadastro-jug', codigo]);

   }

 }
