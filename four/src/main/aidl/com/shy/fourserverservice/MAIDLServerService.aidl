// MAIDLServerService.aidl
package com.shy.fourserverservice;

// Declare any non-default types here with import statements

interface MAIDLServerService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
            int addNum(int a, int b);
}