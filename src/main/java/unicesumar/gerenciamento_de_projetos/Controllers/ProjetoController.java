package unicesumar.gerenciamento_de_projetos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import unicesumar.gerenciamento_de_projetos.Models.ProjetoModel;
import unicesumar.gerenciamento_de_projetos.Services.ProjetoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoModel> criarProjeto(@RequestBody ProjetoModel projetoModel) {
        ProjetoModel request = projetoService.criarProjeto(projetoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/projetos/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoModel>> listarProjetos() {
        List<ProjetoModel> resquest = projetoService.listarProjetos();
        return ResponseEntity.ok().body(resquest);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProjetoModel> listarProjetoPorId(@PathVariable Long id) {
        ProjetoModel request = projetoService.listarProjetoPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deletarProjetoPorId(@PathVariable Long id) {
        projetoService.deletarProjetoPorId(id);
        return ResponseEntity.noContent().build();
    }

}
