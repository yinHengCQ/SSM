package com.web.criterion;

import java.util.ArrayList;
import java.util.List;
 
/**
 * 
 * @author Administrator
 *
 */
public abstract class GeneratedCriteria {

	//要查询的列条件
	 protected List<Criterion> criteria;

     protected GeneratedCriteria() {
         super();
         criteria = new ArrayList<Criterion>();
     }

     /**
      * 是否有条件
      * @return true有条件,false无条件
      */
     public boolean isValid() {
         return criteria.size() > 0;
     }
 

     public List<Criterion> getCriteria() {
         return criteria;
     }

     protected void addCriterion(String condition) {
         if (condition == null) {
             throw new RuntimeException("Value for condition cannot be null");
         }
         criteria.add(new Criterion(condition));
     }

     protected void addCriterion(String condition, Object value) {
         if (value == null) {
             throw new RuntimeException("value for cannot be null");
         }
         criteria.add(new Criterion(condition, value));
     }

     protected void addBetweenAndCriterion(String condition, Object value1, Object value2) {
         if (value1 == null || value2 == null) {
             throw new RuntimeException("Between values for  cannot be null");
         }
         criteria.add(new Criterion(condition, value1, value2));
     }
     
     
     
     
     
}
