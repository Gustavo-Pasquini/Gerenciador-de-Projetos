package unicesumar.gerenciamento_de_projetos.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicesumar.gerenciamento_de_projetos.Models.ProjetoModel;
import unicesumar.gerenciamento_de_projetos.Repositories.ProjetoRepository;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public ProjetoModel criarProjeto(ProjetoModel pedidoModel) {
        return projetoRepository.save(pedidoModel);
    }

    public List<ProjetoModel> listarProjetos() {
        return projetoRepository.findAll();
    }

    public ProjetoModel listarProjetoPorId(Long id) {
        return projetoRepository.findById(id).get();
    }

    public void deletarProjetoPorId(Long id) {
        projetoRepository.deleteById(id);
    }

}
