package ru.sergeev.school.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergeev.school.repository.NameRepository;
import ru.sergeev.school.services.NameService;

@Service
public class NameServiceImpl implements NameService {
    private final NameRepository nameRepository;

    @Autowired
    public NameServiceImpl(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }
}
