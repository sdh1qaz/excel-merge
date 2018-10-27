package com.dhsu.excel_merge;

import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

/**
 * @ClassName： DragOverEvent
 * 
 * @Author: dhSu
 * @Description:文件拖到控件上方事件
 * @Date:Created in 2018年10月27日
 */

public class DragOverEvent implements EventHandler<DragEvent> {
	private TextArea textArea;

	public DragOverEvent(TextArea textArea) {
		this.textArea = textArea;
	}

	public void handle(DragEvent event) {

		if (event.getGestureSource() != textArea) {
			event.acceptTransferModes(TransferMode.ANY);
		}
	}

}
