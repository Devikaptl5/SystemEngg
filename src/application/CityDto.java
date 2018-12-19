package application; //bus data transfer object, its a template where the bus data is stored

import java.util.ArrayList;
import java.util.List;

public class CityDto {

	public String cname;
	
	public Integer cid;
	
	public CityDto(String cname, Integer cid) {
		this.cname = cname;
		this.cid = cid;
	}
}
