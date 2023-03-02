package org.wish.spring.democonfiguration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wish.spring.democonfiguration.model.LegoItem;

@RestController
@RequestMapping("/lego")
class DemoConfigurationController {
    private LegoItem legoItem;

    DemoConfigurationController(LegoItem legoItem) {
        this.legoItem = legoItem;
    }

    @GetMapping
    LegoItem getLegoItem() {
        return legoItem;
    }

    @PutMapping
    ResponseEntity<LegoItem> upsertLegoItem(@RequestBody LegoItem legoItem) {
        this.legoItem = legoItem;
        return new ResponseEntity<>(legoItem, HttpStatus.OK);
    }
}
