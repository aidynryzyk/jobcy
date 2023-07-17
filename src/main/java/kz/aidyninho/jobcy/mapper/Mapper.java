package kz.aidyninho.jobcy.mapper;

public interface Mapper<F, T> {

    T mapFrom(F object);
}
