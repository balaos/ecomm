package com.sample.ecomm.intr;

@FunctionalInterface
public interface IWeight<T>{
    T convert(T x);
}
