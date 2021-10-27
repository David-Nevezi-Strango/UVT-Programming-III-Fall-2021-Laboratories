package Laboratory5;

public class Pair<Type extends Comparable<Type>> implements Comparable<Pair<Type>> {
	private Type first;
	private Type second;

	public Pair(Type first, Type second) {
		this.first = first;
		this.second = second;
	}

	public Type getFirst() {
		return first;
	}

	public void setFirst(Type first) {
		this.first = first;
	}

	public Type getSecond() {
		return second;
	}

	public void setSecond(Type second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return "\nPair [first=" + first + ", second=" + second + "]\n";
	}

	@Override
	public int compareTo(Pair<Type> other) {
		int comparisonOfFirst = ((Comparable<Type>) this.first).compareTo(other.first);
		int comparisonOfSecond = ((Comparable<Type>) this.second).compareTo(other.second);
		return comparisonOfFirst == 0 ? comparisonOfSecond : comparisonOfFirst;
	}
}
