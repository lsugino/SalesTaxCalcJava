import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ExemptProductParser {
	private ArrayList<String> exemptArray;
	
	/** Constructs Exempt Product Parser */
	public ExemptProductParser (File exemptList) {
		ArrayList<String> exemptArr = new ArrayList<String>();
		exemptArray = exemptParser(exemptList, exemptArr);
	}
	
	public ArrayList<String> exemptParser (File exemptList, ArrayList<String> exemptArr) {
        try {
        	Scanner in = new Scanner(exemptList);
        	while (in.hasNextLine()){
        	    exemptArr.add(in.nextLine());
        	}
        	    Collections.sort(exemptArr);
        	for(int i=0; i<exemptArr.size(); ++i){}
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return exemptArr;
	}
	
    public ArrayList<String> getExemptArray() {
    	return exemptArray;
    }

}
