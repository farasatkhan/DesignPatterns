package com.strategy;

public class nonFlexibleImageStorage {
    private Compressor compressor;
    private Filter filter;

    public nonFlexibleImageStorage(Compressor compressor, Filter filter) {
        this.compressor = compressor;
        this.filter = filter;
    }

    public void store(String fileName){
        compressor.compress(fileName);
        filter.apply(fileName);
    }
}
