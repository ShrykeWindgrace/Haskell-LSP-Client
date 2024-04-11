package com.github.shrykewindgrace.hlspc;

import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor;
import com.intellij.platform.lsp.api.customization.LspDiagnosticsSupport;
import com.intellij.platform.lsp.api.customization.LspFormattingSupport;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.charset.StandardCharsets;

import static com.github.shrykewindgrace.hlspc.HaskellFileType.FILE_EXTENSION;

@SuppressWarnings("UnstableApiUsage")
public class HaskellLspServerDescriptor extends ProjectWideLspServerDescriptor {
    public HaskellLspServerDescriptor(@NotNull Project project, @NotNull String presentableName) {
        super(project, presentableName);
    }

    @NotNull
    @Override
    public GeneralCommandLine createCommandLine() {
        final GeneralCommandLine commandLine = new GeneralCommandLine();
        commandLine.setExePath("haskell-language-server-wrapper");
        commandLine.addParameter("--lsp");
        commandLine.setCharset(StandardCharsets.UTF_8);
        commandLine.addParameter("-d");
        return commandLine;
    }

    @Override
    public boolean isSupportedFile(@NotNull VirtualFile virtualFile) {
        return FILE_EXTENSION.equals(virtualFile.getExtension());
    }

    @Override
    public boolean getLspHoverSupport() {
        return true;
    }

    @Nullable
    @Override
    public LspDiagnosticsSupport getLspDiagnosticsSupport() {
        return HsLspDiagnosticSupport.INSTANCE;
    }

    @Nullable
    @Override
    public LspFormattingSupport getLspFormattingSupport() {
        return HsLspFormattingSupport.INSTANCE;
    }

}
