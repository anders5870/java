package Generics;
import java.util.Iterator;


public interface Collection<E> {
	public void add(E x);
	public Iterator<E> iterator();
}
