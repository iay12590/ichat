package com.warden.ichat.tool.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/11
 */
@AllArgsConstructor
@Getter
public enum ConnectionModel {
    /**
     * 连接类型：默认，短连接，长连接
     */
    DEFAULT_MODEL(""),
    TRANSIENT("transient connection"),
    PERSISTENT("persistent connection");

    private String model;

    public static ConnectionModel getModel(String modelName) {
        if (StringUtils.isBlank(modelName)) {
            return DEFAULT_MODEL;
        }
        for(ConnectionModel connModel : ConnectionModel.values()) {
            if (Objects.equals(connModel.getModel(), modelName)) {
                return connModel;
            }
        }
        return DEFAULT_MODEL;
    }

}
