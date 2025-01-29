

// Interface GFG
interface GFG {
	void learnCoding();
	void learnProgrammingLanguage();
	void contribute();
}

// Abstract class Student implementing from GFG interface
abstract class Student implements GFG {

	// Overriding the methods
	@Override public void learnCoding()
	{
		System.out.println(
			"Let's make coding a habit with GFG");
	}
	@Override public void learnProgrammingLanguage()
	{
		System.out.println(
			"Let's master all fundamentals of java with the help of GFG");
	}
}

// Extend the GEEK class by Student abstract class
class GEEK extends Student {
	@Override public void contribute()
	{
		System.out.println(
			"Now let's help others by contributing in GFG");
	}
}

// Driver code
public class Main {
	public static void main(String[] args)
	{
		// New GEEK object is created
		GEEK gfgStudent = new GEEK();

		// Calls to the multiple functions
		gfgStudent.learnCoding();
		gfgStudent.learnProgrammingLanguage();
		gfgStudent.contribute();
	}
}
