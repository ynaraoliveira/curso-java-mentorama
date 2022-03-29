package br.com.mentorama.cadastroestudantes;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudanteService {

  private final List<EstudanteModel> estudantes;

  public EstudanteService(List<EstudanteModel> estudantes) {
    this.estudantes = estudantes;
  }

  public List<EstudanteModel> getEstudantes() {
    return estudantes;
  }

  public List<EstudanteModel> findAllEstudantes(String name, Integer age) throws AlunoNaoExistenteException {
    List<EstudanteModel> estudantesFiltro;
    if (name != null) {
      estudantesFiltro = estudantes.stream()
              .filter(aluno -> aluno.getName().equals(name))
              .collect(Collectors.toList());
      if (estudantesFiltro.isEmpty()) {
        throw new AlunoNaoExistenteException("Aluno não existe");
      }
      return estudantesFiltro;
    }

    if (age != null) {
      estudantesFiltro = estudantes.stream()
              .filter(aluno -> aluno.getAge().equals(age))
              .collect(Collectors.toList());
      if (estudantesFiltro.isEmpty()) {
        throw new AlunoNaoExistenteException("Aluno não existe");
      }
      return estudantesFiltro;
    }
    return estudantes;
  }

  public EstudanteModel findByIdEstudante(Integer id) throws AlunoNaoExistenteException {
      return estudantes.stream()
              .filter(aluno -> aluno.getId().equals(id))
              .findFirst()
              .orElseThrow(() -> new AlunoNaoExistenteException("Aluno não existe."));
  }

  public String addEstudante(EstudanteModel estudante) {
    setIdAndAddToList(estudante);

    if (HttpStatus.OK.is2xxSuccessful()) {
      return "Aluno cadastrado com sucesso.";
    }
    return "Falha no cadastro. Tente novamente.";
  }

  private void setIdAndAddToList(EstudanteModel estudante) {
    if (estudante.getId() == null) {
      estudante.setId(estudantes.size() + 1);
    }
    estudantes.add(estudante);
  }
}
