package com.warden.ichat.tool.core.factory;

import com.warden.ichat.tool.core.handler.BusinessHandler;
import com.warden.ichat.tool.core.handler.TransientModelHandler;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/11
 */
public class HandlerFactory {

    private volatile static BusinessHandler businessHandler;

    private volatile static TransientModelHandler transientModelHandler;

    public static BusinessHandler getBusinessHandle() {
        if (businessHandler == null) {
            synchronized (HandlerFactory.class) {
                if (businessHandler == null) {
                    businessHandler = new BusinessHandler();
                }
            }
        }
        return businessHandler;
    }

    public static TransientModelHandler getTransientModelHandler() {
        if (transientModelHandler == null) {
            synchronized (HandlerFactory.class) {
                if (transientModelHandler == null) {
                    transientModelHandler = new TransientModelHandler();
                }
            }
        }
        return transientModelHandler;
    }

}
