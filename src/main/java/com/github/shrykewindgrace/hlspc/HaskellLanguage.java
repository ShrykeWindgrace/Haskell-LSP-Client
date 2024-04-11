package com.github.shrykewindgrace.hlspc;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class HaskellLanguage extends Language {
    private HaskellLanguage(@NonNls @NotNull String ID) {
        super(ID);
    }

    public static final HaskellLanguage INSTANCE = new HaskellLanguage("Haskell");
}
