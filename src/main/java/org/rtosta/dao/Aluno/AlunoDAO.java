package org.rtosta.dao.Aluno;

import org.rtosta.dao.CRUD;
import org.rtosta.model.Aluno;

public interface AlunoDAO extends CRUD<Aluno> {

    public Aluno find_by_name(String nome);
}
