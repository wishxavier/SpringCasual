package org.wish.spring.demorestful.model;

public class ToeicWord {
    public static final EnglishWord LEGITIMATE = EnglishWord.Builder
            .create("legitimate")
            .setSentence("It is a legitimate grievance.")
            .setChinese("使…合法；使…合理；宣布…為合法/v。合法的；合理的/adj")
            .build();

    public static final EnglishWord RULE = EnglishWord.Builder
            .create("rule")
            .setSentence("You should follow the rules.")
            .setChinese("規則；規定；規章/n。控制；統治；管轄；支配；作出判決/v")
            .build();

    public static final EnglishWord RESTATE = EnglishWord.Builder
            .create("restate")
            .setSentence("She restated her opinion.")
            .setChinese("重述，重申；再次聲明/v")
            .build();

    public static final EnglishWord SEAT = EnglishWord.Builder
            .create("seat")
            .setSentence("Sorry, this seat is taken.")
            .setChinese("座位；座椅；席位；座落於/n。安排座位；坐下/v")
            .build();
}
