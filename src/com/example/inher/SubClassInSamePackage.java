package com.example.inher;

public class SubClassInSamePackage extends BaseClass{
	
	public void testMethod(){
		
		BaseClass base = new BaseClass();
		base.defaultMethod();
		base.protectedMethod();
		
		this.protectedMethod();
		this.defaultMethod();
	}

}
