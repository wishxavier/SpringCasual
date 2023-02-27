package org.wish.spring.demorestful.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping
    ResponseEntity<EnglishWord> upsertEnglishWord(@RequestBody EnglishWord englishWord) {
        deleteEnglishWord(englishWord.getWord());
        return new ResponseEntity<>(createEnglishWord(englishWord), HttpStatus.OK);
    }

    @DeleteMapping("/{word}")
    ResponseEntity<EnglishWord> deleteEnglishWord(@PathVariable String word) {
        for (int i = 0; i < englishWords.size(); ++i) {
            if (englishWords.get(i).getWord().equalsIgnoreCase(word)) {
                return new ResponseEntity<>(englishWords.remove(i), HttpStatus.NO_CONTENT);
            }
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
