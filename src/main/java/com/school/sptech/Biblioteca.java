package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public Biblioteca(String nome, Double multaDiaria){
        this.nome = nome;
        this.multaDiaria = multaDiaria;
        this.qtdLivros = 0;
        this.ativa = true;
    }

    public Boolean getAtiva() {
        return ativa;
    }
    public Integer getQtdLivros() {
        return qtdLivros;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getMultaDiaria() {
        return multaDiaria;
    }

    public void registrarLivro(Integer quantidade){
        if(quantidade != null && quantidade > 0 && ativa == true){
            qtdLivros += quantidade;
        }
    }
    public Integer emprestar(Integer quantidade){
        if(ativa == true && quantidade != null && quantidade > 0 && quantidade <= qtdLivros){
            qtdLivros -= quantidade;
            return quantidade;
        } else {
            return null;
        }
    }

    public Integer devolver(Integer quantidade){
        if(ativa == true && quantidade != null && quantidade > 0){
            qtdLivros += quantidade;
            return quantidade;
        } else {
            return null;
        }
    }

    public Integer desativar(){
        if(ativa == false){
            return null;
        } else {
            ativa = false;
            Integer qtdLivrosFinal = qtdLivros;
            qtdLivros = 0;
            return qtdLivrosFinal;
        }
    }

    public void transferir(Biblioteca destino, Integer quantidade){
        if(quantidade != null && destino.ativa == true && ativa == true && quantidade <= qtdLivros){
            destino.qtdLivros += quantidade;
            qtdLivros -= quantidade;
        }
    }

    public Boolean reajustarMulta(Double percentual){
        if(percentual != null && percentual > 0){
            multaDiaria += multaDiaria * percentual;
            return true;
        } else{
            return false;
        }
    }

}


