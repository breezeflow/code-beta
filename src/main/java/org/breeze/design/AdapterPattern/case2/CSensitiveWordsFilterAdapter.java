package org.breeze.design.AdapterPattern.case2;

public class CSensitiveWordsFilterAdapter implements ISensitiveWordsFilter{

    private CSensitiveWordsFilter cFilter;

    @Override
    public String filter(String test) {
        return cFilter.filterYYY(test);
    }
}
