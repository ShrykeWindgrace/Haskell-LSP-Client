package com.github.shrykewindgrace.hlspc;


import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

@SuppressWarnings("UnstableApiUsage")
public class HaskellFileType extends LanguageFileType {
    public static final String FILE_EXTENSION = "hs";

    protected HaskellFileType() {
        super(HaskellLanguage.INSTANCE);
    }

    public static final HaskellFileType INSTANCE = new HaskellFileType();

    @Override
    public @NonNls @NotNull String getName() {
        return "Haskell";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Haskell source files";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return FILE_EXTENSION;
    }

    @Override
    public Icon getIcon() {
        return Icons.HASKELL_ICON_SMALL;
    }
}

