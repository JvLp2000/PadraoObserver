package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void deveNotificarUmFuncionario() {
        Companhia companhia = new Companhia("Tech Solutions");
        Funcionario funcionario = new Funcionario("Funcionario 1");
        funcionario.associar(companhia);
        companhia.mudarStatus("Em expansão");
        assertEquals("Funcionario 1, Status da companhia atualizado para: Em expansão", funcionario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarFuncionarios() {
        Companhia companhia = new Companhia("Tech Solutions");
        Funcionario funcionario1 = new Funcionario("Funcionario 1");
        Funcionario funcionario2 = new Funcionario("Funcionario 2");
        funcionario1.associar(companhia);
        funcionario2.associar(companhia);
        companhia.mudarStatus("Em expansão");
        assertEquals("Funcionario 1, Status da companhia atualizado para: Em expansão", funcionario1.getUltimaNotificacao());
        assertEquals("Funcionario 2, Status da companhia atualizado para: Em expansão", funcionario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarFuncionario() {
        Companhia companhia = new Companhia("Tech Solutions");
        Funcionario funcionario = new Funcionario("Funcionario 1");
        companhia.mudarStatus("Em expansão");
        assertNull(funcionario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarSomenteFuncionarioAssociado() {
        Companhia companhia1 = new Companhia("Tech Solutions");
        Companhia companhia2 = new Companhia("InovaTech");
        Funcionario funcionario1 = new Funcionario("Funcionario 1");
        Funcionario funcionario2 = new Funcionario("Funcionario 2");
        funcionario1.associar(companhia1);
        funcionario2.associar(companhia2);
        companhia1.mudarStatus("Em expansão");
        companhia2.mudarStatus("Em reestruturação");
        assertEquals("Funcionario 1, Status da companhia atualizado para: Em expansão", funcionario1.getUltimaNotificacao());
        assertEquals("Funcionario 2, Status da companhia atualizado para: Em reestruturação", funcionario2.getUltimaNotificacao());
    }
}
