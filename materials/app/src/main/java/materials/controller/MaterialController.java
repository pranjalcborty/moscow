package materials.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import materials.domain.Material;
import materials.domain.Status;
import materials.repositories.MaterialRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @author pranjal
 * @date 2023-11-29
 */

@RestController
@RequestMapping("/api/material")
public class MaterialController {

    private final MaterialRepository repository;

    public MaterialController(MaterialRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Material getMaterial(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(Material.class.getName(), id));
    }

    @PostMapping
    public Material storeMaterial(@Valid @RequestBody Material material) {
        return repository.save(material);
    }

    @PutMapping
    public Material updateMaterial(@Valid @RequestBody Material material) {
        Material dbMaterial = repository.findById(material.getId())
                .orElseThrow(EntityNotFoundException::new);

        dbMaterial.updateThisWithDataFrom(material);

        return repository.save(dbMaterial);
    }

    @DeleteMapping("/{id}")
    public Material deleteMaterial(@PathVariable Long id) {
        Material dbMaterial = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        dbMaterial.setStatus(Status.DELETED);

        return repository.save(dbMaterial);
    }

    @GetMapping("/{page}/{size}")
    public Page<Material> getMaterials(@PathVariable Integer page, @PathVariable Integer size) {
        Pageable pageWithElements = PageRequest.of(page, size);

        return repository.findAll(pageWithElements);
    }

}
