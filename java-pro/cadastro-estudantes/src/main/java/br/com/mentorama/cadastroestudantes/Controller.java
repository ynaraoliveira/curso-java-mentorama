package br.com.mentorama.cadastroestudantes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cadastroalunos")
public class Controller {

  private final List<Estudante> estudantes;

  public Controller() {
    this.estudantes = new ArrayList<>();
  }

  @GetMapping
  public List<Estudante> findAll(@RequestParam(required = false) String name, Integer age) {
    if (name != null) {
      return estudantes.stream()
              .filter(aluno -> aluno.getName().contains(name))
              .collect(Collectors.toList());
    } else if (age != null) {
      return estudantes.stream()
              .filter(aluno -> aluno.getAge().equals(age))
              .collect(Collectors.toList());
    }
    return estudantes;
  }

  @GetMapping("/{id}")
  public Estudante findById(@PathVariable("id") Integer id) {
    return estudantes.stream()
            .filter(aluno -> aluno.getId().equals(id))
            .findFirst()
            .orElse(null);
  }

  @PostMapping
  public String add(@RequestBody Estudante estudante) {
    setIdAndAddToList(estudante);

    if (HttpStatus.OK.is2xxSuccessful()) {
      return "Aluno cadastrado com sucesso.";
    }
    return "Falha no cadastro. Tente novamente.";
  }

  private void setIdAndAddToList(Estudante estudante) {
    if (estudante.getId() == null) {
      estudante.setId(estudantes.size() + 1);
    }
    estudantes.add(estudante);
  }

  @PutMapping
  public ResponseEntity update(@RequestBody Estudante estudante) {
    estudantes.stream()
            .filter(aluno -> aluno.getId().equals(estudante.getId()))
            .forEach(aluno -> aluno.setAge(estudante.getAge()));

    estudantes.stream()
            .filter(aluno -> aluno.getId().equals(estudante.getId()))
            .forEach(aluno -> aluno.setName(estudante.getName()));

    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") Integer id) {
    estudantes.removeIf(aluno -> aluno.getId().equals(id));
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

}
