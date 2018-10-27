package com.dhsu.excel_merge;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.dhsu.util.AlertUtil;
import com.dhsu.util.ExcelMerge;
import com.dhsu.util.StringUtil;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * @ClassName： ButtonPressEvent
 * @Author: dhSu
 * @Description:按下合并按钮事件
 * @Date:Created in 2018年10月27日
 */

public class ButtonPressEvent implements EventHandler<ActionEvent>{
	private Button button;
	private TextArea textArea;
	private TextField textField;
	public ButtonPressEvent(Button button,TextArea textArea,TextField textField) {
		this.button = button;
		this.textArea = textArea;
		this.textField = textField;
	}
	
	public void handle(ActionEvent event) {
		String strTextArea = textArea.getText();
		String strTextField = textField.getText();
		//如果textArea中没有文件名，弹框警告
		if (StringUtil.isNullOrEmpry(strTextArea)) {
			AlertUtil.creatAlert("请拖入文件！");
			return;
		}else if(StringUtil.isNullOrEmpry(strTextField)) {
			AlertUtil.creatAlert("请输入合并后的文件名！");
			return;
		}
		//所有文件名转化为文件名数组
		String[] names = textArea.getText().split("\n");
		try {
			if(ExcelMerge.merge(names,strTextField)) {
				AlertUtil.creatAlert("成功合并文件到桌面上！");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
