package Generics;
import java.util.ArrayList;
import java.util.LinkedList;


public class GenericsTest {

	public static void main(String[] args) {
		Collection<String> coll = (Collection<String>) new LinkedList();
		String s = new String("TestString");
		//generates ClassCastException because the typecast above is not 
		//a cast to String but to the raw type Collection
		coll.add(s);
		
		//generic array error
		
		//reference can be created
		Pair<String,String>[] arr = null;
		//but the creation of the actual array is rejected
		arr = new Pair<String,String>[2];

		
		//Arrays holding elements whose
		//type is a concrete parameterized type are illegal
		Pair<Integer,Integer>[] intPairArr = new Pair<Integer,Integer>[10];
		/*
		 * Arrays vs. Collections
		 * 
		 * Arrays are more efficient
		 * Collections are more type-safe
		 */
		/*
		 * Raw type assignment compatibility
		 */
		ArrayList rawList = new ArrayList();
		ArrayList<String> stringList = new ArrayList<String>();
		rawList = stringList;
		stringList = rawList;
	}

}
