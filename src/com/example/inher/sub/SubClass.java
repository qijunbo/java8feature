package com.example.inher.sub;

import com.example.inher.BaseClass;

public class SubClass extends BaseClass {

	public void testMethod(){
		
		 this.protectedMethod();
		 
		 BaseClass base = new BaseClass();
		 //base.defaultMethod();
		 //base.protectedMethod();
		 
		  
	}
}
