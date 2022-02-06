package com.strategy;

public class FlexibleImageStorage {
    public void store(String fileName, Compressor compressor, Filter filter){
        compressor.compress(fileName);
        filter.apply(fileName);
    }
}
