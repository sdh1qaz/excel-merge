package com.dhsu.excel_merge;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;

/**
 * @ClassName： DragDroppedEvent
 * 
 * @Author: dhSu
 * @Description:文件拖到控件上方，鼠标松开事件
 * @Date:Created in 2018年10月27日
 */

public class DragDroppedEvent implements EventHandler<DragEvent> {
	private TextArea textArea;

	public DragDroppedEvent(TextArea textArea) {
		this.textArea = textArea;
	}

	public void handle(DragEvent event) {
		Dragboard dragboard = event.getDragboard();
		if (dragboard.hasFiles()) {
			try {
				File file = dragboard.getFiles().get(0);
				if (file != null) {
					StringBuffer sBuffer = new StringBuffer();
					sBuffer.append(textArea.getText());
					textArea.setText(sBuffer.toString() + file.getAbsolutePath() + "\n");
				}
			} catch (Exception e) {
			}
		}
	}

}
