package org.arxing.chineseconverter

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.spreada.utils.chinese.ZHConverter

class ToTraditionalAction : ConverterAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project
        val editor = e.getData(PlatformDataKeys.EDITOR)

        project?.apply {
            editor?.apply {
                startConvertProcedure(project, editor, ZHConverter.TRADITIONAL)
            }
        }
    }
}
