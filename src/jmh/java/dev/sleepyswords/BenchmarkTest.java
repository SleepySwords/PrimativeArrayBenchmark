package dev.sleepyswords;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 500)
@Warmup(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 500)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class BenchmarkTest {
    public static final int NO_OF_VALUES = 20000;

    public static int[] arr = new int[NO_OF_VALUES];
    public static ArrayList<Integer> arrList = new ArrayList<Integer>(NO_OF_VALUES);

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Setup(Level.Invocation)
    public void setup() {
        Arrays.fill(arr, 3);
        Integer[] intArr = new Integer[NO_OF_VALUES];
        Arrays.fill(intArr, 3);
        arrList = new ArrayList<>(Arrays.asList(intArr));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void initaliseArrays(Blackhole hole) {
        int[] arr = new int[NO_OF_VALUES];
        hole.consume(arr);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void iterationsArrays(Blackhole hole) {
        for (int i : arr) {
            hole.consume(i);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void firstAccessArrays(Blackhole hole) {
        for (int i = 0; i < NO_OF_VALUES; i++) {
            int first = arr[0];
            hole.consume(first);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void lastAccessArrays(Blackhole hole) {
        for (int i = 0; i < NO_OF_VALUES; i++) {
            int first = arr[NO_OF_VALUES - 1];
            hole.consume(first);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void randomAccessArrays(Blackhole hole) {
        for (int i = 0; i < NO_OF_VALUES; i++) {
            int first = arr[1438];
            hole.consume(first);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void firstSetArrays(Blackhole hole) {
        for (int i = 0; i < NO_OF_VALUES; i++) {
            arr[i] = i;
        }
        hole.consume(arr);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void initaliseArrayList(Blackhole hole) {
        ArrayList<Integer> arr = new ArrayList<Integer>(NO_OF_VALUES);
        hole.consume(arr);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void iterationsArrayList(Blackhole hole) {
        for (int i : arrList) {
            hole.consume(i);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void firstAccessArrayList(Blackhole hole) {
        for (int i = 0; i < NO_OF_VALUES; i++) {
            int first = arrList.get(0);
            hole.consume(first);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void lastAccessArrayList(Blackhole hole) {
        for (int i = 0; i < NO_OF_VALUES; i++) {
            int first = arrList.get(NO_OF_VALUES - 1);
            hole.consume(first);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void randomAccessArrayList(Blackhole hole) {
        for (int i = 0; i < NO_OF_VALUES; i++) {
            int first = arrList.get(1438);
            hole.consume(first);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void firstSetArrayList(Blackhole hole) {
        for (int i = 0; i < NO_OF_VALUES; i++) {
            arrList.set(i, i);
        }
        hole.consume(arr);
    }
}
