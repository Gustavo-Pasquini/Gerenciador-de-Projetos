package unicesumar.gerenciamento_de_projetos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unicesumar.gerenciamento_de_projetos.Models.ProjetoModel;

public interface ProjetoRepository extends JpaRepository<ProjetoModel, Long> {
}
