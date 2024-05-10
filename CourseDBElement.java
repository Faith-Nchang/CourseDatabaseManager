
/**
 * CourseDBElement implements Comparable interface and consists of five attributes: 
 * the Course ID (a String), the CRN (an int), 
 * the number of credits (an int), the room number (a String), and the instructor name (a String)
 */
public class CourseDBElement implements Comparable{
	private String courseID;
	private int CRN;
	private int numOfCredits;
	private String roomNumber;
	private String instructorName;
	
	public CourseDBElement()
	{
		courseID = "";
		CRN =0;
		numOfCredits = 0;
		roomNumber = "";
		instructorName = "";
	}
	
	public CourseDBElement(String courseID, int CRN, int credits, String roomNumber, String instructor)
	{
		this.courseID = courseID;
		this.CRN = CRN;
		this.numOfCredits = credits;
		this.roomNumber = roomNumber;
		this.instructorName = instructor;
	}
	
	/**
	 * 
	 */
	@Override
	public int compareTo(Object o) {
		// cast the o Object
		CourseDBElement otherObject =  (CourseDBElement) o;
		String currentObject = this.courseID + " " + this.CRN + " " + this.numOfCredits + " " + this.roomNumber + " " +this.instructorName;
		String otherString = otherObject.courseID + " " + otherObject.CRN + " " + otherObject.numOfCredits + " " + otherObject.roomNumber + " " +otherObject.instructorName;
		
		if (currentObject.compareTo(otherString) < 0)
		{
			return -1;
		}
		else if (currentObject.compareTo(otherString) ==0)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
	/**
	 * gets the hashCode of the courseDBElement based on its CRN
	 * @return
	 */
	@Override
	public int hashCode()
	{
		String crn = Integer.toString(this.CRN);
		return crn.hashCode();
	}
	
	/**
	 * gets the CRN of the course
	 * @return
	 */
	public int getCRN()
	{
		return this.CRN;
	}
	
	
	/**
	 * gets the course id
	 * @return courseID
	 */
	public String getID()
	{
		return this.courseID;
	}
	
	
	/**
	 * gets the room number
	 * @return roomNumber
	 */
	public String getRoomNum()
	{
		return this.roomNumber;
	}
	
	
	/**
	 * gets the number of credits
	 * @return numOfCredits
	 */
	public int getCredits()
	{
		return this.numOfCredits;
	}
	
	
	/**
	 * gets the instructor name
	 * @return - instructorName
	 */
	public String getInstructor()
	{
		return this.instructorName;
	}
	
	
	/**
	 * updates the course id
	 * @param id - course id
	 */
	public void setID(String id)
	{
		this.courseID = id;
	}
	
	/**
	 * updates the crn
	 * @param crn - CRN
	 */
	public void setCRN(int crn)
	{
		this.CRN = crn;
	}
	/**
	 * Updates the room number
	 * @param rNum - roomNumber
	 */
	public void setRoomNum(String rNum)
	{
		this.roomNumber = rNum;
	}
	
	public void setInstructor(String name)
	{
		this.instructorName = name;
	}
	
	/**
	 * updates the number of credits
	 * @param credits - numOfCredits
	 */
	public void setCredits(int credits)
	{
		this.numOfCredits = credits;
	}
	
	/**
	 * all a course elements
	 * @return course fields
	 */
	@Override
	public String toString()
	{
		return "\nCourse:" + this.courseID + " CRN:" + this.CRN + " Credits:"+ this.numOfCredits + " Instructor:" 
				+ this.instructorName+" Room:" + this.roomNumber;// +"\n";
	}
}
