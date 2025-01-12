package livematch.api.exception;

public class SystemException extends RuntimeException {

	private static final long serialVersionUID = -3455712968046351864L;

	private int exCode;

	public SystemException(int exCode) {
		this.exCode = exCode;
	}

	public int getExCode() {
		return this.exCode;
	}
}
