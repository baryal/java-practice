package com.practice.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
  public static void main(String[] args) {
    // createStream();
    convertStreamToCollection();
    findMinMax();
    generateRandomNumbers();
    convertIntStreamToCollection();
    findDistinct();
    ifElse();
    optionalTest();
    flatMapExample();
  }

  private static void createStream() {
    // Stream.of(val1, val2, val3….)
    Stream<Integer> stream1 = Stream.of(1,2,3,4,5,6,7,8,9);
    stream1.forEach(p -> System.out.println(p));

    // Stream.of(arrayOfElements)
    Stream<Integer> stream2 = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );
    stream2.forEach(p -> System.out.println(p));

    // List.stream()
    List<Integer> list = new ArrayList<Integer>();
    for(int i = 1; i< 10; i++){
      list.add(i);
    }
    Stream<Integer> stream3 = list.stream();
    stream3.forEach(p -> System.out.println(p));

    // Stream.generate() or Stream.iterate()
    Stream<Date> stream4 = Stream.generate(() -> { return new Date(); });
    //stream4.forEach(p -> System.out.println(p));

    // String chars or String tokens
    IntStream stream5 = "12345_abcdefg".chars();
    stream5.forEach(p -> System.out.println(p));

    //OR

    Stream<String> stream6 = Stream.of("A$B$C".split("\\$"));
    stream6.forEach(p -> System.out.println(p));
  }

  private static void convertStreamToCollection() {

    // Convert Stream to List – Stream.collect( Collectors.toList() )
    List<Integer> list1 = new ArrayList<Integer>();
    for(int i = 1; i< 10; i++){
      list1.add(i);
    }
    Stream<Integer> stream = list1.stream();
    List<Integer> evenNumbersList = stream.filter(i -> i%2 == 0).collect(Collectors.toList());
    System.out.print(evenNumbersList);

    // Convert Stream to array – Stream.toArray( EntryType[]::new )
    List<Integer> list2 = new ArrayList<Integer>();
    for(int i = 1; i< 10; i++){
      list2.add(i);
    }
    Stream<Integer> stream2 = list2.stream();
    Integer[] evenNumbersArr = stream2.filter(i -> i%2 == 0).toArray(Integer[]::new);
    System.out.print(Arrays.toString(evenNumbersArr));
  }

  private static void findMinMax() {

    // Get Min or Max Number
    // To find min and max number from stream of numbers,
    // use Comparator.comparing( Integer::valueOf ) like comparators

    Integer maxNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                                .max(Comparator.comparing(Integer::valueOf))
                                .get();

    Integer minNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                                .min(Comparator.comparing(Integer::valueOf))
                                .get();

    System.out.println("maxNumber = " + maxNumber);
    System.out.println("minNumber = " + minNumber);

    // Get Min or Max String/Char
    // To find min and max string or char from stream of chars,
    // use Comparator.comparing( String::valueOf ) like comparators.
    String maxChar = Stream.of("H", "T", "D", "I", "J")
                             .max(Comparator.comparing(String::valueOf))
                             .get();

    String minChar = Stream.of("H", "T", "D", "I", "J")
                             .min(Comparator.comparing(String::valueOf))
                             .get();

    System.out.println("maxChar = " + maxChar);
    System.out.println("minChar = " + minChar);
  }

  private static void generateRandomNumbers() {
    Random random = new Random();

    //Five random integers

    random.ints( 5 ).sorted().forEach( System.out::println );

    //Five random doubles between 0 (inclusive) and 0.5 (exclusive)

    random.doubles( 5, 0, 0.5 ).sorted().forEach( System.out::println );

    //Boxing long to Long so they can be collected

    List<Long> longs = random.longs( 5 ).boxed().collect( Collectors.toList() );
    System.out.println(longs);

  }

  private static void convertIntStreamToCollection() {

    // Using boxed() method of IntStream, LongStream or DoubleStream e.g. IntStream.boxed(),
    // you can get stream of wrapper objects which can be collected by Collectors methods.
    List<Integer> ints = IntStream.of(1,2,3,4,5)
                                 .boxed()
                                 .collect(Collectors.toList());

    System.out.println(ints);

    // Another way is to manually to the boxing using IntStream.mapToObj(),
    // IntStream.mapToLong() or IntStream.mapToDouble() methods
    List<Integer> ints1 = IntStream.of(1,2,3,4,5)
                                 .mapToObj(Integer::valueOf)
                                 .collect(Collectors.toList());

    System.out.println(ints1);

    // It is also useful to know how to convert primitive stream to array.
    // Use IntStream.toArray() method to convert from int stream to array.
    int[] intArray = IntStream.of(1, 2, 3, 4, 5).toArray();

    System.out.println(Arrays.toString(intArray));
  }

  private static void findDistinct() {

    Collection<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");

// Get collection without duplicate i.e. distinct only
    List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());

//Let's verify distinct elements
    System.out.println(distinctElements);
  }

  private static void ifElse() {
    ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

    Consumer<Integer> action = i -> {
      if(i % 2 == 0) {
        System.out.println("Even number :: " + i);
      } else {
        System.out.println("Odd  number :: " + i);
      }
    };

    numberList.stream().forEach(action);

    numberList.stream()
            .filter(i -> i % 2 == 0)
            .forEach(System.out::println);
  }

  private static void optionalTest() {
    Optional<Integer> possible = Optional.of(5);
    possible.ifPresent(System.out::println);

    Company company = new Company();
    company.setName("Finance");
    //Assume this value has returned from a method
    Optional<Company> companyOptional = Optional.of(company);


    //Now check optional; if value is present then return it,
    //else create a new Company object and retur it
    //Company company = companyOptional.orElse(new Company());
    //company.setName("Finance");

  System.out.println(company);
    //OR you can throw an exception as well
    //Company company1 = companyOptional.orElseThrow(IllegalStateException::new);

    if(companyOptional.isPresent()){
      System.out.println(companyOptional.get());
    }

    companyOptional.filter(department -> "Finance".equals(department.getName())).ifPresent((company2)->System.out.println("Finance Company"));

    Optional<String> opt = Optional.of("baeldung");

    opt.ifPresent(name -> System.out.println(name.length()));
  }

  private static void flatMapExample() {
    String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

    //Stream<String[]>
    Stream<String[]> temp = Arrays.stream(data);

    //Stream<String>, GOOD!
    Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));

    Stream<String> stream = stringStream.filter(x -> "a".equals(x.toString()));

    stream.forEach(System.out::println);

    List<List<String>> list = Arrays.asList(
            Arrays.asList("a"),
            Arrays.asList("b"));
    System.out.println(list);


    System.out.println(list.stream()
                               .flatMap(Collection::stream)
                               .collect(Collectors.toList()));

  }

  private static class Company {

    private String name;

    public String getName() {
      return this.name;
    }

    public void setName(String value) {
      this.name = value;
    }

    @Override
    public String toString() {
      return "Company{" +
                     "name='" + name + '\'' +
                     '}';
    }
  }
}
