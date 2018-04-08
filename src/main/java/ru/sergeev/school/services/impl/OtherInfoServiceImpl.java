package ru.sergeev.school.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergeev.school.repository.OtherInfoRepository;
import ru.sergeev.school.services.OtherInfoService;

@Service
public class OtherInfoServiceImpl implements OtherInfoService {
    private final OtherInfoRepository otherInfoRepository;

    @Autowired
    public OtherInfoServiceImpl(OtherInfoRepository otherInfoRepository) {
        this.otherInfoRepository = otherInfoRepository;
    }
}
