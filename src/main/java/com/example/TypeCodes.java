package com.example;


public enum TypeCodes {
	停止(1),
	起動(2);
	
	private int code;
	private TypeCodes(int typeCode){
		code = typeCode;
	}
	public int getCode(){
		return code;
	}

	public static TypeCodes valueOf(int code){
		for(TypeCodes typeCode : TypeCodes.values()){
			if(typeCode.getCode() == code)
				return typeCode;
		}
		return null;
	}
}
