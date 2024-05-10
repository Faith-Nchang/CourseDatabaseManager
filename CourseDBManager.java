import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Data Manager
 */
public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure cds;
	private final int DEFAULT_SIZE = 500;
	
	public CourseDBManager()
	{
		cds = new CourseDBStructure(DEFAULT_SIZE);
	}
	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor)
	{
		CourseDBElement course = new CourseDBElement(id, crn, credits, roomNum, instructor);
		cds.add(course);
	}
	
	/**	
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	public CourseDBElement get(int crn)
	{
		try {
			return cds.get(crn);
		} catch (IOException e) {
			return null;
		}
	}
	
	
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	public void readFile(File input) throws FileNotFoundException
	{
		String[] courseInfo; // stores all the attributes of a course
		CourseDBElement course; 
		// input file
		Scanner inputFile = new Scanner(input);
		
		// loops through each course in the file
		while (inputFile.hasNext())	 
		{
			// gets each course, separate its attributes, and store them in an array
		  courseInfo = inputFile.nextLine().split(" ");
		  // gets each attribute of the course from the array
		  String id = courseInfo[0];
		  int crn = Integer.parseInt(courseInfo[1]);
		  int credits = Integer.parseInt(courseInfo[2]);
		  String roomNum = courseInfo[3];
		  String instructor = courseInfo[4];
		  if (courseInfo.length > 5)
		  {
			  for (int i = 5; i < courseInfo.length; i++)
			  {
				  instructor += " " + courseInfo[i];
			  }
		  }
		  
		  // creates a CourseDBElement from the course read 
		  course = new CourseDBElement(id, crn, credits, roomNum, instructor);
			// adds the course to the data structure  
		  cds.add(course);		  
			  
		 }
		 inputFile.close();
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
		return cds.showAll();
	 }
	
}
