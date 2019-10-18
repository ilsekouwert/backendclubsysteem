package com.doorloop.zwolle.controller;

import com.doorloop.zwolle.domein.Aanmelding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AanmeldingService {
    @Autowired
    AanmeldingRepository aanmeldingRepository;
    public void saveAanmelding(Aanmelding aan){
        aanmeldingRepository.save(aan);
    }
}
