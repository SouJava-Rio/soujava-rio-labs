package br.org.soujava.rio.jooby.model;

import java.io.Serializable;

public class ResponseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    public ResponseModel(int codigo, String mensagem) {
        super();
        this.codigo = codigo;
        this.mensagem = mensagem;
    }
    
    public ResponseModel() { }

    private int codigo;
    private String mensagem;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "ResponseModel [codigo=" + codigo + ", mensagem=" + mensagem + "]";
    }
}
