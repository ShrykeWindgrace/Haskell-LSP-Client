package com.github.shrykewindgrace.hlspc;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.platform.lsp.api.LspServerSupportProvider;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("UnstableApiUsage")
public class HaskellLspSupportProvider implements LspServerSupportProvider {
    @Override
    public void fileOpened(@NotNull Project project, @NotNull VirtualFile virtualFile,
                           @NotNull LspServerSupportProvider.LspServerStarter lspServerStarter) {
        if (!virtualFile.getFileType().equals(HaskellFileType.INSTANCE)) {
            return;
        }
        lspServerStarter.ensureServerStarted(new HaskellLspServerDescriptor(project, "HLS"));
    }
}
