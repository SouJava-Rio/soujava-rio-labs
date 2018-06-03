
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Headers} from '@angular/http';
import { RequestOptions } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Rx';

import {JUG} from '../services/jug';
import {ConfigService} from './config.service';


@Injectable()
export class JUGService {

    private baseUrlService: string = '';
    private headers: Headers;
    private options: RequestOptions;

    constructor(private http: Http,
                private configService: ConfigService) {

        /**SETANDO A URL DO SERVIÇO REST QUE VAI SER ACESSADO */
        this.baseUrlService = configService.getUrlService();

        /*ADICIONANDO O JSON NO HEADER */
        this.headers = new Headers({ 'Content-Type': 'application/json;charset=UTF-8' });
        this.options = new RequestOptions({ headers: this.headers });
    }

    /**CONSULTA TODAS AS PESSOAS CADASTRADAS */
    getPessoas() {
        return this.http.get(this.baseUrlService + 'consultar').map(res => res.json());
    }

    /**ADICIONA UMA NOVA JUG */
    addPessoa(jug: JUG) {

        return this.http.post(this.baseUrlService + 'cadastrar', JSON.stringify(jug), this.options)
        .map(res => res.json());
    }

    /**EXCLUI UMA JUG */
    excluirPessoa(codigo: number) {

        return this.http.delete(this.baseUrlService + 'deletar/' + codigo).map(res => res.json());
    }

    /**CONSULTA UM JUG PELO CÓDIGO */
    getPessoa(codigo: number) {

        return this.http.get(this.baseUrlService + 'consultar/' + codigo).map(res => res.json());
    }

    /**ATUALIZA INFORMAÇÕES DA JUG */
    atualizarPessoa(jug: JUG) {

        return this.http.put(this.baseUrlService + 'editar', JSON.stringify(jug), this.options)
        .map(res => res.json());
    }
}
