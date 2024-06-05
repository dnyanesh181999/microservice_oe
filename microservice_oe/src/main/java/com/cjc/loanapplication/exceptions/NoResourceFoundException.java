package com.cjc.loanapplication.exceptions;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.cjc.loanapplication.model.Enquiry;

public class NoResourceFoundException extends RuntimeException{
public NoResourceFoundException(String msg)
{
	super(msg);
}
}
