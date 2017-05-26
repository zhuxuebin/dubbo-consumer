package com.dubbo.service.impl;

import com.dubbo.domain.Person;
import com.dubbo.service.Nofify;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 01368080 on 2017/4/28.
 */

public class NofifyImpl implements Nofify {
    public Map<Integer, Person> ret    = new HashMap<Integer, Person>();
    public Map<Integer, Throwable> errors = new HashMap<Integer, Throwable>();
    public void onreturn(Person msg, Integer id) {
        System.out.println("onreturn:" + msg);
        ret.put(id, msg);
    }
    public void onthrow(Throwable ex, Integer id) {
        errors.put(id, ex);
    }
}
