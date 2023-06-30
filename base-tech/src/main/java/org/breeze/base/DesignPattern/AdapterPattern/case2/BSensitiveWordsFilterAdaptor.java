package org.breeze.base.DesignPattern.AdapterPattern.case2;

public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{

    private BSensitiveWordsFilter bFilter;

    @Override
    public String filter(String test) {
        return bFilter.filterXXX(test);
    }
}
