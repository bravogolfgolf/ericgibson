package com.ericgibson.website.code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhotoController {

    @GetMapping
    public String index() {
        return "index";
    }
}