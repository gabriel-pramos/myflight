package pucrs.myflight.modelo;

public class Geo {
	private double latitude;
	private double longitude;
	
	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public static double distancia(Geo g1, Geo g2) {
		int r = 6371;

		double lat1 = Math.toRadians(g1.getLatitude());
		double lon1 = Math.toRadians(g1.getLongitude());
		double lat2 = Math.toRadians(g2.getLatitude());
		double lon2 = Math.toRadians(g2.getLongitude());
		
		return 2 * r * Math.asin(
			Math.sqrt(
				Math.pow( (lat1-lat2)/2 , 2) +
				Math.pow( (lon1-lon2)/2 , 2) * Math.cos(lat1) * Math.cos(lat2)
			)
		);
	}

	public double distancia(Geo g2) {
		int r = 6371;

		double lat1 = Math.toRadians(this.getLatitude());
		double lon1 = Math.toRadians(this.getLongitude());
		double lat2 = Math.toRadians(g2.getLatitude());
		double lon2 = Math.toRadians(g2.getLongitude());
		
		return 2 * r * Math.asin(
			Math.sqrt(
				Math.pow( (lat1-lat2)/2 , 2) +
				Math.pow( (lon1-lon2)/2 , 2) * Math.cos(lat1) * Math.cos(lat2)
			)
		);
	}


	@Override
	public String toString() {
		return "{" +
			" latitude='" + getLatitude() + "'" +
			", longitude='" + getLongitude() + "'" +
			"}";
	}

}
