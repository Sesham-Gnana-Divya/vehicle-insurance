package com.divya.service;

import com.divya.service.Impl.GuiceServiceImpl;
import com.google.inject.ImplementedBy;

@ImplementedBy(GuiceServiceImpl.class)
public interface GuiceService {
	public String sayHello();
	
}
