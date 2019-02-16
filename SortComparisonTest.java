import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Shengyuan Liu 
 *  @version HT 2019
 */
/** 
 * result                          InsertionSort                QuickSort              MergeSortIterative               MergeSortRecursive         SelectionSort
 * 10 numbers                        0.474621                   0.0410235                0.006929                           0.0054705                 0.003282
 * 100 numbers                       0.09499975                 0.109866                 0.0260745                          0.0278975                 0.069653
 * 1000 numbers                      5.25164125                 1.838495                 0.3299301                          0.1429322                 2.2678315
 * 1000 DUPLICATE numbers            0.5667341                  2.360093                 0.05089672                         0.04018592                0.2234502
 * 1000 Nearly Ordered numbers       0.2300046                  0.17932993               0.053637                           0.03829713                1.487153
 * 1000 Reverse numbers              0.3186237                  0.17578213               0.054336                           0.03282                   0.164738
 * 1000 Sorted numbers               0.193641                   0.175302                 0.05332937                         0.033279                  0.1682249
 * 
 */
/**
 *  a. Which of the sorting algorithms does the order of input have an impact on? Why? 
 *  the selection Sort. cause the selection need to find the element one by one until get the smallest one.
 * 
 *  b. Which algorithm has the biggest difference between the best and worst performance, based
    on the type of input, for the input of size 1000? Why?
    the insertionSort has the  biggest difference between the best and worst performance. because the insertion Sort need to compare and move the element once in 
    each time, so the large unsorted data for it is a heavy work. its working has a large improve.
    
*   c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
    based on the input size? Please consider only input files with random order for this answer. 
*       the MergeSortRecursive Sort. Cause its algorithm is much higher than the other.
*       
*   d. Did you observe any difference between iterative and recursive implementations of merge sort?
    Yes,i did. they all sorts quickly in the sorted and¡¡reverse data. But both of them calculate time have a large improve in the Unsorted 1000 data, and iterative 
    is bigger than the recursive¡£
       
*    e. Which algorithm is the fastest for each of the 7 input files? 
*     1. SelectionSort 2.MergeSortIterative 3.MergeSortRecursive 4.MergeSortRecursive 5.MergeSortRecursive 6.MergeSortRecursive 7.MergeSortRecursive
 */

