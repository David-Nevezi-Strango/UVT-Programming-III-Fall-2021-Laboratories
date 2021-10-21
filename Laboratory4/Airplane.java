package Laboratory4;

public abstract class Airplane {
	String producer;
	int code;
	int numberOfEndedFlights;
	double combustibleCapacity;

	public Airplane(String producer, int code, int numberOfEndedFlights, double combustibleCapacity) {
		this.producer = producer;
		this.code = code;
		this.numberOfEndedFlights = numberOfEndedFlights;
		this.combustibleCapacity = combustibleCapacity;
	}
}
