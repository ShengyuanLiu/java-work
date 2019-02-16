// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Shengyuan Liu
 *  @version HT 2019
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	double temp;
    	for(int i=1; i<a.length; i++)
		{
			for(int j=i;j>0;j--)
			{
				if(a[j]<a[j-1])
				{
					temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		return a;
        //todo: implement the sort
    }//end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
	      int length=a.length;
	     
	      sort(a,0,length-1);
	      
	      return a;
		 //todo: implement the sort

    }//end quicksort
    
   private static int partition(double a[], int low, int high) 
	{ 
    	double  exchange= a[high]; 
    	int i = (low-1);
		for (int j=low; j<high; j++) 
		{ 
			if (a[j] <= exchange) 
			{ 
				i++; 
				double temp = a[i]; 
				a[i] = a[j]; 
				a[j] = temp; 
			} 
		} 

		double temp = a[i+1]; 
		a[i+1] = a[high]; 
		a[high] = temp; 

		return i+1; 
	} 
    
    private static void sort(double a[], int low, int high) 
   	{ 
   		if (low < high) 
   		{ 
   			int temp = partition(a, low, high); 
   			sort(a, low, temp-1); 
   			sort(a, temp+1, high); 
   		} 
   	} 

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
         int length=a.length;
         double[] b=new double[length];
         int i,j;
         for(i=1;i<length;i=i+i)
         {
        	 for(j=0;j<length-i;j+=i+i)
        	 {
        		 if(j+i+i-1<=length-1)
        		 {
        			 mergeSortR(a,b,j,j+i-1,j+i+i-1);
        		 }
        		 else if(j+i+i-1>length-1)
        		 {
        			 mergeSortR(a,b,j,j+i-1,length-1);
        		 }
        	 }
         }
         return a;
		 //todo: implement the sort
	
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	int length=a.length;
         double[] b=new double[length];
         
         mergeSort(a,b,0,a.length-1);
         return a;
    	//todo: implement the sort
	
   }//end mergeSortRecursive
    	
    private static void mergeSort(double a[],double b[],int low,int high)
    {
    	int mid=low+(high-low)/2;
    	if(high<=low)
    	{
    		return;
    	}
    	mergeSort(a,b,low,mid);
    	mergeSort(a,b,mid+1,high);
    	
    	mergeSortR(a,b,low,mid,high);
    	
    	
    	
    }
    
    
    private static void mergeSortR(double a[],double b[],int low,int mid,int high)
    {
    	for(int k=low;k<=high;k++)
		{
			b[k] = a[k];
		}

		int i,j;
		i=low;
		j=mid+1;
		
		for(int k=low;k<=high;k++)
		{
			if(i>mid)
				{
				a[k] = b[j++];
				}
			else if(j>high)  
			{
				a[k] = b[i++];
			}
			else if(b[j]<b[i])
			{
				a[k] = b[j++];
			}
			else
				{
				a[k] = b[i++];
				}

		}
    }
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){

         for(int i=0;i<a.length-1;i++)
         {
        	 int min=i;
        	 for(int j=i+1;j<a.length;j++)
        	 {
        		 if(a[j]<a[min])
        		 {
        			 min=j;
        		 }
        	 }
        	 double temp=a[min];
        	 a[min]=a[i];
        	 a[i]=temp;
        	 
         }
         return a;

    }//end selectionsort

   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

 }//end class

