
class Fnlz {
	    static    int idCounter;
	    static    int population;
	    protected int blobId;

	    Fnlz() {
	        blobId = idCounter++;
	        ++population;
	    }
	    protected void finalize() throws Throwable {      // (2)
	        --population;
	        super.finalize();
	    }
	}

	public class FnlzC extends Fnlz {                        // (3)
	    int[] fat;

	    FnlzC(int bloatedness) {                           // (4)
	        fat = new int[bloatedness];
	        System.out.println(blobId + ": Hello");
	    }

	    protected void finalize() throws Throwable {      // (5)
	        System.out.println(blobId + ": Bye");
	        super.finalize();
	    }
	
	public static void main(String[] args) {          // (6)
	        
		int blobsRequired, blobSize;
	        
	    blobsRequired = 2;
	    blobSize      = 3;
	        
	    System.err.println("Usage: Finalizers <number of blobs> <blob size>");
	        
	    for (int i=0; i<blobsRequired; ++i) {         // (7)
	        new FnlzC(blobSize);
	    }
	    
	    System.out.println(FnlzC.population + " blobs alive"); // (8)
	    
	}
}