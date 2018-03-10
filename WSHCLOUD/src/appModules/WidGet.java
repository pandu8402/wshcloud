package appModules;

import PageObjects.Collections_Page;

public class WidGet<E> 
{
  E ele;
  
  WidGet(E ele)
  {
	  this.ele = ele;
  }
  
  
  public E isWidgetPresent()
  {
	  return ele;
  }
  
}
