package br.org.soujava.rio.helidon.model;

import java.io.Serializable;

import javax.json.Json;
import javax.json.JsonObject;

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

    public JsonObject forRest() {

        var builder = Json.createObjectBuilder();
        return builder.add("codigo", codigo)
                      .add("mensagem", mensagem)
                      .build();
    }
}
