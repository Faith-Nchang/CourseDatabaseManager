import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure {
	private LinkedList<CourseDBElement>[] hashTable;
	private int tableSize = 0;
	private final double LOAD_FACTOR = 1.5;
	private int numberOfEntries;
	
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int numberOfCourses)
	{
		// gets the next 4k+3 prime number
		tableSize = fourKPlus3(numberOfCourses, LOAD_FACTOR);
		
		hashTable = new LinkedList[tableSize];
	}
	
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String test, int size)
	{
		tableSize = size;
		hashTable = new LinkedList[size];
		
	}

	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	public void add(CourseDBElement element)
	{
		// gets the index where the element will be added in the array from the crn and the array size
		int index = element.hashCode() % tableSize;
		boolean containsCourse = false;
		
		// checks if the current bucket is empty
		if (hashTable[index] == null)
		{
			hashTable[index] = new LinkedList<CourseDBElement>();
		}
		else
		{
			// checks if the bucket already contains the course
			
			for (CourseDBElement course: hashTable[index])
			{
				if (course.compareTo(element) == 0)
				{
					containsCourse = true;
					break;
				}
			}
		
		}
		
		// adds the course to the current bucket if courseElement is unique
		if (!containsCourse)
		{
			boolean containsCRN = false;
			int i = 0;
			// checks if the existing crn already exists
			for (i =0; i < hashTable[index].size(); i++)
			{
				if (hashTable[index].get(i).getCRN() == element.getCRN())
				{
					containsCRN = true;
					break;
				}
			}
			// updates the course with the existing crn
			if (containsCRN)
			{
				hashTable[index].set(i, element);
			}
			else
			{
				hashTable[index].add(element);
				numberOfEntries++;
			}
			
		}
	}
	
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn  (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */

	public CourseDBElement get(int crn) throws IOException
	{
		// gets the index of the bucket where a course with that crn will be located
		int index = Integer.toString(crn).hashCode() % tableSize;
		
		if (hashTable[index] == null)
		{
			throw new IOException();
		}
		else
		{
			
			// search through bucket
			for (CourseDBElement course: hashTable[index])
			{
				if (course.getCRN() == crn)
				{
					return course;
				}
			}
			//  throws an exception if a course with that crn is not in the bucket
			throw new IOException();
		}
	}
	
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	
	public ArrayList<String> showAll()
	{
		ArrayList<String> courses = new ArrayList<>();
		if (numberOfEntries == 0)
		{
			return courses;
		}
		else
		{
			String course;
			for (int i = 0; i < tableSize; i++)
			{
				if (hashTable[i] != null)
				{
					for (CourseDBElement currentCourse: hashTable[i])
					{
						// Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
						course = currentCourse.toString();
						
						// adds the current course to the array list of courses
						courses.add(course);
					}
						
				}
					
			}
		}
		return courses;
	}
	
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	* @return tableSize
	*/
	public int getTableSize()
	{
		return this.tableSize;
	}
	
	/**
	 * generates the next 4k+3 prime
	 * @param n - estimated number of courses
	 * @param loadfactor - 1.5
	 * @return 4k+3prime
	 */
	public static int fourKPlus3(int n, double loadfactor)
	{  boolean fkp3 = false;
	   boolean aPrime = false;
	   int prime, highDivisor, d;
	   prime = (int)(n/loadfactor);
	   if(prime % 2 == 0) // if even make odd
	      prime = prime +1;

	   while(fkp3 == false) // not a 4k+3 prime
	   {  while(aPrime == false) // not a prime
	      {  highDivisor = (int)(Math.sqrt(prime) + 0.5);
	         for(d = highDivisor; d > 1; d--)
	         {  if(prime % d == 0)
	               break; // not a prime
	         }
	         if(d != 1) // prime not found
	            prime = prime + 2;
	         else
	            aPrime = true;
	      } // end of the prime search loop
	      if((prime - 3) % 4 == 0)
	         fkp3 = true;
	      else
	      {  prime = prime + 2;
	         aPrime = false;
	      }
	   } // end of 4k+3 prime search loop
	   return prime;
	}

}
