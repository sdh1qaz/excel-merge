package com.dhsu.excel_merge;

import javafx.scene.control.TextArea;

/**
 * @ClassName： MyStyleTextField
 * 
 * @Author: dhSu
 * @Description:TextField的单例类，类中提供了一个getTextFiled方法获取TextField对象
 * @Date:Created in 2018年10月27日
 */

public class MyTextArea {
	private static MyTextArea uniqueInstance = null;

	private MyTextArea() {

	}

	public static MyTextArea getInstance() {

		if (uniqueInstance == null) {
			uniqueInstance = new MyTextArea();
		}
		return uniqueInstance;
	}

	public TextArea geTextArea() {

		TextArea textArea = new TextArea();
		textArea.setMinHeight(300.0);
		textArea.setMinWidth(650.0);
		textArea.setOnDragOver(new DragOverEvent(textArea));
		textArea.setOnDragDropped(new DragDroppedEvent(textArea));

		return textArea;
	}

}
