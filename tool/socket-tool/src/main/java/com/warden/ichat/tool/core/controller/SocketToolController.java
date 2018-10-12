package com.warden.ichat.tool.core.controller;

import com.google.common.collect.Lists;
import com.warden.ichat.tool.core.engine.LoggingEngine;
import com.warden.ichat.tool.core.engine.TransformEngine;
import com.warden.ichat.tool.domain.Constant;
import com.warden.ichat.tool.domain.enums.ConnectionModel;
import com.warden.ichat.tool.util.DateUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/11
 */
@Slf4j
public class SocketToolController {

    @FXML
    public ChoiceBox<String> connectModelChoice;

    @FXML
    public TextField serverNameOrIPText;

    @FXML
    public TextField serverPortText;

    @FXML
    public Button startButton;

    @FXML
    public Button stopButton;

    @FXML
    public TextArea textToSend;

    @FXML
    public TextArea receivedText;

    @FXML
    public TextField connNumText;

    @FXML
    private void initialize() {
        log.info("socket tool view init start...");
        initCheckBox();
        initTextField();
        initTextArea();
        log.info("socket tool view init finish...");
    }

    @FXML
    public void startButtonHandler() {
        connect();
    }

    @FXML
    public void sendButtonHandler() {
        log.info("start to send msg");
        send();
    }

    private void connect() {
        String host = serverNameOrIPText.getText();
        int port = Integer.valueOf(serverPortText.getText());
        int num = Integer.valueOf(connNumText.getText());
        log.info("serverName is : {}, port is: {}, connection num is {}",
                host, port, num);
        TransformEngine.connect(host, port, num);
        DateUtil.sleepWithoutInterrupt(500);
        send();
    }

    private void send() {
        ConnectionModel model = ConnectionModel.getModel(connectModelChoice.getValue());
        TransformEngine.sendMsg(model, textToSend.getText());
    }

    private void initCheckBox() {
        final ObservableList<String> list = FXCollections.observableArrayList(Constant.CONNECTION_MODEL_ARRAY);
        connectModelChoice.setItems(list);
        connectModelChoice.setValue(list.get(0));
    }

    private void initTextField() {
        serverNameOrIPText.setText(Constant.DEFAULT_SERVER_HOST);
        serverPortText.setText(String.valueOf(Constant.DEFAULT_SERVER_PORT));
        connNumText.setText(String.valueOf(Constant.DEFAULT_CONNECTION_NUM));
    }

    private void initTextArea() {
        LoggingEngine.init(receivedText);
    }
}
