package com.github.shrykewindgrace.hlspc;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.platform.lsp.api.customization.LspFormattingSupport;
import org.jetbrains.annotations.NotNull;

import static com.github.shrykewindgrace.hlspc.HaskellFileType.FILE_EXTENSION;

@SuppressWarnings("UnstableApiUsage")
public class HsLspFormattingSupport extends LspFormattingSupport {
    @Override
    public boolean shouldFormatThisFileExclusivelyByServer(@NotNull VirtualFile file, boolean ideCanFormatThisFileItself, boolean serverExplicitlyWantsToFormatThisFile) {
        return FILE_EXTENSION.equals(file.getExtension());
    }

    static final HsLspFormattingSupport INSTANCE = new HsLspFormattingSupport();

}
