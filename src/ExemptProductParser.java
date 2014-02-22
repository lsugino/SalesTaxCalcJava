import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ExemptProductParser {
	private ArrayList<String> exemptArray;
	
	public ExemptProductParser (File exemptList) {
		ArrayList<String> exemptArr = new ArrayList<String>();
		exemptArray = exemptParser(exemptList, exemptArr);
		
        /* Print out test */
//		exemptToString(exemptArray);
	}
	
	public ArrayList<String> exemptParser (File exemptList, ArrayList<String> exemptArr) {
        try {
        	Scanner in = new Scanner(exemptList);
        	while (in.hasNextLine()){
        	    exemptArr.add(in.nextLine());
        	}
        	    Collections.sort(exemptArr);
        	for(int i=0; i<exemptArr.size(); ++i){
//        		System.out.println(exemptArr.get(i));
        	}
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return exemptArr;
	}
	
	public void exemptToString(ArrayList<String> exemptArray) {
		System.out.println(exemptArray.get(0) + " " + exemptArray.get(1) +" " + exemptArray.get(2) +" " + exemptArray.get(3) + " " + exemptArray.get(4) +" " + exemptArray.get(5));
	}
	
    public ArrayList<String> getExemptArray() {
    	return exemptArray;
    }

}
