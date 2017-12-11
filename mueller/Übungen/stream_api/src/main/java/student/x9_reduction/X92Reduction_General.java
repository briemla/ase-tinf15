package student.x9_reduction;

/*
     There is also a more general method:
        T reduce(BinaryOperator<T> accumulator)
        T reduce(T identity, BinaryOperator<T> accumulator)

     identity is the start value and default return value if the stream is empty. BinaryOperator takes to arguments where
     the first argument is the partial result and the second is the current value.

     // TODO use the reduce method to get the sum of the ages of the people each in PersonLists.dhbwList and PersonLists.esentriList and print it

     Java API:
     - BinaryOperator<T> is a special BiFunction (i.e. BiFunction<T,T,T>), where the the operands and the result are of the same type
     - BiFunction<T, U, R> is like the Function<T, U> interface, but takes to arguments for its method
 */
public class X92Reduction_General {

    public static void main(String[] args) {
        // next steps:  Collect, Parallelism
    }

}
