package org.wish.spring.demorestful.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EnglishWord {
    private final String word;
    private final String sentence;
    private final String chinese;

    public static class Builder {
        private final String word;
        private String sentence;
        private String chinese;

        private Builder(String word) {
            this.word = word;
        }

        public static Builder create(String word) {
            return new Builder(word);
        }

        public Builder setSentence(String sentence) {
            this.sentence = sentence;
            return this;
        }

        public Builder setChinese(String chinese) {
            this.chinese = chinese;
            return this;
        }

        public EnglishWord build() {
            return new EnglishWord(this);
        }
    }

    private EnglishWord(Builder builder) {
        this.word = Objects.requireNonNull(builder.word);
        this.sentence = builder.sentence;
        this.chinese = builder.chinese;
    }

    public String getWord() {
        return word;
    }

    public String getSentence() {
        return sentence;
    }

    public String getChinese() {
        return chinese;
    }
}
