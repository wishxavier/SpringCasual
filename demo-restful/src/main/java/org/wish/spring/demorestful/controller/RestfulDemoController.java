package org.wish.spring.demorestful.controller;

import org.springframework.web.bind.annotation.*;
import org.wish.spring.demorestful.model.EnglishWord;
import org.wish.spring.demorestful.model.ToeicWord;

import java.util.*;

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
    Iterable<EnglishWord> getEnglishWords() {
        return englishWords;
    }

    @GetMapping("/{word}")
    Optional<EnglishWord> queryEnglishWord(@PathVariable String word) {
        for (var englishWord : englishWords) {
            if (englishWord.getWord().equalsIgnoreCase(word)) {
                return Optional.of(englishWord);
            }
        }

        return Optional.empty();
    }

    @PostMapping
    EnglishWord createEnglishWord(@RequestBody EnglishWord englishWord) {
        var queryResult = queryEnglishWord(englishWord.getWord());
        if (queryResult.isPresent()) {
            return queryResult.get();
        } else {
            englishWords.add(englishWord);
            return englishWord;
        }
    }
}
