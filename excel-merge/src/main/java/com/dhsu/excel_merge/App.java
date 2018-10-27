package com.dhsu.excel_merge;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;;

/**
 * Hello world!
 *
 */
public class App extends Application {
	public static void main(String[] args) {
		//启动应用程序
		launch(args);
	}
	//应用程序开始执行
	public void start(Stage stage) {
		stage.setTitle("EXCEL合并");
		stage.setResizable(false);//禁止最大化，固定大小
		//创建根节点
		AnchorPane rootNode = new AnchorPane();
		//创建场景
		Scene scene = new Scene(rootNode,666,411);
		//创建一个标签表名作者
		Label lAuthor = new Label("苏登辉(348673242@qq.com)  2018年10月");
		//创建一个标签提醒输入文件名
		Label lFileNm = new Label("合并后的文件名:");
		//标签字体大小
		lFileNm.setFont(new Font("Arial",17));
		//创建一个输入框用来输入合并后的文件名
		TextField textField = new TextField();
		textField.setMinHeight(30.0);//输入框最小高度
		//创建一个TextArea
		TextArea textArea = MyTextArea.getInstance().geTextArea();
		//创建一个按钮
		Button button = new Button("合并");
		button.setMinHeight(35.0);
		button.setMinWidth(57.0);
		//按钮添加事件
		button.setOnAction(new ButtonPressEvent(button,textArea,textField));
		rootNode.getChildren().addAll(lAuthor,lFileNm,textField,textArea,button);
		//调整组件位置
		AnchorPane.setBottomAnchor(lAuthor, 15.0);//作者标签
		AnchorPane.setRightAnchor(lAuthor, 10.0);
		AnchorPane.setTopAnchor(lFileNm, 23.0);//文件名标签
		AnchorPane.setLeftAnchor(lFileNm, 5.0);
		AnchorPane.setTopAnchor(textField, 18.0);//文件名输入框
		AnchorPane.setLeftAnchor(textField, 135.0);
		AnchorPane.setTopAnchor(textArea, 65.0);//
		AnchorPane.setLeftAnchor(textArea, 5.0);
		AnchorPane.setTopAnchor(button, 16.0);
		AnchorPane.setLeftAnchor(button, 350.0);
		//设置舞台场景
		stage.setScene(scene);
		//显示场景
		stage.show();
	}
}
