package com.warden.ichat.tool;

import com.warden.ichat.tool.util.ResourceUtils;
import com.warden.ichat.util.TimeUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/11
 */
@Slf4j
public class SocketToolStart extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        log.info("socket tool start ...");
        TimeUtil.start();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ResourceUtils.getURL("classpath:socketTool.fxml"));
        Pane page = loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
        log.info("启动成功， 耗时：{}", TimeUtil.stop(true));
    }
}
