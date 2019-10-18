package com.doorloop.zwolle.api;

import com.doorloop.zwolle.controller.AanmeldingService;
import com.doorloop.zwolle.domein.Aanmelding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AanmeldingEndpoint {

        @Autowired
        AanmeldingService aanmeldingService;

        @PostMapping("/aanmelding")
        public void saveObers(@RequestBody Aanmelding aanmelding) {
            aanmeldingService.saveAanmelding(aanmelding);
            System.out.println("jojo het werkt");
        }
}
