package livematch.api.model;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class SysVO implements Serializable{
	
	/** Registrant Id */
	private String	regrId;

	/** Registrant Name */
	private String	regrNm;

	/** Regist DateTime */
	private Timestamp	regDt;

}

