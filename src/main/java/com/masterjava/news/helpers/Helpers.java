package com.masterjava.news.helpers;

import com.masterjava.news.models.Operation;

public class Helpers {
    public static Operation getOperation(String methodSignature)
    {
        return methodSignature.contains("get") ? Operation.GET : (methodSignature.contains("add") ? Operation.ADD : Operation.DELETE);
    }
}
