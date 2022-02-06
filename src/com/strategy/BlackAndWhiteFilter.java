package com.strategy;

public class BlackAndWhiteFilter implements Filter{
    @Override
    public void apply(String fileName) {
        System.out.println("Implementing Black and White Filter");
    }
}
