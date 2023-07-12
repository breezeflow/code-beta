package org.breeze.design.AdapterPattern.case2;

/**
 * a系统敏感词过滤接口  适配器，后面还有其他系统的接口适配器
 */
public class ASensitiveWordFilterAdaptor implements ISensitiveWordsFilter {

    private ASensitiveWordsFilter aFilter;

    @Override
    public String filter(String text) {
        aFilter.filterPoliticalWorld(text);
        return null;
    }
}
