package livematch.api.exception;
public class BizException extends RuntimeException {

	private static final long serialVersionUID = 1278381126613027917L;
	
	private String 	exCode;
	private String	exMsg;
	
	public BizException(String exCode) {
		this.exCode = exCode;
	}

	public BizException(String exCode, String exMsg) {
		this.exCode = exCode;
		this.exMsg = exMsg;
	}

	public String getExCode() {
		return this.exCode;
	}

	public String getExMsg() {
		return this.exMsg;
	}
}
