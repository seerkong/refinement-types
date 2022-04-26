package link.symtable.refinementtypes.validators.eq;

@FunctionalInterface
public interface EqPredicate<T> {
    // value是定义校验器时的值
    // input是运行校验时传的值
    boolean predicate(T input, T value);
}
