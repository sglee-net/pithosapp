package temp;

public enum SqlOperator {
	EQ("="),
	LT("<"),
	LE("<="),
	NE("<>"),
	GE(">="),
	GT(">"),
	BETWEEN("BETWEEN"),
	LIKE("LIKE"),
	IN("IN");
	
	private String string;
	private Object object;
	
	SqlOperator(String _arg) {
		string = _arg;
	}
	
	String getString() {
		return string;
	}
	
	void setObject(Object _object) {
		object = _object;
	}
	
	Object getObject() {
		return object;
	}
}
