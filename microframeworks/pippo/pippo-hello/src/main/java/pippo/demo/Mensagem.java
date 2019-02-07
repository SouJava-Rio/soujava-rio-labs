package pippo.demo;

public class Mensagem {

    private String msg;
    private int ano;

    public Mensagem(String msg, int ano) {
        super();
        this.msg = msg;
        this.ano = ano;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}