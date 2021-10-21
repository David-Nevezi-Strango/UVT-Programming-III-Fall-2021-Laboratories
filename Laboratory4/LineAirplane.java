package Laboratory4;

public class LineAirplane extends Airplane implements LuxuryOptions {
	int maximumPassengersNumber;

	public LineAirplane(String producer, int code, int numberOfEndedFlights, double combustibleCapacity,
			int maximumPassengersNumber) {
		super(producer, code, numberOfEndedFlights, combustibleCapacity);
		this.maximumPassengersNumber = maximumPassengersNumber;
	}

	@Override
	public boolean hasNoiseCancellingHeadphones() {
		return false;
	}

	@Override
	public boolean hasTvWithTouchpadForEachPassenger() {
		return true;
	}

	@Override
	public String toString() {
		return "LineAirplane [maximumPassengersNumber=" + maximumPassengersNumber + ", producer=" + producer + ", code="
				+ code + ", numberOfEndedFlights=" + numberOfEndedFlights + ", combustibleCapacity="
				+ combustibleCapacity + ", hasNoiseCancellingHeadphones()=" + hasNoiseCancellingHeadphones()
				+ ", hasTvWithTouchpadForEachPassenger()=" + hasTvWithTouchpadForEachPassenger() + "]";
	}
}
