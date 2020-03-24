package entity;

@FunctionalInterface
public interface Supplier<T> {
    /**
     * Gets a result. * * @return a result
     */
    T get(T t);
}
