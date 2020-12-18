package org.arxing.chineseconverter

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.spreada.utils.chinese.ZHConverter

abstract class ConverterAction : AnAction() {

    protected fun startConvertProcedure(project: Project, editor: Editor, type: Int) {
        val selectionModel = editor.selectionModel
        val selection = selectionModel.selectedText
        val replaceText = ZHConverter.convert(selection, type)
        WriteCommandAction.runWriteCommandAction(project) {
            val start = selectionModel.selectionStart
            val end = selectionModel.selectionEnd
            editor.document.replaceString(start, end, replaceText)
        }
    }
}
