package com.ndg.SubFunction;

import org.jetbrains.annotations.NotNull;

public class DivideSubjectName {
    public static String divideSub(@NotNull String subject) {
        int maxCharacter = 2;
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = subject.split(" ");
        for (String s : arr) {
            stringBuilder.append(s);
            stringBuilder.append(" ");
            --maxCharacter;
            if (maxCharacter == 0) {
                stringBuilder.append("\n");
                maxCharacter = 2;
            }
        }
        return String.valueOf(stringBuilder);
    }
}