@RunWith(JUnit4.class)
public class SortComparisonTest
{
    
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] arrayList = new double[0];
    	arrayList = SortComparison.insertionSort(arrayList);
		assertEquals( "InsertionSort array check", "", toString(arrayList) );
		
		arrayList = new double[0];
    	arrayList = SortComparison.quickSort(arrayList);
		assertEquals( "QuickSort array check", "", toString(arrayList) );
		
		arrayList = new double[0];
    	arrayList = SortComparison.mergeSortIterative(arrayList);
		assertEquals( "MergeSortIterative array check", "", toString(arrayList) );
    	
		arrayList = new double[0];
    	arrayList = SortComparison.mergeSortRecursive(arrayList);
		assertEquals( "MergeSortRecursive array check", "", toString(arrayList) );
		
		arrayList = new double[0];
    	arrayList = SortComparison.selectionSort(arrayList);
		assertEquals( "SelectionSort array check", "", toString(arrayList) );
    }
    
    
   
    public static String toString(double a[])
	{   
    	StringBuilder testArray = new StringBuilder();
    	String result;
		if(a.length<=0)
		{
			return "";
		}
		
		testArray.append(a[0]);
		for(int i=1;i<a.length;i++)
		{
			testArray.append(","+a[i]);
		}
	    result=testArray.toString();
	    
	    return result;

	}
    
    
    
    @Test
    public void test10()
    {
    	double[]arrayList1= {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63};
    	double[]testArray;
    	testArray=arrayList1;
    	testArray=SortComparison.insertionSort(testArray);
    	assertEquals( "InsertionSort array check", "1518.63,1522.08,1735.31,1934.75,2377.88,2910.66,4849.83,5855.37,8106.23,8458.14", toString(testArray) );
    
    	double[]arrayList2= {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63};
    	testArray=arrayList2;
    	testArray=SortComparison.quickSort(testArray);
    	assertEquals( "QuickSort array check", "1518.63,1522.08,1735.31,1934.75,2377.88,2910.66,4849.83,5855.37,8106.23,8458.14", toString(testArray) );
    	
    	double[]arrayList3= {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63};
    	testArray=arrayList3;
    	testArray=SortComparison.mergeSortIterative(testArray);
    	assertEquals( "MergeSortIterative array check", "1518.63,1522.08,1735.31,1934.75,2377.88,2910.66,4849.83,5855.37,8106.23,8458.14", toString(testArray) );
    	
    	double[]arrayList4= {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63};
    	testArray=arrayList4;
    	testArray=SortComparison.mergeSortRecursive(testArray);
    	assertEquals( "MergeSortRecursive array check", "1518.63,1522.08,1735.31,1934.75,2377.88,2910.66,4849.83,5855.37,8106.23,8458.14", toString(testArray) );
    	
    	double[]arrayList5= {2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63};
    	testArray=arrayList5;
    	testArray=SortComparison.selectionSort(testArray);
    	assertEquals( "SelectionSort array check", "1518.63,1522.08,1735.31,1934.75,2377.88,2910.66,4849.83,5855.37,8106.23,8458.14", toString(testArray) );
    	
    }
    
    
    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static final String TEST10 = "numbers10.txt";
	public static final String TEST100 = "numbers100.txt";
	public static final String TEST1000 = "numbers1000.txt";
	public static final String TEST1000DUPLICATE = "numbers1000Duplicates.txt";
	public static final String TEST1000NEARLYORDERED = "numbersNearlyOrdered1000.txt";
	public static final String TEST1000REVERSE = "numbersReverse1000.txt";
	public static final String TEST1000SORTED = "numbersSorted1000.txt";
	
	
    public static void main(String[] args)
    { 
    	
    	try {
    	 String tempString;
    	 double[] arrayList=new double[10];
    	 int i;
    	 i=0;
		 BufferedReader newText= new BufferedReader(new FileReader(TEST10));
		 tempString=newText.readLine();
			while (tempString!=null)
			{
				double temp;
				temp=Double.parseDouble(tempString);
				arrayList[i]=temp;
				i++;
				tempString=newText.readLine();
			}
			newText.close();
		//10 number test
		double[] testArray1=new double[10];
		testArray1=arrayList;
		
		long start=System.nanoTime();
		testArray1=SortComparison.insertionSort(testArray1);
		long end=System.nanoTime();
		double usingTime=(end-start)/1000000.0;
		System.out.println("The total Result of 10 Numbers.");
		System.out.println("InsertionSort"+usingTime+"ms");
		
			
		double[] testArray2=new double[10];
		testArray2=arrayList;
		
		start=System.nanoTime();
		testArray2=SortComparison.quickSort(testArray2);
	    end=System.nanoTime();
	    usingTime=(end-start)/1000000.0;
		System.out.println("QuickSort"+usingTime+"ms");
		
		
		double[] testArray3=new double[10];
		testArray3=arrayList;
		
		start=System.nanoTime();
		testArray3=SortComparison.mergeSortIterative(testArray3);
	    end=System.nanoTime();
	    usingTime=(end-start)/1000000.0;
		System.out.println("MergeSortIterative"+usingTime+"ms");
			
		double[] testArray4=new double[10];
		testArray4=arrayList;
		
		start=System.nanoTime();
		testArray4=SortComparison.mergeSortRecursive(testArray4);
	    end=System.nanoTime();
	    usingTime=(end-start)/1000000.0;
		System.out.println("MergeSortRecursive"+usingTime+"ms");
		
		double[] testArray5=new double[10];
		testArray5=arrayList;
		
		start=System.nanoTime();
		testArray5=SortComparison.selectionSort(testArray5);
	    end=System.nanoTime();
	    usingTime=(end-start)/1000000.0;
		System.out.println("SelectionSort"+usingTime+"ms");
		
		
		//100 number text
		arrayList=new double[100];
   	    i=0;
		 newText= new BufferedReader(new FileReader(TEST100));
		 tempString=newText.readLine();
			while (tempString!=null)
			{
				double temp;
				temp=Double.parseDouble(tempString);
				arrayList[i]=temp;
				i++;
				tempString=newText.readLine();
			}
			newText.close();
			
		double[] testArray6=new double[100];
		testArray6=arrayList;
		
		start=System.nanoTime();
		testArray6=SortComparison.insertionSort(testArray6);
		end=System.nanoTime();
	    usingTime=(end-start)/1000000.0;
		System.out.println("The total Result of 100 Numbers.");
		System.out.println("InsertionSort"+usingTime+"ms");
		
			
		double[] testArray7=new double[100];
		testArray7=arrayList;
		
		start=System.nanoTime();
		testArray7=SortComparison.quickSort(testArray7);
	    end=System.nanoTime();
	    usingTime=(end-start)/1000000.0;
		System.out.println("QuickSort"+usingTime+"ms");
		
		
		double[] testArray8=new double[100];
		testArray8=arrayList;
		
		start=System.nanoTime();
		testArray8=SortComparison.mergeSortIterative(testArray8);
	    end=System.nanoTime();
	    usingTime=(end-start)/1000000.0;
		System.out.println("MergeSortIterative"+usingTime+"ms");
			
		double[] testArray9=new double[100];
		testArray9=arrayList;
		
		start=System.nanoTime();
		testArray9=SortComparison.mergeSortRecursive(testArray9);
	    end=System.nanoTime();
	    usingTime=(end-start)/1000000.0;
		System.out.println("MergeSortRecursive"+usingTime+"ms");
		
		double[] testArray10=new double[100];
		testArray10=arrayList;
		
		start=System.nanoTime();
		testArray10=SortComparison.selectionSort(testArray10);
	    end=System.nanoTime();
	    usingTime=(end-start)/1000000.0;
		System.out.println("SelectionSort"+usingTime+"ms");
		
		//1000 number text
		arrayList=new double[1000];
		   	    i=0;
				 newText= new BufferedReader(new FileReader(TEST1000));
				 tempString=newText.readLine();
					while (tempString!=null)
					{
						double temp;
						temp=Double.parseDouble(tempString);
						arrayList[i]=temp;
						i++;
						tempString=newText.readLine();
					}
					newText.close();
					
				double[] testArray11=new double[1000];
				testArray11=arrayList;
				
				start=System.nanoTime();
				testArray11=SortComparison.insertionSort(testArray11);
				end=System.nanoTime();
			    usingTime=(end-start)/1000000.0;
				System.out.println("The total Result of 1000 Numbers.");
				System.out.println("InsertionSort"+usingTime+"ms");
				
					
				double[] testArray12=new double[1000];
				testArray12=arrayList;
				
				start=System.nanoTime();
				testArray12=SortComparison.quickSort(testArray12);
			    end=System.nanoTime();
			    usingTime=(end-start)/1000000.0;
				System.out.println("QuickSort"+usingTime+"ms");
				
				
				double[] testArray13=new double[1000];
				testArray13=arrayList;
				
				start=System.nanoTime();
				testArray13=SortComparison.mergeSortIterative(testArray13);
			    end=System.nanoTime();
			    usingTime=(end-start)/1000000.0;
				System.out.println("MergeSortIterative"+usingTime+"ms");
					
				double[] testArray14=new double[1000];
				testArray14=arrayList;
				
				start=System.nanoTime();
				testArray14=SortComparison.mergeSortRecursive(testArray14);
			    end=System.nanoTime();
			    usingTime=(end-start)/1000000.0;
				System.out.println("MergeSortRecursive"+usingTime+"ms");
				
				double[] testArray15=new double[1000];
				testArray15=arrayList;
				
				start=System.nanoTime();
				testArray15=SortComparison.selectionSort(testArray15);
			    end=System.nanoTime();
			    usingTime=(end-start)/1000000.0;
				System.out.println("SelectionSort"+usingTime+"ms");
				
				
			//1000 number text
				arrayList=new double[1000];
				   	    i=0;
						 newText= new BufferedReader(new FileReader(TEST1000DUPLICATE));
						 tempString=newText.readLine();
							while (tempString!=null)
							{
								double temp;
								temp=Double.parseDouble(tempString);
								arrayList[i]=temp;
								i++;
								tempString=newText.readLine();
							}
							newText.close();
							
						double[] testArray16=new double[1000];
						testArray16=arrayList;
						
						start=System.nanoTime();
						testArray16=SortComparison.insertionSort(testArray16);
						end=System.nanoTime();
					    usingTime=(end-start)/1000000.0;
						System.out.println("The total Result of 1000 DUPLICATE Numbers.");
						System.out.println("InsertionSort"+usingTime+"ms");
						
							
						double[] testArray17=new double[1000];
						testArray17=arrayList;
						
						start=System.nanoTime();
						testArray17=SortComparison.quickSort(testArray17);
					    end=System.nanoTime();
					    usingTime=(end-start)/1000000.0;
						System.out.println("QuickSort"+usingTime+"ms");
						
						
						double[] testArray18=new double[1000];
						testArray18=arrayList;
						
						start=System.nanoTime();
						testArray18=SortComparison.mergeSortIterative(testArray18);
					    end=System.nanoTime();
					    usingTime=(end-start)/1000000.0;
						System.out.println("MergeSortIterative"+usingTime+"ms");
							
						double[] testArray19=new double[1000];
						testArray19=arrayList;
						
						start=System.nanoTime();
						testArray19=SortComparison.mergeSortRecursive(testArray19);
					    end=System.nanoTime();
					    usingTime=(end-start)/1000000.0;
						System.out.println("MergeSortRecursive"+usingTime+"ms");
						
						double[] testArray20=new double[1000];
						testArray20=arrayList;
						
						start=System.nanoTime();
						testArray20=SortComparison.selectionSort(testArray20);
					    end=System.nanoTime();
					    usingTime=(end-start)/1000000.0;
						System.out.println("SelectionSort"+usingTime+"ms");
						
						
				//1000 number text
						arrayList=new double[1000];
						   	    i=0;
								 newText= new BufferedReader(new FileReader(TEST1000NEARLYORDERED));
								 tempString=newText.readLine();
									while (tempString!=null)
									{
										double temp;
										temp=Double.parseDouble(tempString);
										arrayList[i]=temp;
										i++;
										tempString=newText.readLine();
									}
									newText.close();
									
								double[] testArray21=new double[1000];
								testArray21=arrayList;
								
								start=System.nanoTime();
								testArray21=SortComparison.insertionSort(testArray21);
								end=System.nanoTime();
							    usingTime=(end-start)/1000000.0;
								System.out.println("The total Result of 1000 NEARLY ORDERED Numbers.");
								System.out.println("InsertionSort"+usingTime+"ms");
								
									
								double[] testArray22=new double[1000];
								testArray22=arrayList;
								
								start=System.nanoTime();
								testArray22=SortComparison.quickSort(testArray22);
							    end=System.nanoTime();
							    usingTime=(end-start)/1000000.0;
								System.out.println("QuickSort"+usingTime+"ms");
								
								
								double[] testArray23=new double[1000];
								testArray23=arrayList;
								
								start=System.nanoTime();
								testArray23=SortComparison.mergeSortIterative(testArray23);
							    end=System.nanoTime();
							    usingTime=(end-start)/1000000.0;
								System.out.println("MergeSortIterative"+usingTime+"ms");
									
								double[] testArray24=new double[1000];
								testArray24=arrayList;
								
								start=System.nanoTime();
								testArray24=SortComparison.mergeSortRecursive(testArray24);
							    end=System.nanoTime();
							    usingTime=(end-start)/1000000.0;
								System.out.println("MergeSortRecursive"+usingTime+"ms");
								
								double[] testArray25=new double[1000];
								testArray25=arrayList;
								
								start=System.nanoTime();
								testArray25=SortComparison.selectionSort(testArray25);
							    end=System.nanoTime();
							    usingTime=(end-start)/1000000.0;
								System.out.println("SelectionSort"+usingTime+"ms");
								
					//1000 number text
								arrayList=new double[1000];
								   	    i=0;
										 newText= new BufferedReader(new FileReader(TEST1000REVERSE));
										 tempString=newText.readLine();
											while (tempString!=null)
											{
												double temp;
												temp=Double.parseDouble(tempString);
												arrayList[i]=temp;
												i++;
												tempString=newText.readLine();
											}
											newText.close();
											
										double[] testArray26=new double[1000];
										testArray26=arrayList;
										
										start=System.nanoTime();
										testArray26=SortComparison.insertionSort(testArray26);
										end=System.nanoTime();
									    usingTime=(end-start)/1000000.0;
										System.out.println("The total Result of 1000 REVERSE Numbers.");
										System.out.println("InsertionSort"+usingTime+"ms");
										
											
										double[] testArray27=new double[1000];
										testArray27=arrayList;
										
										start=System.nanoTime();
										testArray27=SortComparison.quickSort(testArray27);
									    end=System.nanoTime();
									    usingTime=(end-start)/1000000.0;
										System.out.println("QuickSort"+usingTime+"ms");
										
										
										double[] testArray28=new double[1000];
										testArray28=arrayList;
										
										start=System.nanoTime();
										testArray28=SortComparison.mergeSortIterative(testArray28);
									    end=System.nanoTime();
									    usingTime=(end-start)/1000000.0;
										System.out.println("MergeSortIterative"+usingTime+"ms");
											
										double[] testArray29=new double[1000];
										testArray29=arrayList;
										
										start=System.nanoTime();
										testArray29=SortComparison.mergeSortRecursive(testArray29);
									    end=System.nanoTime();
									    usingTime=(end-start)/1000000.0;
										System.out.println("MergeSortRecursive"+usingTime+"ms");
										
										double[] testArray30=new double[1000];
										testArray30=arrayList;
										
										start=System.nanoTime();
										testArray30=SortComparison.selectionSort(testArray30);
									    end=System.nanoTime();
									    usingTime=(end-start)/1000000.0;
										System.out.println("SelectionSort"+usingTime+"ms");
										
									
							//1000 number text
										arrayList=new double[1000];
										   	    i=0;
												 newText= new BufferedReader(new FileReader(TEST1000SORTED));
												 tempString=newText.readLine();
													while (tempString!=null)
													{
														double temp;
														temp=Double.parseDouble(tempString);
														arrayList[i]=temp;
														i++;
														tempString=newText.readLine();
													}
													newText.close();
													
												double[] testArray31=new double[1000];
												testArray31=arrayList;
												
												start=System.nanoTime();
												testArray31=SortComparison.insertionSort(testArray31);
												end=System.nanoTime();
											    usingTime=(end-start)/1000000.0;
												System.out.println("The total Result of 1000 REVERSE Numbers.");
												System.out.println("InsertionSort"+usingTime+"ms");
												
													
												double[] testArray32=new double[1000];
												testArray32=arrayList;
												
												start=System.nanoTime();
												testArray32=SortComparison.quickSort(testArray32);
											    end=System.nanoTime();
											    usingTime=(end-start)/1000000.0;
												System.out.println("QuickSort"+usingTime+"ms");
												
												
												double[] testArray33=new double[1000];
												testArray33=arrayList;
												
												start=System.nanoTime();
												testArray33=SortComparison.mergeSortIterative(testArray33);
											    end=System.nanoTime();
											    usingTime=(end-start)/1000000.0;
												System.out.println("MergeSortIterative"+usingTime+"ms");
													
												double[] testArray34=new double[1000];
												testArray34=arrayList;
												
												start=System.nanoTime();
												testArray34=SortComparison.mergeSortRecursive(testArray34);
											    end=System.nanoTime();
											    usingTime=(end-start)/1000000.0;
												System.out.println("MergeSortRecursive"+usingTime+"ms");
												
												double[] testArray35=new double[1000];
												testArray35=arrayList;
												
												start=System.nanoTime();
												testArray35=SortComparison.selectionSort(testArray35);
											    end=System.nanoTime();
											    usingTime=(end-start)/1000000.0;
												System.out.println("SelectionSort"+usingTime+"ms");
												
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
        //TODO: implement this method
    }

}

