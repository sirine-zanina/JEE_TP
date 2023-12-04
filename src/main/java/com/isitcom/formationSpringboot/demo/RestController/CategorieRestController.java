package com.isitcom.formationSpringboot.demo.RestController;

import com.isitcom.formationSpringboot.demo.services.IServiceCategorie;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CategorieRestController {

    private IServiceCategorie serviceCategorie;




}
