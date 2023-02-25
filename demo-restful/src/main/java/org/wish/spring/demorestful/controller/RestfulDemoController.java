package org.wish.spring.demorestful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wish.spring.demorestful.model.EnglishWord;
import org.wish.spring.demorestful.model.ToeicWord;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/words")
class RestfulDemoController {
    private final List<EnglishWord> englishWords = new ArrayList<>();

    public RestfulDemoController() {
        englishWords.addAll(List.of(
                ToeicWord.LEGITIMATE,
                ToeicWord.SEAT,
                ToeicWord.RULE,
                ToeicWord.RESTATE
        ));
    }

    @GetMapping
    public Iterable<EnglishWord> getEnglishWords() {
        return englishWords;
    }
}
