package com.devthalisson.agendadecontatosrefactor.services;

import com.devthalisson.agendadecontatosrefactor.dto.ContactDTO;
import com.devthalisson.agendadecontatosrefactor.entities.Contact;
import com.devthalisson.agendadecontatosrefactor.repositories.ContactRepository;
import com.devthalisson.agendadecontatosrefactor.services.exceptions.IdNotFountException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    @Transactional(readOnly = true)
    public Page<ContactDTO> findAll(Pageable pageable) {
        Page<Contact> list = repository.findAll(pageable);
        return list.map(x -> new ContactDTO(x));
    }

    @Transactional(readOnly = true)
    public ContactDTO findById(Long id) {
        Contact result = repository.findById(id).orElseThrow(() -> new IdNotFountException("Id não encontrado"));
        return new ContactDTO(result);
    }

    @Transactional
    public ContactDTO insert(ContactDTO dto) {
        Contact entity = new Contact();
        copy(dto, entity);
        entity = repository.save(entity);
        return new ContactDTO(entity);
    }

    @Transactional
    public ContactDTO update(Long id, ContactDTO dto) {
        try {
            Contact entity = repository.getReferenceById(id);
            copy(dto, entity);
            entity = repository.save(entity);
            return new ContactDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw  new IdNotFountException("Id não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if(!repository.existsById(id)) {
            throw new IdNotFountException("Id não encontrado");
        }
            repository.deleteById(id);
    }

    public void copy(ContactDTO dto, Contact entity) {
        entity.setNome(dto.getNome());
        entity.setSobrenome(dto.getSobrenome());
        entity.setContato(dto.getContato());
        entity.setImgUrl(dto.getImgUrl());
    }
}
