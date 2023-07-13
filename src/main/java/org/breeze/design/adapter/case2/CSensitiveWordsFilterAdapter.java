package org.breeze.design.adapter.case2;

public class CSensitiveWordsFilterAdapter implements ISensitiveWordsFilter{

    private CSensitiveWordsFilter cFilter;

    @Override
    public String filter(String test) {
        return cFilter.filterYYY(test);
    }
}
