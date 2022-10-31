package persistence;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "Passenger_Details")
public class Passenger {
	
	@Id
	@GeneratedValue
	private int Pid;
	private String Pfname;
	private String Plname;
	//private int Pmnum;
	private String Pmnum;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="Sid")
	private Source source;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="Did")
	private Dest dest;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="Aid")
	private Airline airline;
	
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getPfname() {
		return Pfname;
	}
	public void setPfname(String pfname) {
		Pfname = pfname;
	}
	public String getPlname() {
		return Plname;
	}
	public void setPlname(String plname) {
		Plname = plname;
	}
/*	public int getPmnum() {
		return Pmnum;
	}
	public void setPmnum(int pmnum) {
		Pmnum = pmnum;
		}
	*/
	public String getPmnum() {
		return Pmnum;
	}
	public void setPmnum(String pmnum) {
		Pmnum = pmnum;
	}
	
	
	
	
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public Dest getDest() {
		return dest;
	}
	public void setDest(Dest dest) {
		this.dest = dest;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
}
