package com.doorloop.zwolle.controller;

import com.doorloop.zwolle.domein.Aanmelding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AanmeldingRepository extends CrudRepository<Aanmelding, Long> {
}
