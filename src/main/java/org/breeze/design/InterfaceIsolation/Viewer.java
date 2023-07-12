package org.breeze.design.InterfaceIsolation;

import java.util.Map;

/**
 * 配置信息 查看 功能
 */
public interface Viewer {

    String outputInPlainText();
    Map<String, String> output();

}
