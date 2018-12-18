package com.practice.arraylist;

import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListPractice {

  public static void main(String[] args) throws Exception {

    // synchronizeArrayList();// converting ArrayList to synchronized ArrayList
    // copyOnWriteArrayList();// Creating synchronized List using CopyOnWriteArrayList API.
    // readOnlyArrayList();
    createSubList();
    convertToString();
  }

  private static void synchronizeArrayList() {
    // An ArrayList which is not synchronize
    List<String> listOfSymbols = new ArrayList<String>();
    listOfSymbols.add("RELIANCE");
    listOfSymbols.add("TATA");
    listOfSymbols.add("TECHMAH");
    listOfSymbols.add("HDFC");
    listOfSymbols.add("ICICI");

    Set<String> set = new HashSet<>();

    System.out.println(listOfSymbols);

    // Synchronizing ArrayList in Java
    listOfSymbols = Collections.synchronizedList(listOfSymbols);

    synchronized(listOfSymbols){
      Iterator<String> myIterator = listOfSymbols.iterator();
      while(myIterator.hasNext()){
        System.out.println(myIterator.next());
      }
    }
  }

  private static void copyOnWriteArrayList() {
    CopyOnWriteArrayList<String> threadSafeList = new CopyOnWriteArrayList<String>();
    threadSafeList.add("Java");
    threadSafeList.add("J2EE");
    threadSafeList.add("Collection");

    //add, remove operator is not supported by CopyOnWriteArrayList iterator
    Iterator<String> failSafeIterator = threadSafeList.iterator();
    while(failSafeIterator.hasNext()){
      System.out.printf("Read from CopyOnWriteArrayList : %s %n", failSafeIterator.next());
      //failSafeIterator.remove(); //not supported in CopyOnWriteArrayList in Java
    }
  }

  private static void readOnlyArrayList() {

    //creating read only Collection in Java
    Collection readOnlyCollection = Collections.unmodifiableCollection(new ArrayList<String>());
    readOnlyCollection.add("Sydney Sheldon"); //raises UnSupportedOperation exception

    //making existing ArrayList readonly in Java
    ArrayList readableList = new ArrayList();
    readableList.add("Jeffrey Archer");
    readableList.add("Khalid Hussain");

    List unmodifiableList = Collections.unmodifiableList(readableList);

    //add will throw Exception because List is readonly
    unmodifiableList.add("R.K. Narayan");

    //remove is not allowed in unmodifiable list
    unmodifiableList.remove(0);

    //set is not allowed in unmodifiable List
    unmodifiableList.set(0, "Anurag Kashyap");

    //creating Fixed Length List from Array in Java
    List fixedLengthList = Arrays.asList("Mark" , "Twen");
    // readOnlyList.add("J.K. Rowling"); //raises Exception

    fixedLengthList.set(0, "J.K. Rowling"); //allowed that's why not read only list
    System.out.println(fixedLengthList.get(0));

  }

  private static void createSubList() {

    ArrayList<String> arrayList = new ArrayList();

    //Add elements to Arraylist
    arrayList.add("Java");
    arrayList.add("C++");
    arrayList.add("PHP");
    arrayList.add("Scala");

            /*
               subList Method returns sublist from list with starting index to end index-1
            */

    List<String> lst = arrayList.subList(1,3);

    //display elements of sub list.
    System.out.println("Sub list contains : ");
    for(int i=0; i<lst.size() ; i++)
    System.out.println(lst.get(i));


    //remove one element from sub list
    Object obj = lst.remove(0);
    System.out.println(obj + " is removed from sub list");

    //print original ArrayList
    System.out.println("After removing " + obj + " from sub list, original ArrayList contains : ");
    for(int i=0; i<arrayList.size() ; i++)
    System.out.println(arrayList.get(i));

  }

  private static void convertToString() {
    // ArrayList to be converted into String
    ArrayList<String> language = new ArrayList<String>();
    language.add("Java");
    language.add("C++");
    language.add("Scala");

    // Converting ArrayList to String using Spring API , result is comma separated String
    String arraylistToString = StringUtils.collectionToCommaDelimitedString(language);

    System.out.println("String converted from ArrayList : " + arraylistToString);

    //If you want to use separater other than coma while converting ArrayList to String use below method
    String pipeSeparated = StringUtils.collectionToDelimitedString(language, "|");

    System.out.println("PIPE delimited String from ArrayList : " + pipeSeparated);

    //Let's generate colon delimited String from ArrayList

    String colonSeparated = StringUtils.collectionToDelimitedString(language, ":");
    System.out.println("Colon separated String from ArrayList : " + colonSeparated);


  }

  public static Double multiply(Double a, Double b) {
    return a * b;
  }
}
