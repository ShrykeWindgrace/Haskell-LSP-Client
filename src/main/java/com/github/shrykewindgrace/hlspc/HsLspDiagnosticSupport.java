package com.github.shrykewindgrace.hlspc;

import com.intellij.platform.lsp.api.customization.LspDiagnosticsSupport;
import com.intellij.xml.util.XmlStringUtil;
import org.eclipse.lsp4j.Diagnostic;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("UnstableApiUsage")
public final class HsLspDiagnosticSupport extends LspDiagnosticsSupport {
    @NotNull
    @Override
    public String getTooltip(@NotNull Diagnostic diagnostic) {
        /*
         * default implementation is {@code return diagnostic.getMessage();}
         *
         * But tooltips do not render well
         * */

        final String message = diagnostic.getMessage();
        return XmlStringUtil.wrapInHtml(XmlStringUtil.escapeString(message));
    }

    static final HsLspDiagnosticSupport INSTANCE = new HsLspDiagnosticSupport();
}
