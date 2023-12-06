package com.devthalisson.agendadecontatosrefactor.controllers;

import com.devthalisson.agendadecontatosrefactor.dto.ContactDTO;
import com.devthalisson.agendadecontatosrefactor.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/contact")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactController {

    @Autowired
    private ContactService service;

    @GetMapping
    public ResponseEntity<Page<ContactDTO>> findAll(Pageable pageable) {
        Page<ContactDTO> result = service.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContactDTO> findById(@PathVariable Long id) {
        ContactDTO result = service.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ContactDTO> insert(@RequestBody ContactDTO dto) {
        ContactDTO result = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(result);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContactDTO> update(@PathVariable Long id, @RequestBody ContactDTO dto) {
        ContactDTO result = service.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
