package com.dhsu.util;

import javafx.scene.control.Alert;

/**
 * @ClassName： AlertUtil
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年10月27日
 */

public class AlertUtil {
	public static void creatAlert(String cont) {
		Alert information = new Alert(Alert.AlertType.INFORMATION,"");
		information.setTitle("提醒");
		information.setHeaderText(cont);
		information.showAndWait();
	}

}
