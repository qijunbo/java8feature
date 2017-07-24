package com.example.inher;

public class ClassInSamePackage {
	
	public void testMethod(){
		
		BaseClass base = new BaseClass();
		base.defaultMethod();
		base.protectedMethod();
	}

}
