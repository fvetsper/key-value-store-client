package home.commons;

import java.util.ArrayList;
import java.util.List;


public class Response {
	private List<KeyValues> keyValuesList = new ArrayList<KeyValues>();
	private String errorMessage = null;
	private boolean hasError = false;

	public Response() {
	}
	
	public Response(boolean hasError, String errorMessage) {
		this.hasError = hasError;
		this.errorMessage = errorMessage;
	}
	
	
	public List<KeyValues> getKeyValues() {
		return keyValuesList;
	}

	public void addKeyValues(KeyValues keyValues) {
		keyValuesList.add(keyValues);
	}
	
	public void setKeyValuesList(List<KeyValues> keyValuesList) {
		this.keyValuesList = keyValuesList;
	}

	public void printAll() {
		if (hasError) {
			System.out.println(errorMessage);
		} else {
			for (KeyValues keyValues : keyValuesList) {
				System.out.println("key = "  + keyValues.getKey() + 
						" values = " + keyValues.getValues());
			}
		}
	}
	
	public void printKeysOnly() {
		if (hasError) {
			System.out.println(errorMessage);
		} else {
			for (KeyValues keyValues : keyValuesList) {
				System.out.println("key = "  + keyValues.getKey());
			}
		}
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}
	
}
