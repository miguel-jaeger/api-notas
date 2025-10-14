package com.example.notas.controller;

import com.example.notas.model.Nota;
import com.example.notas.service.NotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notas")
public class NotaController {
    private final NotaService service;

    public NotaController(NotaService service) {
        this.service = service;
    }

    // Listar notas (ok)
    @GetMapping
    public List<Nota> todas() {
        return service.listarTodas();
    }

    // Obtener nota (ok)
    @GetMapping("/{id}")
    public Nota obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Crear nota (ok)
    @PostMapping
    public ResponseEntity<Nota> crear(@Validated @RequestBody Nota nota) {
        Nota guardada = service.crear(nota);
        return ResponseEntity.created(URI.create("/api/notas/" + guardada.getId())).body(guardada);
    }

    // Actualizar nota (ok)
    @PutMapping("/{id}")
    public Nota actualizar(@PathVariable Long id, @Validated @RequestBody Nota nota) {
        return service.actualizar(id, nota);
    }

    // Eliminar nota (ok)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // Archivar nota
    @PatchMapping("/{id}/archivar")
    public Nota archivar(@PathVariable Long id, @RequestBody Nota nota) {
        return service.archivar(id, nota.isArchivada());
    }
}