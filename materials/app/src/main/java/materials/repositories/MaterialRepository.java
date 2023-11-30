package materials.repositories;

import materials.domain.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pranjal
 * @date 2023-11-30
 */

@Repository
public interface MaterialRepository extends CrudRepository<Material, Long>,
        PagingAndSortingRepository<Material, Long> {
}
