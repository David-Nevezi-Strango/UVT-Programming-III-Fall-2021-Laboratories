package Laboratory4;

public class FightAirplane extends Airplane {
	boolean canCamouflage;
	double ammoCapacity;

	public FightAirplane(String producer, int code, int numberOfEndedFlights, double combustibleCapacity,
			boolean canCamouflage, double ammoCapacity) {
		super(producer, code, numberOfEndedFlights, combustibleCapacity);
		this.canCamouflage = canCamouflage;
		this.ammoCapacity = ammoCapacity;
	}

	@Override
	public String toString() {
		return "FightAirplane [canCamouflage=" + canCamouflage + ", ammoCapacity=" + ammoCapacity + ", producer="
				+ producer + ", code=" + code + ", numberOfEndedFlights=" + numberOfEndedFlights
				+ ", combustibleCapacity=" + combustibleCapacity + "]";
	}
}
