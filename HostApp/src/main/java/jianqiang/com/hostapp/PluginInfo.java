package jianqiang.com.hostapp;

import dalvik.system.DexClassLoader;

public class PluginInfo {
    private String dexPath;
    private DexClassLoader classLoader;

    public PluginInfo(String dexPath, DexClassLoader classLoader) {
        this.dexPath = dexPath;
        this.classLoader = classLoader;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public String getDexPath() {
        return dexPath;
    }
}