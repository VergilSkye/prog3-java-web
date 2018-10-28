package br.com.prog3.trab6.persistence;

import java.util.List;

import br.com.prog3.trab6.model.Aluno;
import br.com.prog3.trab6.controller.*;


public class Teste1 {

	public static void main(String[] args) {
		
		AlunoController ac = new AlunoController();
		
		ac.setMatricula(6660);
		ac.setNome("Demon");
		ac.setRa("Noru");
		ac.addAluno();
		System.out.println(ac.getMensagem());			
		
		
		
		
		

	}

}
