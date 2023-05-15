import java.util.List;
import java.util.ArrayList;


public class TestFinal {
	final ArrayList<String> l = null;
	public static void main(String a[]){
	final ArrayList al = new ArrayList();
	al.add("silpayan");
	al.add("Arundhati");
	al.add("test");
	System.out.println(al);
	al.remove(0);
	al.remove("silpayan");
	new TestFinal().copyList(al);
	System.out.println(al);
	//al = new ArrayList();
	final String s = new String();
	//s = new String();
	}
	
	void copyList(ArrayList<String> al){
		//l=new ArrayList<String>();
		this.l.addAll(al);
	}
}
