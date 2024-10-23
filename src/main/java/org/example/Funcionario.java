package org.example;

import java.util.Observable;
import java.util.Observer;

public class Funcionario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    // O funcionário começa a observar a companhia
    public void associar(Companhia companhia) {
        companhia.addObserver(this);
    }

    // Este método será chamado quando a companhia notificar seus observadores
    @Override
    public void update(Observable companhia, Object arg) {
        if (arg instanceof String) {
            this.ultimaNotificacao = this.nome + ", " + arg;
        } else {
            this.ultimaNotificacao = this.nome + ", houve uma atualização na companhia.";
        }
        System.out.println(this.ultimaNotificacao);
    }
}
