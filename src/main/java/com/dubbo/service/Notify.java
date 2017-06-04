package com.dubbo.service;

import com.dubbo.domain.Person;

/**
 * Created by 01368080 on 2017/4/28.
 */
public interface Notify {
    public void onreturn(Person msg, Integer id);
    public void onthrow(Throwable ex, Integer id);
}
