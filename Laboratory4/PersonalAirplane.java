package Laboratory4;

import java.util.ArrayList;

public class PersonalAirplane extends Airplane implements LuxuryOptions {
	String actualOwner;
	List<String> pastOwners;

	public PersonalAirplane(String producer, int code, int numberOfEndedFlights, double combustibleCapacity,
			String actualOwner, List<String> pastOwners) {
		super(producer, code, numberOfEndedFlights, combustibleCapacity);
		this.actualOwner = actualOwner;
		this.pastOwners = pastOwners;
	}

	@Override
	public boolean hasNoiseCancellingHeadphones() {
		return true;
	}

	@Override
	public boolean hasTvWithTouchpadForEachPassenger() {
		return false;
	}

	@Override
	public String toString() {
		return "PersonalAirplane [actualOwner=" + actualOwner + ", pastOwners=" + pastOwners + ", producer=" + producer
				+ ", code=" + code + ", numberOfEndedFlights=" + numberOfEndedFlights + ", combustibleCapacity="
				+ combustibleCapacity + ", hasNoiseCancellingHeadphones()=" + hasNoiseCancellingHeadphones()
				+ ", hasTvWithTouchpadForEachPassenger()=" + hasTvWithTouchpadForEachPassenger() + "]";
	}
}
