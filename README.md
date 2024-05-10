# CourseDatabaseManager
CourseDBManager: A program for managing course information. Incorporates robust exception handling for reliability and offers seamless file operations.

# classes
# Data Element - CourseDBElement
CourseDBElement implements Comparable interface and consists of five attributes: the Course ID (a String), the CRN (an int), the number of credits (an int), the room number (a String), and the instructor name (a String).   Normally the CourseDBElement will be an object consisting of these five attributes and is referred to as a CDE.

# Data Structure - CourseDBStructure 
You will be implementing a hash table with buckets. Each bucket will be an array of linked lists of CourseDBElements.  Each CourseDBElement object will have a hash code that is calculate based on the CRN, since the CRN is unique for courses.  Note that the CRN is an int, and the tests require the hashcode of a string, so you will need to coerce it to a String and take the hash code of the resulting string.  The add method of CourseDBStructure will take a CourseDBElement object and add it to the data structure based on the calculated hashcode. If a linked list at the relevant hash code doesn’t exist (the bucket is empty), create a LinkedList with the first element being the CourseDBElement object and add it to the HashTable. If the LinkedList already exists, add the CourseDBElement object to the existing list. 
Two constructors for the CourseDBStructure will be required, one that takes in an integer that is the estimated number of courses, the other is used for testing purposes.  The comments in the CourseDBStructureInterface (provided) should help you figure out how to set the length of the hash table. 

Note: In hash table structure with buckets the load factor can be larger than one and represents the average number of elements stored in each list, assuming that the hash function distributes elements uniformly over all positions. For this assignment use a load factor of 1.5.

This class has two constructors:
1)	A constructor that takes in an integer n which represents the estimated number of 
courses and determines the size of the hash table by finding a 4K+3 prime just greater than n /loading factor.
Example:  if n is 500 courses, then 500/1.5 = 333, The next 4K+3 prime over 333 is 347.  So, you would set the table a length to 347.

2)	A Constructor for testing purposes. This constructor will take a string “Testing” and an int for the hashtable size.  This is used only for testing.

 
# Data Manager - CourseDBManager
The data manager allows the user to read the courses from a file or to enter the data by hand and uses an Alert to print out the database elements. The input is read from a file or read from the textfields and is added to the data structure through the add method.  The add method uses the CDS ‘s add method. The CourseDBManager is also referred to as a CDM.

Exception Classes
IOException – created and thrown when user selects an input file that cannot be read or attempting to retrieve a CDE that does not exist in the DB.
