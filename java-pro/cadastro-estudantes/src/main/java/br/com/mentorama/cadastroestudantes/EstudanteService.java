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

  public List<EstudanteModel> findAllEstudantes(String name, String age) throws AlunoNaoExistenteException {
    if (name != null) {
      return estudantes.stream()
              .filter(aluno -> aluno.getName().contains(name))
              .collect(Collectors.toList());
    }

    if (age != null) {
      return estudantes.stream()
              .filter(aluno -> aluno.getAge().contains(age))
              .collect(Collectors.toList());
    }

    if (estudantes.isEmpty()) {
      throw new AlunoNaoExistenteException("Aluno não existe");
    }
    return estudantes;
  }

//  public List<EstudanteModel> findByName(String name) throws AlunoNaoExistenteException {
//    if (name != null) {
//      return estudantes.stream()
//              .filter(aluno -> aluno.getName().contains(name))
//              .collect(Collectors.toList());
//    }
//    return estudantes;
//    throw new AlunoNaoExistenteException("aa");
//  }

//  private List<EstudanteModel> findByAge(Integer age) {
//    if (age != null) {
//      return estudantes.stream()
//              .filter(aluno -> aluno.getAge().equals(age))
//              .collect(Collectors.toList());
//    }
//    return estudantes;
//  }

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
