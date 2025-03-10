package org.rtosta.dao.Aluno;

import org.rtosta.model.Aluno;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOFile implements AlunoDAO {
    private static final String FILE_NAME = "alunos.txt";

    public AlunoDAOFile() {
        File file = new File(FILE_NAME);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Aluno create(Aluno obj) {
        List<Aluno> alunos = find_all();
        obj.setId(alunos.size());
        alunos.add(obj);
        saveToFile(alunos);
        return obj;
    }

    @Override
    public List<Aluno> find_all() {
        List<Aluno> alunos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Aluno aluno = new Aluno(Integer.parseInt(parts[0]), parts[1], parts[2]);
                    alunos.add(aluno);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    @Override
    public Aluno find_by_id(int id) {
        return find_all().stream()
                .filter(aluno -> aluno.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Aluno find_by_name(String nome) {
        return find_all().stream()
                .filter(aluno -> aluno.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Aluno edit(Aluno obj) {
        List<Aluno> alunos = find_all();
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getId() == obj.getId()) {
                alunos.set(i, obj);
                saveToFile(alunos);
                return obj;
            }
        }
        return null;
    }

    @Override
    public Aluno delete(Aluno obj) {
        List<Aluno> alunos = find_all();
        if (alunos.removeIf(aluno -> aluno.getId() == obj.getId())) {
            saveToFile(alunos);
            return obj;
        }
        return null;
    }

    private void saveToFile(List<Aluno> alunos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Aluno aluno : alunos) {
                writer.write(aluno.getId() + "," + aluno.getNome() + "," + aluno.getCpf());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}