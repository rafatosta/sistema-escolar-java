package org.rtosta;

import org.rtosta.dao.Aluno.AlunoDAO;
import org.rtosta.dao.Aluno.AlunoDAOFile;
import org.rtosta.dao.Aluno.AlunoDAOList;
import org.rtosta.model.Aluno;

public class Main {
    public static void main(String[] args) {

        Aluno novo_aluno = new Aluno("rafael", "123456");

        AlunoDAO newListAluno = new AlunoDAOList();

        for(int i = 0; i< 10;i++){
            Aluno novo = newListAluno.create(new Aluno("Aluno "+i, ""+i+100));
            System.out.println(novo);
        }
        System.out.println("**** by id ***********\n\n");
        Aluno byId = newListAluno.find_by_id(5);
        System.out.println(byId);

        System.out.println("**** edit ***********\n\n");
        Aluno e = new Aluno(5,"Maria", "123131321");

        Aluno edit = newListAluno.edit(e);
        System.out.println(edit);

        System.out.println("**** print ***********\n\n");
        for (Aluno aluno : newListAluno.find_all()) {
            System.out.println(aluno);
        }


    }
}