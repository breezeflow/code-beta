package org.breeze.design.adapter.case2;

public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{

    private BSensitiveWordsFilter bFilter;

    @Override
    public String filter(String test) {
        return bFilter.filterXXX(test);
    }
}
