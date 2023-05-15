
public class finalClass {
	public static void main(String... a){
		System.out.println("final Class");
	}
}

class fClss{
	public final void method(){
		//do nothing;
	}
	
	final void test(){
		//do nothing
	}
}

class fSubClss extends fClss{
	public final void method(){
		//do nothing;
	}
	
	final void test(){
		//do nothing
	}
}