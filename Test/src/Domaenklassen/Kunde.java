package Domaenklassen;


public class Kunde implements IKunde {
	
	private String name;
	private String vorname;
	private boolean surfschein;
	private boolean segelschein;
	private boolean motorbootschein;
	private String email;



	public Kunde(String name, String vorname, String email, Boolean surfschein, Boolean segelschein, Boolean motorbootschein) {

		this.name = name;
		this.vorname = vorname;
		this.surfschein = surfschein;
		this.segelschein = segelschein;
		this.motorbootschein = motorbootschein;
		this.email = email;

	}
	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#getVorname()
	 */
	@Override
	public String getVorname() {
		return vorname;
	}

	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#setVorname(java.lang.String)
	 */
	@Override
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#getKundennummer()
	 */
	@Override
	public int getKundennummer() {
		return kundennummer;
	}
	
	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#isSurfschein()
	 */
	@Override
	public boolean isSurfschein() {
		return surfschein;
	}
	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#setSurfschein(boolean)
	 */
	@Override
	public void setSurfschein(boolean surfschein) {
		this.surfschein = surfschein;
	}
	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#isSegelschein()
	 */
	@Override
	public boolean isSegelschein() {
		return segelschein;
	}
	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#setSegelschein(boolean)
	 */
	@Override
	public void setSegelschein(boolean segelschein) {
		this.segelschein = segelschein;
	}
	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#isMotorbootschein()
	 */
	@Override
	public boolean isMotorbootschein() {
		return motorbootschein;
	}
	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#setMotorbootschein(boolean)
	 */
	@Override
	public void setMotorbootschein(boolean motorbootschein) {
		this.motorbootschein = motorbootschein;
	}

	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#drucken()
	 */
	@Override
	public void drucken(){
		System.out.println("\n" + this.kundennummer + ": " + this.name + ", " + this.vorname) ;
	}
	
	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#toString()
	 */
	@Override
	@Override
	public String toString(){
		return this.kundennummer + ";" + this.name + ";" + this.vorname + ";" + this.segelschein + ";" + this.surfschein + ";" + this.motorbootschein + ";".toString(); 
	}
	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#getEmail()
	 */
	@Override
	public String getEmail() {
		return email;
	}
	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#getSurfschein()
	 */
	@Override
	public boolean getSurfschein() {
		return surfschein;
	}
	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#getSegelschein()
	 */
	@Override
	public boolean getSegelschein() {
		return segelschein;
	}
	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#getMotorbootschein()
	 */
	@Override
	public boolean getMotorbootschein() {
		return motorbootschein;
	}
	/* (non-Javadoc)
	 * @see Domaenklassen.IKunde#setKundennummer(int)
	 */
	@Override
	public void setKundennummer(int nummer) {
		this.kundennummer = nummer;
	}

}
