/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.datamelt.rules.implementation;

import com.datamelt.util.CheckAnnotation;
import com.datamelt.util.CheckMethodAnnotation;

/**
 * Checks if a string is contained in another string.
 * <p>
 * The first parameter of a given method is always the value of the field that shall be checked. The second parameter is either another field to check against 
 * or an expected value (fixed value) to check against the first value.
 * 
 * @author uwe geercken
 */
@CheckAnnotation(name="Check Contains", description="Check if one String contains another String",nameDescriptive="contains",checkSingleField=0)
public class CheckContains extends GenericCheck
{
	/**
	 * Checks if the string provided as the second parameter is contained in the string provided as the first parameter.
     *
     * @param value 		the first value for comparison
     * @param compareValue 	the second value for comparison - to compare against the first value
     * @return				indication if the compareValue is contained in the value
     */
	@CheckMethodAnnotation(note="The default is to compare the values case sensitive")
    public static boolean evaluate(String value,String compareValue)
    {
        if(value!=null && compareValue!=null)
        {
	    	int pos = value.indexOf(compareValue);
	        if(pos>-1)
	        {
	            return true; 
	        }
	        else
	        {
	            return false;
	        }
        }
        else
        {
        	return false;
        }
    }
    
    /**
	 * Checks if a string is contained in another string and ignores or does not ignore
	 * the case of the values.
	 *
     * @param value 		the first value for comparison
     * @param compareValue 	the second value for comparison - to compare against the first value
     * @param ignoreCase	indication if the case of the values shall be ignored for comparison
     * @return				indication if the compareValue is contained in the value
     */
	@CheckMethodAnnotation(note="The default is to compare the values case sensitive",noteParameter={"Ignore case differences during comparison"})
    public static boolean evaluate(String value,String compareValue, boolean ignoreCase)
    {
    	if(value!=null && compareValue!=null)
        {
	    	if(ignoreCase)
	        {
		    	int pos = value.toLowerCase().indexOf(compareValue.toLowerCase());
		        if(pos>-1)
		        {
		            return true; 
		        }
		        else
		        {
		            return false;
		        }
	        }
	        else
	        {
		    	int pos = value.indexOf(compareValue);
		        if(pos>-1)
		        {
		            return true; 
		        }
		        else
		        {
		            return false;
		        }
	        }
        }
        else
        {
        	return false;
        }

	}
}

