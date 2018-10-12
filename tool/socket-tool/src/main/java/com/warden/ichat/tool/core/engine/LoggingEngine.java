package com.warden.ichat.tool.core.engine;

import javafx.scene.control.TextArea;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/12
 */
@Setter
@Getter
@Slf4j
public class LoggingEngine {

    private static TextArea textArea;

    public static void init(TextArea text) {
        textArea = text;
    }

    public static void showText(String msg) {
        if (textArea == null) {
            log.info("textArea has not been inited");
            return;
        }
        javafx.application.Platform.runLater( () ->  textArea.appendText(msg + "\n"));
    }

}
