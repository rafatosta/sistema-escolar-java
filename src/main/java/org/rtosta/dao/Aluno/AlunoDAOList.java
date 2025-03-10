package org.rtosta.dao.Aluno;

import org.rtosta.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAOList implements AlunoDAO {
    private List<Aluno> alunos;
    private int nextID;

    public AlunoDAOList() {
        this.alunos = new ArrayList<>();
        this.nextID = 0;
    }

    @Override
    public Aluno find_by_name(String nome) {
        return null;
    }

    @Override
    public Aluno create(Aluno obj) {
        obj.setId(this.nextID);
        this.nextID = this.nextID + 1;
        this.alunos.add(obj);
        return obj;
    }

    @Override
    public List<Aluno> find_all() {
        return this.alunos;
    }

    @Override
    public Aluno find_by_id(int id) {
        for (Aluno a : this.alunos) {
            if (id == a.getId()) {
                return a;
            }
        }
        return null;
    }

    @Override
    public Aluno edit(Aluno obj) {
        for (int i = 0; i < this.alunos.size(); i++) {
            Aluno a = this.alunos.get(i);
            if (obj.getId() == a.getId()) {
                this.alunos.remove(i);
                this.alunos.add(i, obj);
                return this.alunos.get(i);
            }
        }
        return null;
    }

    @Override
    public Aluno delete(Aluno obj) {
        return null;
    }
}
